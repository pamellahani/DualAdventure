package aut;

public enum AutTouche {
	z, // Saut Vertical Bleu
	q, // Move Gauche Bleu
	d, // Move Droit Bleu
	s, // Accroupie Bleu (Move(D))
	a, // Hit Bleu
	e, // Get Bleu
	x, // Throw Bleu
	c, // Shop Bleu
	SPACE, //Echange entre 2 Player
	FU, //Daut Vertical Rouge
	FL, //Move Gauche Red
	FR, //Move Droit red
	FD, //Accroupie Red
	ENTER, //Hit Red
	p, //Get Red
	l, //Throw Red
	n; //Shop Red
	
	
	static AutTouche toAutTouche(String name) {
		switch(name) {
		case "z":
			return z;
		case "q":
			return q;
		case "d":
			return d;
		case "s":
			return s;
		case "a":
			return a;
		case "e":
			return e;
		case "x":
			return x;
		case "c":
			return c;
		case "SPACE":
			return SPACE;
		case "ENTER":
			return ENTER;
		case "FU":
			return FU;
		case "FD":
			return FD;
		case "FR":
			return FR;
		case "FL":
			return FL;
		case "p":
			return p;
		case "l":
			return l;
		case "n":
			return n;
		default:
			return null;
		}
	}
}
