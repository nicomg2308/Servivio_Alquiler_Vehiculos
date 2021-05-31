package logica;

public class Turismo extends Vehiculo {
	public Turismo(String marca, String placa) {
		super(marca, placa, "Turismo");
		super.tarifa = 45000;
	}
}
