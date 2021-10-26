import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UI {
	
	int m;
	int n;
	int s;
	int e;
	String p;	
	Control C;	
	
	BufferedReader lector;
	
	UI(Control C){
		this.C = C;
		lector = new BufferedReader(new InputStreamReader(System.in));
	}
	
	String leerEntrada() {
		try {
			return lector.readLine();
		} catch (IOException e) {
			return "";
		}
	}	
	
	
	void mostrarTablero() {
		C.mostrarTablero();
		leerEntrada();
		mostrarTableroConJugadores();
	}
	
	
	void mostrarTableroConJugadores() {
		C.mostrarTableroConJugadores();
		rutinaComandos();
	}
	
	
	void rutinaComandos() {
		String cmd = leerEntrada();
		if(cmd.equals("")) {
			C.avanzar();
			rutinaComandos();
		}
		if(cmd.equals("num")) {
			mostrarTablero();
			rutinaComandos();
		}
		if(cmd.equals("simul")) {
			C.avanzarConSimulacion();
			rutinaComandos();
		}
		if(cmd.equals("menu")) {
			iniciar();
		}
		
	}
	
	
	
	void crearJuego() {
		System.out.print("\nIngrese los parametros del juego: ");
		String cadena = leerEntrada();
		boolean exito = false;
		try {
			String[] items = cadena.split(" ");
			if (items.length == 5) {
				if(items[4].length() > 0) {
					m = Integer.parseInt(items[0]);
					n = Integer.parseInt(items[1]);
					s = Integer.parseInt(items[2]);
					e = Integer.parseInt(items[3]);
					p = items[4];
					exito = true;
				}
			}
		}catch(Exception e){
		}
		if(exito) {
			C.crearJuego(m, n, s, e, p);
			mostrarTablero();
		}else {
			System.out.println("Parametros incorrectos!");
			iniciar();
		}
	}
	
	
	void posiciones() {
		
	}
	
	
	void iniciar() {		
		System.out.println("\nSnakes and Ladders"); 
		System.out.println("Menu");
		System.out.println("1 -> Jugar");
		System.out.println("2 -> Tablero de posiciones");
		System.out.println("3 -> Salir");
		System.out.print("Opcion: ");
		int o = 0;
		try {
			o = Integer.parseInt(leerEntrada());			
		}catch (Exception e) {
			o = 0;						
		}
		switch (o) {
		case 1: {
			crearJuego();
			break;
		}
		case 2: {
			posiciones();
			break;
		}
		case 3: {
			System.out.println("\nHasta luego!");
			break;
		}
		default:
			System.out.println("Opcion no valida!");
			iniciar();
		}	
	}
	
	

}
