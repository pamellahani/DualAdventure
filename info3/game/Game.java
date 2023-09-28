/*
 * Copyright (C) 2020  Pr. Olivier Gruber
 * Educational software for a basic game development
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Created on: March, 2020
 *      Author: Pr. Olivier Gruber
 */
package info3.game;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.RandomAccessFile;

import javax.swing.JFrame;
import javax.swing.JLabel;

import aut.Automate;
import aut.BasicAut;
import aut.AutDirection;
import graphics.GameCanvas;
import model.Utils.COLOR;
import model.Utils.Constants;
import model.entities.BluePlayer;
import model.entities.Entity;
import model.entities.RedPlayer;
import model.entities.Items.Coins;
import model.entities.Obstacles.Wall;
import model.entities.Obstacles.Bush;
import model.entities.enemies.Bat;
import model.entities.enemies.Snake;
import model.world.World;
import sound.RandomFileInputStream;
import view.*;
import view.entities.*;
//import view.entities.ShurikenView;
import view.entities.WallView;

public class Game {

	static Game game;

	public static void main(String args[]) throws Exception {
		try {
			System.out.println("Game starting...");
			game = new Game();
			System.out.println("Game started.");
		} catch (Throwable th) {
			th.printStackTrace(System.err);
		}
	}

	JFrame m_frame;
	JLabel m_text;
	GameCanvas m_canvas;
	CanvasListener m_listener;
	Sound m_music;

	// VIEW variables g
	BackGroundImage m_back;

	BackGroundImage m_back2;

	MiddleBar m_middleBar;

	BluePlayer m_player;
	RedPlayer m_player2;
	PlayerView m_playerview;
	StartView start;
	ShopView shop1;
	ShopView shop2;

	Wall m_wall_blue;
	Wall m_wall_red;
	DoorView m_door;
	
	Inventory inv1;
	Inventory inv2;
	World world;
	Bat m_bat;
	Coins m_coin;
	GameOverView over; 
	//Bush bush; 
	// ShurikenView m_shuriken;

	Game() throws Exception {

		// creating a listener for all the events
		// from the game canvas, that would be
		// the controller in the MVC pattern
		m_listener = new CanvasListener(this);
		// creating the game canvas to render the game,
		// that would be a part of the view in the MVC pattern
		m_canvas = new GameCanvas(m_listener);
		m_canvas.addMouseListener(m_listener);

		System.out.println("  - creating frame...");
		Dimension d = new Dimension(1024, 768);
		m_frame = m_canvas.createFrame(d);
		ViewToolKit.initInstance();
		this.m_frame.setResizable(false);


		this.start = new StartView(1);
		
		// Création du Shop
		this.shop1 = new ShopView(1);
		this.shop2 = new ShopView(2);
		
		

		// Création du BluePlayer
		this.m_player = new BluePlayer();
		this.m_player2 = new RedPlayer();
		
		ViewPrinter.getMiddleBar().setPlayers(m_player, m_player2);
		m_player.coeq = m_player2; 
		m_player2.coeq = m_player; 
		// this.m_playerview = new BluePlayerView(1);
		this.world = new World(m_player, m_player2);
		m_player.map = world;
		m_player2.map = world;
		
		
		// Wall pour empêcher le joueur d'aller à gauche
		m_wall_blue = new Wall(150, 100, COLOR.BLUE, 1, m_player.map);
		m_wall_red = new Wall(150, 100, COLOR.RED, 2, m_player2.map);
		m_bat = new Bat(600,240,1,m_player.map);
		
		//m_coin = new Coins(700, 248, 1);
		//world.generateInitialWorld(null, m_player, 0, Constants.BLUEGROUND_Y);
		m_player.map.getBucketPlayer(COLOR.BLUE).listObstacles.add(m_wall_blue);
		m_player2.map.getBucketPlayer(COLOR.RED).listObstacles.add(m_wall_red);
		m_player.map.getBucketPlayer(COLOR.BLUE).listEnemies.add(m_bat);
		
		//m_player.map.getBucketPlayer(COLOR.BLUE).listItems.add(m_coin);
		//m_wall = new Wall(150,280,COLOR.BLUE,1);
		
		// Création de la vue du Mur
		// this.m_wall = new WallView(1,wall);
		// Création de la vue de la Porte
		this.inv1 = new Inventory(1);
		this.inv2 = new Inventory(2);
		
		this.over = new GameOverView(1); 
		over.setPlayers(m_player, m_player2);
		// creating a cowboy, that would be a model
		// in an Model-View-Controller pattern (MVC)
		// m_cowboy = new Cowboy(1);

		// frame need to be set up before initiating screen
		System.out.println("  - setting up the frame...");
		setupFrame();
	}

