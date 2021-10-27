package Controlador;
import Model.Juego;
import Model.Puntaje;
import Model.Puntajes;


// Clase para el controlador, el mediador entre la UI y el modelo
public class Control {
	
	Puntajes P = new Puntajes();	
	Juego J;	
	
	
	public void crearJuego(int m, int n, int s, int e, String p) {
		J = new Juego(m, n, s, e, p);
	}
	
	public void mostrarTablero() {
		J.mostrarTablero();
	}
	
	public void mostrarTableroConJugadores() {
		J.mostrarTableroJ();
	}
	
	public boolean avanzar() {
		return J.avanzar();
	}
	
	public boolean avanzarConSimulacion() {
		return J.avanzarConSimulacion();
	}
	
	
	public void registrarGanador(String nick) {
		P.agregar(new Puntaje(nick, J.jugadores.ganador.avatar, J.jugadores.ganador.movimientos * J.tablero.count));
	}
	
	
	public void mostrarPosiciones() {
		P.MostrarInOrden();
	}

}
