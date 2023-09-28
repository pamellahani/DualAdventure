package aut;

import java.util.ArrayList;
import java.util.List;

import aut.AutDirection;
import aut.AutTransition;
import aut.AutAction;
import aut.conditions.*;
import aut.actions.*;
import info3.game.automata.ast.AST;
import info3.game.automata.ast.Action;
import info3.game.automata.ast.Automaton;
import info3.game.automata.ast.Behaviour;
import info3.game.automata.ast.BinaryOp;
import info3.game.automata.ast.Category;
import info3.game.automata.ast.Condition;
import info3.game.automata.ast.Direction;
import info3.game.automata.ast.FunCall;
import info3.game.automata.ast.IVisitor;
import info3.game.automata.ast.Key;
import info3.game.automata.ast.Mode;
import info3.game.automata.ast.Parameter;
import info3.game.automata.ast.State;
import info3.game.automata.ast.Transition;
import info3.game.automata.ast.UnaryOp;
import info3.game.automata.ast.Underscore;
import info3.game.automata.ast.Value;
import info3.game.automata.parser.AutomataParser;

/*
 * Voir FAQ Mercredi 15 avril 
 * 
 * 
 * cette class construit des automates executables a partir de l'AST
 */




public class AutBuilder implements IVisitor {
	
	private ArrayList<AutState> dejavuStates;
	private ArrayList<Automate> automates;
	
	AutBuilder(){
		automates = new  ArrayList<Automate>();
		dejavuStates = new  ArrayList<AutState>();
	}

//	public ICondition getCondition(Object exp) {
//		
//		if (exp instanceof AutFunCall) {
//			AutFunCall call = (AutFunCall)exp;
//			switch(call.name) {
//			case "True":
//				return new True();
//			case "Cell": // paramètres
//				return new Cell(call.dir, call.cat);
//			default:
//				return null;
//			}
//		}
//		else {
//			return (ICondition)exp;
//		}
//		
//
//	}
	
	
	public ICondition getCondition(AutFunCall call) {

			switch(call.name) {
			case "True":
//				System.out.println("Creation de l'objet AutTrue");
				return new AutTrue();
			case "Key":
//				System.out.println("Creation de l'objet AutKey");
				return new AutKey(call.touche);
			case "MyDir":
				return new AutMyDir(call.dir);
			case "Cell": 
				return new AutCell(call.dir, call.cat);
			case "GotPower":
				return new AutGotPower();
			case "GotStuff":
				return new AutGotStuff();
			case "Closest":
				return new AutClosest(call.cat, call.dir);
			default:
				return null;
			}
		}
	
	public ICondition getCondition(AutUnaryOp call) {
		return new AutNotOp(call.cond);
	}
	
	public ICondition getCondition(AutBinaryOp call) {
		switch(call.operator) {
		case "&":
			return new AutAndOp(call.left, call.right);
		case "/":
			return new AutOrOp(call.left, call.right);
		default:
			return null;
		}
	}

	public AutAction getAction(AutFunCall exp) {
		
		int percentage = exp.percentage;
		
		if (exp.percentage == -1) {
			percentage = 100;
		}
		
//		System.out.println("Pourcentage de l'action : "+percentage);
		
		switch(exp.name) {
		case "Move":
			return new AutMove(exp.dir, percentage);
			//return (Action)move;
		case "Jump": // paramètres
			return new AutJump(exp.dir, percentage );
		case "Turn":
			return new AutTurn(exp.dir, percentage);
		case "Hit":
			return new AutHit(percentage);
		case "Pick":
			return new AutPick(percentage);
		case "Throw":
			return new AutThrow(percentage);
		case "Store":
			return new AutStore(percentage);
		case "Get":
			return new AutGet(percentage);
		case "Power":
			return new AutPower(percentage);
		case "Explode":
			return new AutExplode(percentage);
		case "Egg":
			return new AutEgg(percentage);
		case "Pop":
			return new AutPop(percentage);
		default:
			return null;
		}
	}
	
	@Override
	public Object visit(Category cat) { // PARAMETRES DU FUNCALL
		return cat.toString();
	}

	@Override
	public Object visit(Direction dir) { // PARAMETRES DU FUNCALL
		return dir.toString();
	}

	@Override
	public Object visit(Key key) { // PARAMETRES DU FUNCALL
		return key.toString();
	}

	@Override
	public Object visit(Value v) { // PARAMETRES DU FUNCALL
		return v.toString();
	}

	@Override
	public Object visit(Underscore u) { // PARAMETRES DU FUNCALL
		return u.toString();
	}

	@Override
	public void enter(FunCall funcall) {

	}

