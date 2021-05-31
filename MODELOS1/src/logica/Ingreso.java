package logica;

public class Ingreso {
	private String id;
	private String fecha;

	public Ingreso(String fecha, int tipo, int serial) {
		id = fecha.replaceAll("/", "") + Integer.toString(tipo) + Integer.toString(serial);
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public String getFecha() {
		return fecha;
	}

}
