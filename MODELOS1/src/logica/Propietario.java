package logica;

public class Propietario {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private long documentoIdentidad;

	public Propietario(long doc, String nombre, String apellido) {
		String[] nombres = nombre.split(" ");
		String[] apellidos = apellido.split(" ");
		primerNombre = nombres[0];
		if (nombres.length > 1) {
			segundoNombre = nombres[1];
		} else {
			segundoNombre = "";
		}
		primerApellido = apellidos[0];
		if (apellidos.length > 1) {
			segundoApellido = apellidos[1];
		} else {
			segundoApellido = "";
		}
		setDocumentoIdentidad(doc);
	}

	public String getNombreCompleto() {
		return getNombres() + " " + getApellidos();
	}

	public String getNombres() {
		return primerNombre + " " + segundoNombre;
	}

	public String getApellidos() {
		return primerApellido + " " + segundoApellido;
	}

	public long getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(long documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}
}
