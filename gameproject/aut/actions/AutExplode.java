package aut.actions;

import aut.AutAction;
import model.entities.Entity;

public class AutExplode extends AutAction{
	
	public AutExplode(int percentage) {
		super(percentage);
	}
	
	@Override
	public void apply(Entity e) {
		System.out.println("Explode()");
		e.Explode();
	}

}
