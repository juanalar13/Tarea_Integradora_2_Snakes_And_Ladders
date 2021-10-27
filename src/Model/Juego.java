package Model;


// Clase para el Juego
public class Juego {
	
	public Tablero tablero;
	public Jugadores jugadores;	
	
	
	public Juego(int m, int n, int s, int e, String p){
		tablero = new Tablero(m, n, s, e);
		jugadores = new Jugadores(p, tablero.primero);
	}	
	
	public void mostrarTablero() {
		tablero.mostrarTablero();
	}
	
	public void mostrarTableroJ() {
		tablero.mostrarTableroJ(jugadores);
	}
	
	public boolean avanzar() {
		return jugadores.avanzar(tablero);
	}
	
	
	boolean avanzarConSimulacion(int count) {
		if(count > 0) {			
			if(avanzar()) {
				return true;
			}else {
				try {Thread.sleep(2000);} catch (Exception e) {System.out.println(e);}
				return avanzarConSimulacion(count-1);
			}
		}else {
			return false;
		}
	}
	
	public boolean avanzarConSimulacion() {
		return avanzarConSimulacion(jugadores.count);
	}
	

}
