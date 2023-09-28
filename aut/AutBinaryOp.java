package aut;

import model.entities.Entity;

abstract class AutBinaryOp implements ICondition {
	ICondition left;
	ICondition right;
	String operator;
	
	AutBinaryOp(ICondition left, ICondition right, String operator){
		this.left = left;
		this.right = right;
		this.operator = operator;
		
//		switch(operator) {
//		case "&":
//			return new AutAndOp(left, right);
//		case "/":
//			return new AutOrOp(left, right);
//		}
		
	}
	
	public abstract boolean eval(Entity e);
	
}
