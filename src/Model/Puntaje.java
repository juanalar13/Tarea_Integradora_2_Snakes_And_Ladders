package Model;


// Clase para el Nodo del arbol de busqueda binaria
public class Puntaje {
	
	String nick;
	String avatar;
	int puntaje;
	
	Puntaje izquierdo;
	Puntaje derecho;
	
	
	public Puntaje(String nick, String avatar, int puntaje) {
		this.avatar = avatar;
		this.puntaje = puntaje;
		this.nick = nick;
	}	
	
	void mostrar() {
		System.out.println("[nick=" + nick + ", avatar=" + avatar + ", puntaje=" + puntaje + "]");
	}

	
	

}
