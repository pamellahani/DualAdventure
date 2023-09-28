package aut.conditions;

import aut.ICondition;
import model.entities.*;


public class AutTrue implements ICondition {
	
	public AutTrue(){
		
	}
	
	@Override
	public boolean eval(Entity e) {
		return true;
	}
	
}
