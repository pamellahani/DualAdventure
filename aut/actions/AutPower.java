package aut.actions;

import aut.AutAction;
import model.entities.Entity;

public class AutPower extends AutAction{
	
	public AutPower(int percentage) {
		super(percentage);
	}
	
	@Override
	public void apply(Entity e) {
		System.out.println("Power()");
		//e.power();
	}

}
