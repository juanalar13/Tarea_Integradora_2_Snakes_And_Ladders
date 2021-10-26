package Model;
// Clase para el Arbol de busqueda binaria
public class Puntajes {
	
	Puntaje raiz;
	int count = 0;
	
	
	void agregar(Puntaje p, Puntaje actual) {
		if(p.puntaje >= actual.puntaje) {
			if(actual.izquierdo == null) {
				actual.izquierdo = p;
			}else {
				agregar(p, actual.izquierdo);
			}
			
		}else {
			if(actual.derecho == null) {
				actual.derecho = p;
			}else {
				agregar(p, actual.derecho);
			}
		}		
	}
	
	public void agregar(Puntaje p) {
		if(raiz == null) {
			raiz = p;
			count++;
		}else {
			agregar(p, raiz);
		}		
	}
	
	
	void MostrarInOrden(Puntaje actual) {
		if(actual != null) {
			MostrarInOrden(actual.izquierdo);			
			System.out.println(String.format("%10s  %6s  %7s", actual.nick, actual.avatar, actual.puntaje));
			MostrarInOrden(actual.derecho);
		}			
	}
	
	
	public void MostrarInOrden() {
		System.out.println(String.format("%10s  %6s  %s", "Nick", "Avatar", "Puntaje"));
		if(raiz == null) {
			System.out.println(String.format("........No hay puntajes......"));
		}
		if(raiz != null) {
			MostrarInOrden(raiz);
		}	
	}
	
	

}
