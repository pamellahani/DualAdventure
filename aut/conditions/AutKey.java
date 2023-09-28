package aut.conditions;

import aut.AutTouche;
import aut.ICondition;
import info3.game.CanvasListener;
import model.entities.Entity;
import java.awt.event.KeyEvent;


/*
 * Key(Touche) : vrai si une touche est enfoncée et c'est Touche
 */

public class AutKey implements ICondition {

	String touche;
	
	public AutKey(String touche){
		this.touche = touche;
	}
	@Override
	public boolean eval(Entity e) {

//		System.out.println("Key ("+touche+")");
		
		int ascii;
		
		switch(touche) {
		case "FR":
			ascii = KeyEvent.VK_RIGHT;
			break;
		case "FU":
			ascii = KeyEvent.VK_UP;
			break;
		case "FL":
			ascii = KeyEvent.VK_LEFT;
			break;
		case "FD":
			ascii = KeyEvent.VK_DOWN;
			break;
		case "SPACE":
			ascii = KeyEvent.VK_SPACE;
			break;
		case "ENTER":
			ascii = KeyEvent.VK_ENTER;
			break;
		default:
			ascii = touche.toUpperCase().charAt(0);
			break;
		}

		return CanvasListener.pressedKeys.contains(ascii);

	}
}
