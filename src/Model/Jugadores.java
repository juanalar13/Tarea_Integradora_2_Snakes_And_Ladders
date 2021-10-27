package Model;
import java.util.Random;


// Clase para los Jugadores (lista)
public class Jugadores {
	
	Jugador primero;
	Jugador ultimo;
	Casilla primerCasilla;	
	String p;
	int count;
	
	Jugador actual;
	public Jugador ganador;
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
			ultimo.siguiente = primero; // permite el bucle de turnos
		}
		count++;
	}
	
	
	boolean existeJugador(String a, Jugador g) {
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
					return existeJugador(a, g.siguiente);
				}
			}
		}		
	}
	
		
	void CrearJugadores(int n) {		
		if(n > 0) {
			String a = ""+p.charAt(p.length()-n);
			if(!existeJugador(a, primero)) {
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
		if(actual.enMeta(t)) {
			System.out.println("El jugador " + actual.avatar + " ha ganado el juego, con " + actual.movimientos + " movimientos");
			ganador = actual;
			t.mostrarTableroJ(this);
			return true;
		}else {			
			actual = actual.siguiente;
			t.mostrarTableroJ(this);
			return false;
		}
	}
	

}
