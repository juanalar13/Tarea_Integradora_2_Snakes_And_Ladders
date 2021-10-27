package Model;
import java.util.Random;  

public class Tablero {
	
	Casilla primero;
	Casilla ultimo;
	public int count = 0;
	Random random;	
	int n;
	int m;
	int s;
	int e;	
	int e_id;
	int s_id;
	
	
	public Tablero(int m, int n, int s, int e) {
		this.m = m;
		this.n = n;
		this.s = s;
		this.e = e;
		e_id = 1;
		s_id = -1;
		count = m*n;
		random = new Random();
		CrearTablero(count);		
	}
	
	
	void CrearTablero(int n) {		
		if(n > 0) {
			agregar(new Casilla(count-n+1));
			CrearTablero(n - 1);
		}else {
			CrearEscaleras(e);
			CrearSerpientes(s);
		}
	}	
	
	
	void agregar(Casilla c) {
		if(primero == null) {
			primero = c;
			ultimo = c;
		}else {
			ultimo.siguiente = c;
			ultimo = c;
		}
	}	
	
	// Genera un numero aleatorio en [2, count-1]
	int randomJusto() {
		return 2 + random.nextInt(count-2);
	}
	
	// Retorna la fila a partir del index x de una casilla
	int fila(int x) {
		return 1 + (x-1)/n;
	}
	
	Casilla getItem(Casilla c, int index) {
		if(c.index == index) {
			return c;
		}else {
			return getItem(c.siguiente, index);
		}
	}
	
	void CrearEscalera(Casilla c) {
		if(c.equals(primero)) {			
			Casilla x = getItem(primero, randomJusto());
			if(x.avatar == 0) {
				x.avatar = e_id;
				CrearEscalera(x); 
			}else {
				CrearEscalera(primero);
			}
		}else {
			Casilla x = getItem(primero, randomJusto());
			if(x.avatar == 0 && fila(x.index) != fila(c.index)) {
				x.avatar = e_id;
				e_id++;
				if(c.index > x.index) {
					x.salida = c;
					x.esEntrada = true;
				}else {
					c.salida = x;
					c.esEntrada = true;
				}
			}else {
				CrearEscalera(c);
			}
		}		
	}
	
	
	void CrearSerpiente(Casilla c) {
		if(c.equals(primero)) {
			Casilla x = getItem(primero, randomJusto());
			if(x.avatar == 0) {
				x.avatar = s_id;
				CrearSerpiente(x); 
			}else {
				CrearSerpiente(primero);
			}
		}else {
			Casilla x = getItem(primero, randomJusto());
			if(x.avatar == 0 && fila(x.index) != fila(c.index)) {
				x.avatar = s_id;
				s_id--;
				if(c.index > x.index) {
					c.salida = x;
					c.esEntrada = true;
				}else {
					x.salida = c;
					x.esEntrada = true;
				}
			}else {
				CrearSerpiente(c);
			}
		}		
	}
	
	
	void CrearEscaleras(int n) {		
		if(n > 0) {
			CrearEscalera(primero);
			CrearEscaleras(n - 1);
		}
	}
	
	void CrearSerpientes(int n) {		
		if(n > 0) {
			CrearSerpiente(primero);
			CrearSerpientes(n - 1);
		}
	}
	
	
	String filaToString(int f, Casilla c, String s) {		
		if(fila(c.index) == f) {
			int digitosI = (""+count).length();
			int digitosE = (""+e).length();
			String celda = String.format("[%"+ digitosI +"d%"+digitosE+"s]", c.index, c.avatarToString());
			if(f%2 != 0) {
				s =  s + celda;
			}else {
				s = celda + s;
			}
		}		
		if(!c.equals(ultimo)) {						
			return filaToString(f, c.siguiente, s);
		}else {
			return s;
		}
	}
	
	
	String filaToStringJ(int f, Jugadores j, Casilla c, String s) {		
		if(fila(c.index) == f) {
			int digitosE = (""+e).length();
			int digitosJ = j.count;
			String celda = String.format("[%"+ digitosE +"s"+"%" +digitosJ+"s]", c.avatarToString(), j.jugadoresEnCasilla(c));
			if(f%2 != 0) {
				s =  s + celda;
			}else {
				s = celda + s;
			}
		}		
		if(!c.equals(ultimo)) {						
			return filaToStringJ(f, j, c.siguiente, s);
		}else {
			return s;
		}
	}	
	
	
	
	String tableroToString(int f, String s) {
		if(f > 0) {
			s += filaToString(f, primero, "")+"\n";
			return tableroToString(f-1, s);			
		}else {
			return s;
		}				
	}
	
	String tableroToString() {
		return tableroToString(m, ""); 
	}
	
	
	String tableroToStringJ(int f, Jugadores j, String s) {
		if(f > 0) {
			s += filaToStringJ(f, j, primero, "")+"\n";
			return tableroToStringJ(f-1, j, s);			
		}else {
			return s;
		}				
	}
	
	String tableroToStringJ(Jugadores j) {
		return tableroToStringJ(m, j, "");
	}
	
	
	void mostrarTablero() {
		System.out.println(tableroToString());
	}
	
	void mostrarTableroJ(Jugadores j) {
		System.out.println(tableroToStringJ(j));
	}
	
	

}
