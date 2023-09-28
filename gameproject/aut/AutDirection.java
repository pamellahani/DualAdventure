package aut;

public enum AutDirection {
	R, // Right
	L, // Left
	B, // Back (direction inverse)
	F, // Direction actuelle
	H, // Position actuelle
	D; // Down (s'acroupir)
	
	static AutDirection toAutDirection(String name) {
		switch(name) {
		case "R":
			return R;
		case "L":
			return L;
		case "B":
			return B;
		case "F":
			return F;
		case "D":
			return D;
		case "H":
			return H;
		default:
			return null;
		}
	}
	
}
