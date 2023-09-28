package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.Entity;

public class AutThrow  extends AutAction{
	
	AutDirection direction;
	
	public AutThrow(int percentage) {
		super(percentage);
		this.direction = AutDirection.R;
	}
	
	public AutThrow(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
	}
	
	
	@Override
	public void apply(Entity e) {
		System.out.println("Throw("+direction+")");
		e.Throw();
	}
}
