package aut.actions;

import aut.AutDirection;
import aut.AutAction;
import model.entities.*;
import model.entities.enemies.Enemy;



public class AutMove extends AutAction {

	AutDirection direction;
	
	public AutMove(int percentage) {
		super(percentage);
		this.direction = AutDirection.R;
		
	}
	
	public AutMove(AutDirection dir, int percentage) {
		super(percentage);
		this.direction = dir;
		
	}

	@Override
	public void apply(Entity e) {
		if (e instanceof Enemy) {
			System.out.println("Move("+direction+") "+e.GetX());
		}
		e.Move(direction);
		
	}


}
