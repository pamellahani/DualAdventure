package aut;

public enum AutCategory {
	AROBASE, // Entité alliés
	V, // Si la case actuelle est vide
	O, // Espace occupé
	P; // Item collectable
	

	static AutCategory toAutCategory(String name) {
		switch(name) {
		case "@":
			return AROBASE;
		case "V":
			return V;
		case "O":
			return O;
		case "P":
			return P;
		default:
			return null;
		}
	}
	

}
