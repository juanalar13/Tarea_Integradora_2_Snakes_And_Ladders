
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Tablero t = new Tablero(6, 5, 2, 3);
		//Jugadores g = new Jugadores("##$%&$", t.primero);
		///Casilla c = t.getItem(t.primero, 5);
		//System.out.print(c.index);
		//t.CrearSerpiente(t.primero);
		//t.Mostrar(t.primero);
		//System.out.print(t.tableroToString());

		//System.out.print(t.tableroToStringJ(g));
		
		Control c = new Control();
		UI ui = new UI(c);
		
		ui.iniciar();

	}

}
