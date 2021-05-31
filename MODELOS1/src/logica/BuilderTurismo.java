package logica;

public class BuilderTurismo extends Builder {

	@Override
	public Vehiculo getVehiculo(String marca, String placa) {
		// TODO Auto-generated method stub
		return new Turismo(marca, placa);
	}

	@Override
	public Ingreso getIngreso(String fecha, int tipo, int serial) {
		// TODO Auto-generated method stub
		return new Ingreso(fecha, tipo, serial);
	}

	@Override
	public Propietario getPropietario(long doc, String nombre, String apellido) {
		// TODO Auto-generated method stub
		return new Propietario(doc, nombre, apellido);
	}

}