	@Override
	public Object exit(FunCall funcall, List<Object> parameters) { // Créer la liste de paramètres (OBJET AutParameter)
		//return parameters; // Finalement non, créer notre AutFunCall avec les paramètres et le retourner
		
		AutDirection dir = null;
		AutCategory cat = null;
		String touche = null;
		
		if (parameters.size() == 1) {
			dir = AutDirection.toAutDirection(parameters.get(0).toString());
			if(dir == null) {
				touche = parameters.get(0).toString();
			}
		}
		else if (parameters.size() == 2 && funcall.name.equals("Closest")) {
			dir = AutDirection.toAutDirection(parameters.get(1).toString());
			cat = AutCategory.toAutCategory(parameters.get(0).toString());
		}
		else if (parameters.size() == 2 && funcall.name.equals("Cell")) {
			dir = AutDirection.toAutDirection(parameters.get(0).toString());
			cat = AutCategory.toAutCategory(parameters.get(1).toString());
		}
		
//		if (funcall.name.equals("True")) { // Créer l'instance CONDITION ACTION
//			return new AutTrue();
//		}
//			
//		System.out.println("Creation de l'objet AutFunCall");
//		AutFunCall fun = new AutFunCall(funcall.name, dir, cat);
		
		switch(funcall.name) {
		case "True":
//			System.out.println("Creation de l'objet AutTrue");
			return new AutTrue();
		case "Key":
			return new AutKey(touche);
		case "MyDir":
			return new AutMyDir(dir);
		case "Cell": 
			return new AutCell(dir, cat);
		case "GotPower":
			return new AutGotPower();
		case "GotStuff":
			return new AutGotStuff();
		case "Closest":
			return new AutClosest(cat, dir);
		default:
			return new AutFunCall(funcall.name, dir, cat, touche, funcall.percent);
		}	

		
	}

	@Override
	public Object visit(BinaryOp operator, Object left, Object right) {
		
//		ICondition l = getCondition((ICondition)left); // left peut être AutFunCall, UnaryOp, BinaryOp
//		ICondition r = getCondition((ICondition))right);
		
//		ICondition l = null;
//		ICondition r = null;
//		if (left instanceof AutFunCall) {
//			l = getCondition((AutFunCall)left);
//		}
//		else if (left instanceof UnaryOp) {
//			l = getCondition((AutFunCall)left);
//		}
//		else if (left instanceof BinaryOp) {
//			l = getCondition((AutFunCall)left);
//		}
//		
//		if (right instanceof AutFunCall) {
//			r = getCondition((AutFunCall)right);
//		}
//		else if (right instanceof UnaryOp) {
//			r = getCondition((AutFunCall)right);
//		}
//		else if (right instanceof BinaryOp) {
//			r = getCondition((AutFunCall)right);
//		}
//		ICondition l;
//		ICondition r;
//		if (left instanceof AutFunCall) {
//			l = getCondition((AutFunCall)left);
//		}
//		else {
//			l = getCondition((ICondition)left);
//		}
//		
//		if (right instanceof AutFunCall) {
//			r = getCondition((AutFunCall)right);
//		}
//		else {
//			r = getCondition((ICondition)right);
//		}
		
		switch(operator.operator) {
		case "&":
			return new AutAndOp((ICondition)left, (ICondition)right);
		case "/":
			return new AutOrOp((ICondition)left, (ICondition)right);
		}
		return null;
	}

	@Override
	public Object visit(UnaryOp operator, Object expression) {
		if (operator.operator == "!") {
//			System.out.println("Creation de l'objet NotOp");
			return new AutNotOp((ICondition)expression);
		}
		else {
			return null;
		}
	}

	@Override
	public Object visit(State state) {
		String name = state.toString();
		
//		Iterator iter = dejavuStates.iterator();
//		while (iter.hasNext()) {
//			AutState uniqueState = (AutState)iter.next();
//			if (uniqueState.name.equals(state.name)) return uniqueState;
//		}
		
	    for (AutState uniqueState : dejavuStates) {
	      if (uniqueState.name.equals(state.name)) return uniqueState;
	    }
	    // l'état State n'a jamais été rencontré, on l'ajoute dans notre collection d'états
	    AutState uniqueState = new AutState(name);
	    dejavuStates.add(uniqueState);
	    return uniqueState;
	}

