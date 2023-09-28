package aut;

import java.util.ArrayList;
import java.util.List;

import info3.game.automata.ast.*;
import info3.game.automata.parser.AutomataParser;

public class AutLoader {

	public static ArrayList<Automate>loadAutomata(String filename) {
	    try {
	      AST ast = (AST) AutomataParser.from_file(filename);

//	      // TODO à vous de constuire les automates à partir de l'AST

	      AutBuilder visitor = new AutBuilder();
	      ArrayList<Automate> aut = (ArrayList<Automate>)ast.accept(visitor);
	      
	      return aut;
	      
	    } catch (Exception ex) {
	      return null;
	    }
	  }

}
