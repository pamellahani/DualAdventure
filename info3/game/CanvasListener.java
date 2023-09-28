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

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;


import graphics.GameCanvasListener;
import model.Utils.COLOR;
import model.entities.Items.Items;
import model.entities.Items.Key;


public class CanvasListener implements GameCanvasListener {
  Game m_game;
  public static ArrayList<Integer> pressedKeys; 

  CanvasListener(Game game) {
    m_game = game;
    this.pressedKeys=new ArrayList<Integer>(); 
  }

  @Override
  public void mouseClicked(MouseEvent e) {
//    System.out.println("Mouse clicked: ("+e.getX()+","+e.getY()+")");
//    System.out.println("   modifiers="+e.getModifiersEx());
//    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mousePressed(MouseEvent e) {
//    System.out.println("Mouse pressed: ("+e.getX()+","+e.getY()+")");
//    System.out.println("   modifiers="+e.getModifiersEx());
//    System.out.println("   buttons="+e.getButton());
	  this.m_game.start.closeMenuPage();
	  this.m_game.shop1.closeShop();
	  this.m_game.shop2.closeShop();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
//    System.out.println("Mouse released: ("+e.getX()+","+e.getY()+")");
//    System.out.println("   modifiers="+e.getModifiersEx());
//    System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  //  System.out.println("Mouse entered: ("+e.getX()+","+e.getY()+")");
   // System.out.println("   modifiers="+e.getModifiersEx());
   // System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseExited(MouseEvent e) {
   // System.out.println("Mouse exited: ("+e.getX()+","+e.getY()+")");
   // System.out.println("   modifiers="+e.getModifiersEx());
   // System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseDragged(MouseEvent e) {
   // System.out.println("Mouse dragged: ("+e.getX()+","+e.getY()+")");
  //  System.out.println("   modifiers="+e.getModifiersEx());
   // System.out.println("   buttons="+e.getButton());
  }

  @Override
  public void mouseMoved(MouseEvent e) {
//    System.out.println("Mouse moved: ("+e.getX()+","+e.getY()+")");
//    System.out.println("   modifiers="+e.getModifiersEx());
//    System.out.println("   buttons="+e.getButton());
	  this.m_game.start.setPlay(e.getX(), e.getY());
	  this.m_game.start.setHowTo(e.getX(), e.getY());
	  this.m_game.shop1.setMouseOnItem(e.getX(), e.getY());
	  this.m_game.shop2.setMouseOnItem(e.getX(), e.getY());
//	  if (this.m_game.shop1.getKeyPressedShop()) {
//		  this.m_game.shop1.setMouseOnItem(e.getX(), e.getY());
//		  //this.m_game.shop1.setMouseOnItem(false);
//	  }
//	  if (this.m_game.shop2.getKeyPressedShop()) {
//		  this.m_game.shop2.setMouseOnItem(e.getX(), e.getY());
//		  //this.m_game.shop2.setMouseOnItem(false);
//	  }
  }

  @Override
  public void keyTyped(KeyEvent e) {
   // System.out.println("Key typed: "+e.getKeyChar()+" code="+e.getKeyCode());
  }

  @Override
  public void keyPressed(KeyEvent e) {
  //  System.out.println("Key pressed: "+e.getKeyChar()+" code="+e.getKeyCode());
    if (!this.pressedKeys.contains(e.getKeyCode()) && !this.oneTimeKeyAction(e)) {
    	this.pressedKeys.add(e.getKeyCode()); 

    } 	
  }

  public boolean oneTimeKeyAction(KeyEvent e) {
	  switch (e.getKeyCode()){
	  case KeyEvent.VK_C:
	    	this.m_game.shop1.setkeyPressedShop(!this.m_game.shop1.getKeyPressedShop());
	    	break; 
	    case KeyEvent.VK_N: 
	    	this.m_game.shop2.setkeyPressedShop(!this.m_game.shop2.getKeyPressedShop());
	    	break; 
	default:
		return false;
	}
	  return true; // in case key is found
  }

  @Override
  public void keyReleased(KeyEvent e) {
 //   System.out.println("Key released: "+e.getKeyChar()+" code="+e.getKeyCode());
    if (this.pressedKeys.contains(e.getKeyCode())) {
    	this.pressedKeys.remove(Integer.valueOf(e.getKeyCode())); 
    	 //this.m_game.m_back2.setDx1(0);
    	 //this.m_game.m_back2.setDx2(0);
    	 //this.m_game.f.setStopScrollingFrame1(true); 
    	 //this.m_game.f.setStopScrollingFrame2(true);
    }
  }

  @Override
  public void tick(long elapsed) {
    m_game.tick(elapsed);
//    Iterator<Integer> itr = this.pressedKeys.iterator(); 
//    while(itr.hasNext()) {
//    	this.keyAction(itr.next());
//    }
  }

  @Override
  public void paint(Graphics g) {
    m_game.paint(g);
  }

  @Override
  public void windowOpened() {
    m_game.loadMusic();
//    m_game.m_canvas.setTimer(6000);
  }

  @Override
  public void exit() {
  }

//  boolean m_expired;
  @Override
  public void endOfPlay(String name) {
//    if (!m_expired) // only reload if it was a forced reload by timer
      m_game.loadMusic();
//    m_expired = false;
  }

  @Override
  public void expired() { 
// will force a change of music, after 6s of play
//    System.out.println("Forcing an ealy change of music");
//    m_expired = true;
//    m_game.loadMusic();    
  }

}
