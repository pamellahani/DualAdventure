package aut.conditions;

import aut.AutCategory;
import aut.AutDirection;
import aut.ICondition;
import model.entities.Entity;

/*
 * Closest(Categorie, Direction) : vraie si l'entité de la Catégorie demandée, la plus proche est dans la Direction



 */

public class AutClosest implements ICondition{
	AutCategory cat;
	AutDirection dir;
	
	public AutClosest(AutCategory cat, AutDirection dir){
		this.dir = dir;
		this.cat = cat;
	}
	
	@Override
	public boolean eval(Entity e) {
		//System.out.println("Closest("+dir+","+cat+")");
		return e.Closest(cat, dir); // Méthode du Model
	}
	
	
}
