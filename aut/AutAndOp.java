package aut;

import model.entities.Entity;

public class AutAndOp extends AutBinaryOp {

	public AutAndOp(ICondition left, ICondition right) {
		super(left, right, "&");
	}

	@Override
	public boolean eval(Entity e) {
		return left.eval(e) && right.eval(e); 
	}

}
