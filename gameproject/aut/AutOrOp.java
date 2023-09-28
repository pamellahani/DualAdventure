package aut;

import model.entities.Entity;

public class AutOrOp extends AutBinaryOp {
	public AutOrOp(ICondition left, ICondition right) {
		super(left, right, "|");
	}

	@Override
	public boolean eval(Entity e) {
		return left.eval(e) || right.eval(e); 
	}
}
