package Vista;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Controlador.Control;


public class UI {
	
	int m;
	int n;
	int s;
	int e;
	String p;	
	Control C;	
	
	BufferedReader lector;
	
	public UI(Control C){
		this.C = C;
		lector = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	String leerEntrada(String s) {
		System.out.print(s);
		try {
			return lector.readLine();
		} catch (IOException e) {
			return "";
		}
	}	
	
	
	void mostrarTablero() {
		C.mostrarTablero();
		leerEntrada("Salto de linea para Continuar: ");
		mostrarTableroConJugadores();
	}
	
	
	void mostrarTableroConJugadores() {
		C.mostrarTableroConJugadores();
		rutinaComandos();
	}
	
	
	void rutinaComandos() {
		String cmd = leerEntrada("Salto de linea o comando[num simul menu] para continuar: ");
		if(cmd.equals("")) {
			if(C.avanzar()) {
				String nick = leerEntrada("Por favor ingrese el nick para el ganador: ");
				C.registrarGanador(nick);
				iniciar();
			}else {
				rutinaComandos();
			}			
		}
		if(cmd.equals("num")) {
			mostrarTablero();
			rutinaComandos();
		}
		if(cmd.equals("simul")) {
			if(C.avanzarConSimulacion()) {
				String nick = leerEntrada("Por favor ingrese el nick para el ganador: ");
				C.registrarGanador(nick);
				iniciar();
			}else {
				rutinaComandos();
			}			
		}
		if(cmd.equals("menu")) {
			iniciar();
		}		
	}
	
	
	
	void crearJuego() {
		String cadena = leerEntrada("\nIngrese los parametros del juego: ");
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
	
	
	
	
	public void iniciar() {		
		System.out.println("\nSnakes and Ladders"); 
		System.out.println("Menu");
		System.out.println("1 -> Jugar");
		System.out.println("2 -> Tablero de posiciones");
		System.out.println("3 -> Salir");
		int o = 0;
		try {
			o = Integer.parseInt(leerEntrada("Ingrese opcion: "));			
		}catch (Exception e) {
			o = 0;						
		}
		switch (o) {
		case 1: {
			crearJuego();
			break;
		}
		case 2: {
			C.mostrarPosiciones();
			leerEntrada("Salto de linea para volver al menu: ");
			iniciar();
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
