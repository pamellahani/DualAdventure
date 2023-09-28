package aut;

import java.util.ArrayList;

import aut.AutAction;
import model.entities.Entity;

public class AutFunCall extends AutAction implements ICondition {
	
	String name;
	//ArrayList<AutParameter> parameters;
	AutDirection dir;
	AutCategory cat;
	String touche;
	
	
//	AutFunCall(String name, ArrayList<AutParameter> parameters){
//		this.name = name;
//		this.parameters = parameters;
//	}
	
	public AutFunCall(String name, AutDirection dir, AutCategory cat, String touche, int percent){
		super(percent);
		this.name = name;
		this.dir = dir;
		this.cat = cat;
		this.touche = touche;
	}
	


	@Override
	public boolean eval(Entity e) {
		return false;
	}
	@Override
	public void apply(Entity e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
