package aut.actions;

import aut.AutAction;
import aut.AutDirection;
import model.entities.Entity;

public class AutPop extends AutAction{
	
	public AutPop(int percentage) {
		super(percentage);
	}
	
	@Override
	public void apply(Entity e) {
		System.out.println("Pop()");
		e.Pop();
	}
}
