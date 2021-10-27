package Model;

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
