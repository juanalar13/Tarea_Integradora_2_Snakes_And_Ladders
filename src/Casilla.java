
public class Casilla {
	int index;
	Casilla siguiente;
	Casilla salida;
	int avatar;
	boolean esEntrada;
	
	public Casilla(int id) {
		this.index = id;
		esEntrada = false;
		avatar = 0;
	}
}
