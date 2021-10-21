import java.util.Random;  

public class Tablero {
	
	Casilla primero;
	Casilla ultimo;
	int count = 0;
	
	int m;
	int n;
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
		CrearTablero(count);		
	}
	
	
	void insertar(Casilla c) {
		if(primero == null) {
			primero = c;
			ultimo = c;
		}else {
			ultimo.siguiente = c;
			ultimo = c;
		}
	}
	
	
	void CrearTablero(int n) {		
		if(n > 0) {
			insertar(new Casilla(count-n+1));
			CrearTablero(n - 1);
		}else {
			CrearEscaleras(e);
			CrearSerpientes(s);
		}
	}
	
	
	void Mostrar(Casilla c) {
		System.out.println(c.index);
		if(!c.equals(ultimo)) {
			Mostrar(c.siguiente);
		}
	}
	
	int random() {
		Random ran = new Random();
		return 2 + ran.nextInt(count-2);
	}
	
	int fila(int x) {
		return 1 + (x-1)/m;
	}
	
	Casilla getItem(Casilla c, int index) {
		if(c.index == index) {
			return c;
		}else {
			getItem(c.siguiente, index);
		}
		return primero;
	}
	
	void CrearEscalera(Casilla c) {
		if(c.equals(primero)) {			
			Casilla x = getItem(primero, random());
			if(x.avatar == 0) {
				CrearEscalera(x); 
			}else {
				CrearEscalera(primero);
			}
		}else {
			Casilla x = getItem(primero, random());
			if(x.avatar == 0 && fila(x.index) != fila(c.index)) {
				x.avatar = e_id;
				c.avatar = e_id;
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
			Casilla x = getItem(primero, random());
			if(x.avatar == 0) {
				CrearSerpiente(x); 
			}else {
				CrearSerpiente(primero);
			}
		}else {
			Casilla x = getItem(primero, random());
			if(x.avatar == 0 && fila(x.index) != fila(c.index)) {
				x.avatar = s_id;
				c.avatar = s_id;
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
	
	

}
