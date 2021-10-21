
public class Jugadores {
	
	Jugador primero;
	Jugador ultimo;
	Casilla primerCasilla;
	
	String p;
	
	
	Jugadores(String p, Casilla primerCasilla) {
		this.p = p;
		this.primerCasilla = primerCasilla;
		CrearJugadores(p.length());
	}	
	
	
	void insertar(Jugador g) {
		if(primero == null) {
			primero = g;
			ultimo = g;
		}else {
			ultimo.siguiente = g;
			ultimo = g;
		}
	}	
	
		
	void CrearJugadores(int n) {		
		if(n > 0) {
			insertar(new Jugador(""+p.charAt(p.length()-n), primerCasilla));
			CrearJugadores(n - 1);
		}
	}
	
	
	String jugadoresEnCasilla(Casilla c, Jugador g, String s) {		
		if(g.equals(ultimo)) {
			if(g.casilla.equals(c)) {
				s += g.avatar;
			}
			return s;
		}else {
			if(g.casilla.equals(c)) {
				s += g.avatar;
			}
			jugadoresEnCasilla(c, g.siguiente, s);
		}
		return s;
	}
	
	

}