	@Override
	public void enter(Mode mode) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Object exit(Mode mode, Object source_state, Object behaviour) {
////		ArrayList<AutTransition> list_trans = new ArrayList<AutTransition>();
////		
////		for (Transition trans : ((Behaviour)behaviour).transitions) {
////			
////			AutState tgt = new AutState();
////			
////			AutTransition aut_trans = new AutTransition((ICondition)trans.condition, (IAction)trans.action, (AutState)trans.target);
////			list_trans.add(aut_trans);
////		}
////		AutState state = new AutState(((State)source_state).name, list_trans);
////		return state;
//		
//		AutState state = new AutState(((State)source_state).name);
//		
//		for(Transition trans : ((Behaviour)behaviour).transitions) {
//			
//			state.add((AutTransition)trans);
//		}
//	}
	
	@Override
    public Object exit(Mode mode, Object source_state, Object behaviour) {
		
//		behaviour.
//        // Création de l'état
//		AutState state = new AutState(((AutState)source_state).name);
//		
//		// Pour chaque transition, on crée une nouvelle instance de la transition
//        for (Transition trans : behaviour) {
//        	// Créer une nouvelle instance pour l'action
//        	IAction action = new IAction(trans.action);
//        	
//        	// Créer une nouvelle instance pour la condition
//        	ICondition condition = trans.condition;
//        	
//        	// Créer la transition à partir de ces deux nouvelles instances
//        	AutTransition newTrans = new AutTransition(condition, action, new AutState(trans.target.name));
//        	
//        	// Ajout de la transition à l'état
//        	state.add(newTrans);
//        	
//        }
//        return state;
		
		AutState state = (AutState)source_state;
		List<AutTransition> list = (List<AutTransition>)behaviour;
//		if (behaviour instanceof ArrayList) {
//			list = (ArrayList<AutTransition>)behaviour;
//		}
		for (AutTransition o: list) {
			state.add((AutTransition)o);
		}
		return state;
    }

	@Override
	public Object visit(Behaviour behaviour, List<Object> transitions) {
//		System.arraycopy(transitions, 0, behaviour.transitions, 0, transitions.size());
//		return behaviour;
		return transitions;
	}

	@Override
	public void enter(Condition condition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object exit(Condition condition, Object expression) { // Switch case des actions et conditions

		// ACTUAL
//		AutFunCall fun = null;
//
//		if (!(expression instanceof AutFunCall)) {
//			
//			if (expression instanceof AutUnaryOp) {
//				fun = (AutFunCall)(((AutUnaryOp)expression).cond);
//			}
////			else if (expression instanceof AutBinaryOp) {
////				fun = (AutFunCall)(((AutBinaryOp)expression).cond);
////			}
//			
//			return getCondition(fun);
//		}
//		
//		
//		fun = (AutFunCall)expression;
//		if (fun instanceof ICondition) {
//			return getCondition(fun);
//		}
//		else if (fun instanceof IAction) {
//			return getAction(fun);
//		}
//		return null;
		
		return (ICondition)expression;
		
		// ANCIEN
//		switch(fun.name) {
//		case "True":
//			return new True(); // CONDITION
//		case "Move":
//			return new Move(fun.dir); // ACTION
//		
//		default:
//			return null;
//		}
	}

	@Override
	public void enter(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object exit(Action action, List<Object> funcalls) { // Actions
		
		// Boucle for qui traduit chaque action
		return funcalls;
		//return getAction((AutFunCall)(funcalls.get(0)));
	}

	@Override
	public Object visit(Transition transition, Object condition, Object action, Object target_state) {
		
		// Prendre une liste d'IAction au lieu d'une seule IAction
		
		ArrayList<AutAction> listAct = new ArrayList<AutAction>();
		List<AutFunCall> listFun = (List<AutFunCall>)action;
		
		for (Object call : listFun) {
			AutAction act = getAction((AutFunCall)call);
			listAct.add(act);
		}
		
		return new AutTransition((ICondition)condition, listAct, (AutState)target_state);
	}

	@Override
	public void enter(Automaton automaton) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object exit(Automaton automaton, Object initial_state, List<Object> modes) {
		Automate a = new Automate(automaton.name);
		a.initial_state = (AutState)initial_state;
//		a.initial_state = (AutState)initial_state;
//		IList.Iterator iter = (Iterator) modes.iterator();
//		
//		while (iter.hasNext()) { // On parcourt l'ensemble des modes (états)
//			
//			Mode m = (Mode)iter.next();
//			
//			IList list = new LinkedList(); // Création de la liste de transitions de l'état
//			System.arraycopy(m.behaviour.transitions, 0, list, 0, m.behaviour.transitions.size());
//			
//			AutState state = new AutState(m.state.name, list); // Création de l'objet état à partir de son nom, et de sa liste de transitions
//			
//			a.add(state); // Ajout de l'état dans l'automate
//			
//		}
		return a;
	}

	@Override
	public Object visit(AST bot, List<Object> automata) {

        //ArrayList<Automate> list = new ArrayList<Automate>();
        for(Object aut : automata) {
            //automates.add((Automate)aut);
            automates.add((Automate)aut);
        }
        return automates;    
    
	}

//	@Override
//	public Object exit(FunCall funcall, List<Object> parameters) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Object visit(Behaviour behaviour, List<Object> transitions) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Object exit(Action action, List<Object> funcalls) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Object exit(Automaton automaton, Object initial_state, List<Object> modes) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Object visit(AST bot, List<Object> automata) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

	
	

}
