package logica;

import java.util.ArrayList;

 public class Servicio {
	private long documentoIdentidad;
	public ArrayList<String> tipoServicio;
	public ArrayList<String> direccionOrigen;
	public ArrayList<String> direccionDestino;
	public ArrayList<String> fecha;
	private int contadorServicio;

	public Servicio(long documentoIdentidad, Vehiculo carro, String fecha, String direccionOrigen, String direccionDestino) {
		this.tipoServicio = new ArrayList<String>();
		this.direccionDestino = new ArrayList<String>();
		this.direccionOrigen = new ArrayList<String>();
		this.fecha = new ArrayList<String>();
		setContadorServicio(0);
		this.documentoIdentidad = documentoIdentidad;
		this.tipoServicio.add(carro.getTipoVehiculo());
		this.direccionOrigen.add(direccionOrigen);
		this.direccionDestino.add(direccionDestino);
		this.fecha.add(fecha);
	}

	public long getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(long documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public int getContadorServicio() {
		return contadorServicio;
	}

	public void setContadorServicio(int contadorServicio) {
		this.contadorServicio = contadorServicio;
	}
}
