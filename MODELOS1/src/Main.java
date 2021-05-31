import logica.Controlador;
import ventana.Interfaz;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador controlador = new Controlador();
		Interfaz interfacesita = new Interfaz(controlador);
		interfacesita.setVisible(true);
	}

}
