package logica;

public class Oficina extends Vehiculo {
	public Oficina(String marca, String placa) {
		super(marca, placa, "Oficina");
		super.tarifa = 24000;
	}

}
