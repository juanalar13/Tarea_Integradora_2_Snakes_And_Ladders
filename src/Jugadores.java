import java.util.Random;

public class Jugadores {
	
	Jugador primero;
	Jugador ultimo;
	Casilla primerCasilla;	
	String p;
	int count;
	
	Jugador actual;
	Jugador ganador;
	Random random;
	
	
	Jugadores(String p, Casilla primerCasilla) {
		this.p = p;
		this.primerCasilla = primerCasilla;
		count = 0;
		CrearJugadores(p.length());
		actual = primero;
		ganador = null;
		random = new Random();

	}	
	
	
	void insertar(Jugador g) {
		if(primero == null) {
			primero = g;
			ultimo = g;
		}else {
			ultimo.siguiente = g;
			ultimo = g;
			ultimo.siguiente = primero; // para el bucle
		}
		count++;
	}
	
	
	boolean estaJugador(String a, Jugador g) {
		if(count == 0) {
			return false;
		}else {
			if(g.equals(ultimo)) {
				if(g.avatar.equals(a)) {
					return true;
				}else {
					return false;
				}
			}else {
				if(g.avatar.equals(a)) {
					return true;
				}else {
					return estaJugador(a, g.siguiente);
				}
			}
		}		
	}
	
		
	void CrearJugadores(int n) {		
		if(n > 0) {
			String a = ""+p.charAt(p.length()-n);
			if(!estaJugador(a, primero)) {
				insertar(new Jugador(a, primerCasilla));
			}			
			CrearJugadores(n - 1);
		}
	}
	
	
	String jugadoresEnCasilla(Casilla c, Jugador g, String s) {
		if(g.casilla.equals(c)) {
			s += g.avatar;
		}
		if(g.equals(ultimo)) {			
			return s;
		}else {			
			return jugadoresEnCasilla(c, g.siguiente, s);
		}
	}
	
	String jugadoresEnCasilla(Casilla c) {
		return jugadoresEnCasilla(c, primero, "");
	}
	
	
	boolean avanzar(Tablero t) {
		if(ganador != null) {
			return true;
		}
		int x = 1+random.nextInt(6);
		System.out.println("El jugador " + actual.avatar + " ha lanzado el dado y obtuvo el puntaje " + x);
		actual.avanzar(x, t);
		if(actual.casilla.equals(t.ultimo)) {
			System.out.println("El jugador " + actual.avatar + " ha ganado el juego, con " + actual.movimientos + " movimientos");
			ganador = actual;
			System.out.println(t.tableroToStringJ(this));
			return true;
		}else {			
			actual = actual.siguiente;
			System.out.println(t.tableroToStringJ(this));
			return false;
		}
	}
	

}
