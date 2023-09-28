package aut;

import model.entities.Entity;

abstract class AutUnaryOp implements ICondition {
	ICondition cond;
	String operator;
	
	public abstract boolean eval(Entity e);

}
