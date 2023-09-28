package aut;

import java.util.ArrayList;

import aut.actions.AutMove;
import aut.conditions.AutTrue;

/*
 * Voir FAQ du lundi 13 avril 
 * 
 * Contient quelques automates ultra-simples qui permettront de tester le jeu indépendant de la connection au parser
 * Permet de  tester le fonctionnement de nos automates sans parser avant de connecter le parser.
 */

public class BasicAut {
	
	
	
	public static Automate move_loop(AutDirection direction) {
		   Automate aut = new Automate("Bull");
		   AutState s = new AutState("Foncer");
		   aut.initial_state = s;
		   
		   ArrayList<AutAction> actions = new ArrayList<AutAction>();
		   actions.add(new AutMove(direction, 100));
		   
		   AutTransition t = new AutTransition(new AutTrue(), actions, s);
		   s.add(t);
		   aut.add(s);
		   return aut;
		}


}
