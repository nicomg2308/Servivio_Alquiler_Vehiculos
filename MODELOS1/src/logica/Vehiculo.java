package logica;

public abstract class Vehiculo {
	private Ingreso ingreso;
	private Propietario dueno;
	private String marca;
	private String placa;
	private String tipoVehiculo;
	protected long tarifa;

	public Vehiculo(String marca, String placa, String tipoVehiculo) {
		this.marca = marca;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
	}

	public Ingreso getIngreso() {
		return ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}

	public Propietario getDueno() {
		return dueno;
	}

	public void setDueno(Propietario dueno) {
		this.dueno = dueno;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public int getTipoVehiculoEntero() {
		switch (tipoVehiculo) {
		case "Oficina":
			return 1;
		case "Personal":
			return 0;

		case "Turismo":
			return 2;

		default:
			throw new RuntimeException("Tipo invalido");

		}
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
}
