package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.Entity;

public class AutHit extends AutAction{
	AutDirection direction;
	
	public AutHit(int percentage) {
		super(percentage);
		this.direction = AutDirection.R;
	}
	
	public AutHit(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
	}
	
	
	public void apply(Entity e) {
		System.out.println("Hit("+direction+")");
		e.Hit();
	}

}
