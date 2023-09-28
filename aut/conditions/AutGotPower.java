package aut.conditions;

import aut.ICondition;
import model.entities.Entity;

/*
 * vraie s'il reste de l'énergie à l'entité
 */

public class AutGotPower implements ICondition {

	public AutGotPower(){
		
	}
	@Override
	public boolean eval(Entity e) {
//		System.out.println("GotPower()");
		return e.GotPower();
	}

}
