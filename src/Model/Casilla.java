package Model;


// Clase para la Casilla (Clase para el Nodo de la lista Tablero)
public class Casilla {
	int index;         // Indice de la casilla (lo que la enumera), va desde 1
	Casilla siguiente;
	Casilla salida;
	int avatar;        // avatar numerico de la casilla: 0 (vacia), positivo(escalera), negativo(serpiente)
	boolean esEntrada; // indica si es entrada de serpiente o escalera
	
	public Casilla(int id) {
		this.index = id;
		esEntrada = false;
		avatar = 0;
	}
	
	String avatarToString() {
		if(avatar > 0) {
			return ""+avatar;
		}else {
			if(avatar < 0) {
				return ""+(char)(64-avatar);
			}else {
				return " ";
			}
		}
	}
	
}
