package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.Entity;

public class AutPick extends AutAction {
	AutDirection direction;
	
	public AutPick(int percentage) {
		super(percentage);
		this.direction = null;
	}
	
	public AutPick(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
	}
	
	@Override
	public void apply(Entity e) {
		System.out.println("Pick("+direction+")");
		//e.pick(this.direction);
	}

}
