
public class Control {
	
	Juego J;	
	
	void crearJuego(int m, int n, int s, int e, String p) {
		J = new Juego(m, n, s, e, p);
	}
	
	void mostrarTablero() {
		J.mostrarTablero();
	}
	
	void mostrarTableroConJugadores() {
		J.mostrarTableroJ();
	}
	
	void avanzar() {
		J.avanzar();
	}
	
	void avanzarConSimulacion() {
		J.avanzarConSimulacion();
	}

}
