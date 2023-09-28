package aut.actions;

import aut.AutAction;
import model.entities.Entity;

public class AutStore extends AutAction{
	
	public AutStore(int percentage) {
		super(percentage);
	}
	
	
	@Override
	public void apply(Entity e) {
		System.out.println("Store()");
		//e.store();
	}

}
