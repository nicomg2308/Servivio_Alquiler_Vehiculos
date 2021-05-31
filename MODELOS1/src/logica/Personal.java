package logica;

public class Personal extends Vehiculo {
	public Personal(String marca, String placa) {
		super(marca, placa, "Personal");
		super.tarifa = 15000;
	}
}
