
public class Juego {
	
	Tablero tablero;
	Jugadores jugadores;	
	
	
	Juego(int m, int n, int s, int e, String p){
		tablero = new Tablero(m, n, s, e);
		jugadores = new Jugadores(p, tablero.primero);
	}	
	
	void mostrarTablero() {
		System.out.println(tablero.tableroToString());
	}
	
	void mostrarTableroJ() {
		System.out.println(tablero.tableroToStringJ(jugadores));
	}
	
	boolean avanzar() {
		return jugadores.avanzar(tablero);
	}
	
	
	void avanzarConSimulacion(int count) {
		if(count > 0) {
			avanzar();
			try {Thread.sleep(2000);} catch (Exception e) {System.out.println(e);}
			avanzarConSimulacion(count-1);
		}
	}
	
	void avanzarConSimulacion() {
		avanzarConSimulacion(jugadores.count);
	}
	

}
