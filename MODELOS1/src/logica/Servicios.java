package logica;

import java.util.ArrayList;

public class Servicios {
	/* Clase Singleton */

	private ArrayList<Servicio> servicios;
	private static Servicios instancia;

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	private Servicios() {
		servicios = new ArrayList<Servicio>();
	}

	public int tamano() {
		return servicios.size();
	}

	public static Servicio addServicio(long documentoIdentidad, Vehiculo vehiculo, String fecha, String direccionOrigen,
			String direccionDestino) {
		boolean bandera = false;
		int indicador = 0;
		for (int i = 0; i < instancia.servicios.size() && !bandera; i++) {
			if (instancia.servicios.get(i).getDocumentoIdentidad() == documentoIdentidad) {
				instancia.servicios.get(i).setContadorServicio(instancia.servicios.get(i).getContadorServicio() + 1);
				instancia.servicios.get(i).tipoServicio.add(vehiculo.getTipoVehiculo());
				instancia.servicios.get(i).fecha.add(fecha);
				instancia.servicios.get(i).direccionOrigen.add(direccionOrigen);
				instancia.servicios.get(i).direccionDestino.add(direccionDestino);
				bandera = true;
				indicador = i;
			}
		}
		if (!bandera) {
			instancia.servicios
					.add(new Servicio(documentoIdentidad, vehiculo, fecha, direccionOrigen, direccionDestino));
			return instancia.servicios.get(instancia.servicios.size() - 1);
		} else {
			return instancia.servicios.get(indicador);
		}
	}

	public static Servicio getServicio(int indicador) {
		return instancia.servicios.get(indicador);
	}

	public static Servicios getInstance() {
		if (instancia == null) {
			instancia = new Servicios();
		}
		return instancia;
	}
}
