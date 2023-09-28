package aut;


/*
 * Voir FAQ du mercredi 15 arvil
 * 
 * Creer une interface pour cette calss
 * 
 */

import model.entities.*;

public abstract class AutAction {
	
	int percentage;
	//public static final ArrayList<AutFunCall> funcalls = new ArrayList<AutFunCall>();
	
	public AutAction(int percentage){
		this.percentage = percentage;
	}

	public abstract void apply(Entity e);
	
	public void setPercentage(int p) {
		percentage = p;
	}

}
