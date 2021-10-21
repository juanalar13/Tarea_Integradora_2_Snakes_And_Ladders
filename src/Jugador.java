
public class Jugador {
	Casilla casilla;
	Jugador siguiente;
	String avatar;
	
	Jugador(String avatar, Casilla casilla){
		this.avatar = avatar;
		this.casilla = casilla;
	}
	
	
	void avanzar(int x) {
		if(x > 0) {
			casilla = casilla.siguiente;
			if (casilla.esEntrada) {
				casilla = casilla.salida;
			}else {
				avanzar(x-1);
			}			
		}
	}

}
