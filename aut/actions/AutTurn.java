package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.Entity;

public class AutTurn extends AutAction {
	AutDirection direction;
	
	public AutTurn(int percentage) {
		super(percentage);
		this.direction = AutDirection.R;
	}
	
	public AutTurn(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
	}
	
	@Override
	public void apply(Entity e) {
		System.out.println("Turn("+direction+")");
		// e.turn(this.direction);
	}

}
