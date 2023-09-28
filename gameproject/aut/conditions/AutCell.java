package aut.conditions;

import aut.AutCategory;
import aut.AutDirection;
import aut.ICondition;
import model.entities.Entity;

public class AutCell implements ICondition {

	AutCategory cat;
	AutDirection dir;
	
	public AutCell(AutDirection dir, AutCategory cat) {
		this.cat = cat;
		this.dir = dir;
	}

	@Override
	public boolean eval(Entity e) {
		// System.out.println("Cell("+dir+","+cat+")");
		
		return e.Cell(dir, cat); // Méthode du Model
	}

}