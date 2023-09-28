package aut;

import java.util.ArrayList;

public class AutState {
	
	public String name;
	public ArrayList<AutTransition> transitions;
	
	public AutState(String name) {
		this.name = name;
		this.transitions = new ArrayList<AutTransition>();
	}
	
	public AutState(String name, ArrayList<AutTransition> trans) {
		this.name = name;
		this.transitions = trans;
	}
	
	
	// Add a transition at the end of the list
	public void add(AutTransition t) {
		this.transitions.add(t);
	}
	

}
