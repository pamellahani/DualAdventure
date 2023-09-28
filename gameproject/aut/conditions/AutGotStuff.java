package aut.conditions;

import aut.ICondition;
import model.entities.Entity;

/*
 * GotStuff : vraie s'il reste des choses dans le store
 */

public class AutGotStuff implements ICondition {

	public AutGotStuff(){
		
	}
	@Override
	public boolean eval(Entity e) {
//		System.out.println("GotStuff()");
		return e.GotStuff();
	}

}
