package aut.actions;

import aut.AutAction;
import model.entities.Entity;

public class AutGet extends AutAction {
	
	public AutGet(int percentage) {
		super(percentage);
	}
	
	
	@Override
	public void apply(Entity e) {
		System.out.println("Get()");
		e.Get();
	}

}
