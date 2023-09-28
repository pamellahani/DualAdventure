package aut;

import java.util.ArrayList;

/*
 * Voir FAQ du Mercredi 15 avril
 * eval est une méthode que doit implanter chaque condition
 * 
 */

import model.entities.*;

public interface ICondition {
	
	
	//public static final ArrayList<AutFunCall> funcalls = new ArrayList<AutFunCall>();
	
	abstract boolean eval(Entity e);

}
