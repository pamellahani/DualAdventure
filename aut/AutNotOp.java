package aut;

import model.entities.Entity;

public class AutNotOp extends AutUnaryOp {
	public AutNotOp(ICondition expression) {
		super.cond = expression;
	}

	@Override
	public boolean eval(Entity e) {
		
		return !cond.eval(e);
	}
}
