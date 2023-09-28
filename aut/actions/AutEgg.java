package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.Entity;

public class AutEgg extends AutAction {
	AutDirection direction;
	
	public AutEgg(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
	}
	
	public AutEgg(int percentage) {
		super(percentage);
		this.direction = AutDirection.R;
	}
	
	@Override
	public void apply(Entity e) {
		//System.out.println("Egg("+direction+")");
		e.Egg();
	}
	

}
