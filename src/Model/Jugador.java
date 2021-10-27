package Model;


// Clase para el jugador (Clase para el Nodo de la lista Jugadores) 
public class Jugador {
	Casilla casilla;
	Jugador siguiente;
	public String avatar;
	public int movimientos;
	
	Jugador(String avatar, Casilla casilla){
		this.avatar = avatar;
		this.casilla = casilla;
		movimientos = 0;
	}
	
	void _avanzar(int x, Tablero t) {
		if(x > 0) {			
			if(!casilla.equals(t.ultimo)) {
				casilla = casilla.siguiente;
				if (casilla.esEntrada) {
					casilla = casilla.salida;
				}else {
					_avanzar(x-1, t);
				}				
			}						
		}
	}
	
	void avanzar(int x, Tablero t) {
		movimientos++;
		_avanzar(x, t);	
	}
	
	
	boolean enMeta(Tablero t) {
		return casilla.equals(t.ultimo);
	}


}
