package logica;

public class Director {
	private Builder builder;
	int serial;

	public Director() {
		serial = 0;
	}

	public Vehiculo constructor(int tipo, String marca, String placa, long documentoIdentidad, String nombrePropietario,
			String apellidoPropietario, String fechaIngreso) {
		serial++;
		switch (tipo) {
		case 0:
			builder = new BuilderPersonal();
			break;
		case 1:
			builder = new BuilderOficina();
			break;
		case 2:
			builder = new BuilderTurismo();
			break;
		default:
			serial--;
			throw new RuntimeException("El tipo escogido es inválido");
		}
		if (builder != null) {
			Vehiculo vehiculo = builder.getVehiculo(marca, placa);
			vehiculo.setDueno(builder.getPropietario(documentoIdentidad, nombrePropietario, apellidoPropietario));
			vehiculo.setIngreso(builder.getIngreso(fechaIngreso, tipo, serial));
			return vehiculo;
		} else {
			throw new RuntimeException("No se pudo terminar el proceso");
		}
	}
}
