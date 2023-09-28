package aut.actions;

import aut.AutAction;
import model.entities.Entity;

public class AutWait extends AutAction {
	
	public AutWait(int percentage) {
		super(percentage);
	}
	
	@Override
	public void apply(Entity e) {
		System.out.println("Wait()");
		// e.wait();
	}

}
