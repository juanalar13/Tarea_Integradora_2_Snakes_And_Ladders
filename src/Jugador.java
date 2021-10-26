
public class Jugador {
	Casilla casilla;
	Jugador siguiente;
	String avatar;
	int movimientos;
	
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


}
