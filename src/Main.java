import Controlador.Control;
import Vista.UI;
//import Model.*;

public class Main {
	
	static Control c;
	static UI ui;

	public static void main(String[] args) {		
			
		/*
		Puntaje p1 = new Puntaje("lorenzo", "$", 1);
		Puntaje p2 = new Puntaje("zoil", "%", 1);
		Puntaje p3 = new Puntaje("carlos", "#", 9);
		Puntaje p4 = new Puntaje("diego", "&", 1);		
		Puntajes P = new Puntajes();		
		P.agregar(p1);		
		P.agregar(p2);		
		P.agregar(p3);
		P.agregar(p4);		
		P.MostrarInOrden();	
		*/
		
		c = new Control();
		ui = new UI(c);
		ui.iniciar();

	}

}