	/*
	 * Then it lays out the frame, with a border layout, adding a label to the north
	 * and the game canvas to the center.
	 */
	private void setupFrame() {

		m_frame.setTitle("Game");
		m_frame.setLayout(new BorderLayout());

		m_frame.add(m_canvas, BorderLayout.CENTER);

		m_text = new JLabel();
		m_text.setText("Tick: 0ms FPS=0");
		m_frame.add(m_text, BorderLayout.NORTH);

		// center the window on the screen
		m_frame.setLocationRelativeTo(null);

		// make the vindow visible
		m_frame.setVisible(true);
	}

	/*
	 * ================================================================ All the
	 * methods below are invoked from the GameCanvas listener, once the window is
	 * visible on the screen.
	 * ==============================================================
	 */

	/*
	 * Called from the GameCanvas listener when the frame
	 */
	String m_musicName;

	void loadMusic() {
		m_musicName = m_musicNames[m_musicIndex];
		String filename = "resources/" + m_musicName + ".ogg";
		m_musicIndex = (m_musicIndex + 1) % m_musicNames.length;
		try {
			RandomAccessFile file = new RandomAccessFile(filename, "r");
			RandomFileInputStream fis = new RandomFileInputStream(file);
			m_canvas.playMusic(fis, 0, 1.0F);
		} catch (Throwable th) {
			th.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	private int m_musicIndex = 0;
	private String[] m_musicNames = new String[] { "Son_Menu" }; 

	private long m_textElapsed;

	/*
	 * This method is invoked almost periodically, given the number of milli-seconds
	 * that elapsed since the last time this method was invoked.
	 */
	void tick(long elapsed) {

		if (this.start.isClickedPlay) {
			world.tick(elapsed);
			//bush.tick(elapsed);
		}

		// Update every second
		// the text on top of the frame: tick and fps
		m_textElapsed += elapsed;
		if (m_textElapsed > 1000) {
			m_textElapsed = 0;
			float period = m_canvas.getTickPeriod();
			int fps = m_canvas.getFPS();

			String txt = "Tick=" + period + "ms";
			while (txt.length() < 15)
				txt += " ";
			txt = txt + fps + " fps   ";
			m_text.setText(txt);
		}
	}
	
	public World getWorld() {
		return world;
	}

	/*
	 * This request is to paint the Game Canvas, using the given graphics. This is
	 * called from the GameCanvasListener, called from the GameCanvas.
	 */

	void display_game(Graphics g) {
		// get the size of the canvas
		int width = m_canvas.getWidth();
		int height = m_canvas.getHeight();

		ViewPrinter.paintComponent(g);

		// paint player
		// m_cowboy.paint(g, width, height);
		// m_player.Avatar.paintComponent(g);
		// m_cowboy2.paint(g, width, height, m_cowboy2.m_x, m_cowboy2.m_y);
		for(int i = 0; i < world.listBlueBucket.get(0).listEnemies.size();i++) {
			Entity e = world.listBlueBucket.get(0).listEnemies.get(i);
			e.Avatar.paintComponent(g);
		}

		this.inv1.paintComponent(g);
		this.inv2.paintComponent(g);
		
		//this.m_wall.Avatar.paintComponent(g);

		if (this.shop1.getKeyPressedShop()) {
			this.shop1.paintComponent(g);
		}
		if (this.shop2.getKeyPressedShop()) {
			this.shop2.paintComponent(g);
		}
		
		if (this.m_player.getHPCommun() <= 0){
			this.over.paintComponent(g);
		}
		
		
	}

	void paint(Graphics g) {
		if (!this.start.isClickedPlay)
			this.start.paintComponent(g);
		// if isClickedPlay is true, we can paint the game
		if (this.start.isClickedPlay) {			
			display_game(g);
			//g.setColor(Color.blue);
			//g.drawRect(m_wall.GetHitBox().x, m_wall.GetHitBox().y, m_wall.GetHitBox().width, m_wall.GetHitBox().height);
		}
	}

}