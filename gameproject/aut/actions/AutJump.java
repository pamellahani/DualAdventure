package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.Entity;

public class AutJump extends AutAction{
	AutDirection direction;
	
	public AutJump(int percentage) {
		super(percentage);
		this.direction = AutDirection.R;
	}
	
	public AutJump(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
	}
	
	
	@Override
	public void apply(Entity e) {
	//	System.out.println("Jump("+direction+")");
		e.Jump(this.direction);
	}

}
