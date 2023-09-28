package aut;

import java.util.ArrayList;

public class AutTransition {
	
	//State source;
	ICondition condition;
	ArrayList<AutAction> action; // Liste d'actions avec des probabilités
	AutState target;
	
	
	public AutTransition(ICondition cond, ArrayList<AutAction> act, AutState tgt) {
		//this.source = src;
		this.condition = cond;
		this.action = act;
		this.target = tgt;
	}
	
	

}
