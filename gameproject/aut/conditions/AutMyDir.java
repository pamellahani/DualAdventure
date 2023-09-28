package aut.conditions;

import aut.AutDirection;
import aut.ICondition;
import model.entities.Entity;

/*
 * MyDir(Direction) : vraie si l'entité est orientée dans la Direction
 */

public class AutMyDir implements ICondition{
	AutDirection direction;
	
	public AutMyDir(AutDirection dir) {
		this.direction = dir;
	}
	
	
	
	@Override
	public boolean eval(Entity e) {
		System.out.println("MyDir("+direction+")");
		return true;
		//e.MyDir(this.dir);
		
	}

}
