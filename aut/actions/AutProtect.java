package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.Entity;

public class AutProtect extends AutAction{
	AutDirection direction;
	
	public AutProtect(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
	}
	
	@Override
	public void apply(Entity e) {
		System.out.println("Protect("+direction+")");
		//e.protect(this.direction);
	}
	

}
