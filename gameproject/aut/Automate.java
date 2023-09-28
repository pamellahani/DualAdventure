package aut;

import java.util.ArrayList;
import java.util.Random;
import model.entities.*;

/*
 * Forme d'un automate en .GAL : 
 * 
 * <nom de l'automate> (<état initial>){ 
 *	<transitions>
 *	}
 * 
 * Il faut donc le nom de l'automate, son état initial, sa liste de transitioons et peut-être sa liste d'état ??
 * 
 * 
 */


public class Automate {
	
	public static final AutState death = new AutState("");
	
	public String name;
	public ArrayList<AutTransition> transitions;
	public ArrayList<AutState> states;
	public AutState initial_state;
	
	public Automate(String name/*,State s*/) {
		this.name = name;
		//this.initial_state = s;
		this.transitions = new ArrayList<AutTransition>();
		this.states = new ArrayList<AutState>();
		
	}
	
	
	
	
	/*
	 * Voir gal.automaton.README.md
	 * 
	 * eval() les conditions de chaque transitions puis demande l'action a faire (apply()) et renvoie état cible
	 * 
	 * 
	 */
	
	public void chooseAction(Entity e, AutTransition trans) {
		Random random = new Random();
		int percent = random.nextInt(100);
		
		int borne_min = 0;
		
		for (AutAction act : trans.action) {
			if (borne_min <= percent && percent <= borne_min + act.percentage) {
				act.apply(e);
				break;
			}
			else {
				borne_min += act.percentage;
			}
		}
	}
	
	public AutState step(Entity e) {
//		//Iterator iter = (Iterator) current.transitions.iterator();
//		Iterator<AutTransition> iter = (Iterator<AutTransition>) current.transitions.iterator();
//		

		for (AutTransition trans : e.current_state.transitions) {
			if(trans.condition.eval(e)) {

				// Choix et application de l'action selon sa probabilité
				chooseAction(e, trans);
				
				// APPLY
				//trans.action.apply(e);
				
				e.current_state = trans.target; // Facultatif aka A VOIR
				
				return trans.target;
			}
		}
		
		
		return e.current_state; // Si y'a pas de transitions, on reste sur le même état
	}
	
	
	// Add a state with the transition
	public void add(AutState s) {
		this.states.add(s);
	}
	
	
	

}
