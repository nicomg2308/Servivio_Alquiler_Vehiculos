package logica;

public abstract class Builder {

	public abstract Vehiculo getVehiculo(String marca, String placa);
	public abstract Ingreso getIngreso(String fecha,int tipo,int serial);
	public abstract Propietario getPropietario(long doc, String nombre, String apellido);
}
