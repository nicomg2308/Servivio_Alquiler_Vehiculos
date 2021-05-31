package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Controlador {
	public Servicios registros;
	public ArrayList<Vehiculo> vehiculos;
	public Director director;

	public Controlador() {
		director = new Director();
		vehiculos = new ArrayList<Vehiculo>();
		registros = Servicios.getInstance();
	}

	public int getCantidadClientes() {
		return registros.getServicios().size();
	}

	public void addVehiculo(int tipo, String marca, String placa, long documentoIdentidad, String nombrePropietario,
			String apellidoPropietario, String fechaIngreso) {
		vehiculos.add(director.constructor(tipo, marca, placa, documentoIdentidad, nombrePropietario,
				apellidoPropietario, fechaIngreso));
	}

	public int getServicioPersonal() {
		int contador = 0;
		for (int i = 0; i < registros.getServicios().size(); i++) {
			for (int j = 0; j < registros.getServicios().get(i).tipoServicio.size(); j++) {
				if (registros.getServicios().get(i).tipoServicio.get(j).equals("Personal")) {
					contador++;
				}
			}
		}
		return contador;
	}

	public int getServicioOficina() {
		int contador = 0;
		for (int i = 0; i < registros.getServicios().size(); i++) {
			for (int j = 0; j < registros.getServicios().get(i).tipoServicio.size(); j++) {
				if (registros.getServicios().get(i).tipoServicio.get(j).equals("Oficina")) {
					contador++;
				}
			}
		}
		return contador;
	}

	public int getServicioTurismo() {
		int contador = 0;
		for (int i = 0; i < registros.getServicios().size(); i++) {
			for (int j = 0; j < registros.getServicios().get(i).tipoServicio.size(); j++) {
				if (registros.getServicios().get(i).tipoServicio.get(j).equals("Turismo")) {
					contador++;
				}
			}
		}
		return contador;
	}

	public Vehiculo getVehiculo(int id) {
		for (int i = 0; i < vehiculos.size(); i++) {
			if (vehiculos.get(i).getTipoVehiculoEntero() == id) {
				return vehiculos.get(i);
			}
		}
		return null;
	}

	public String getServicioMenos() {
		int[] arreglo = { getServicioOficina(), getServicioPersonal(), getServicioTurismo() };
		Hashtable<Integer, String> opcion = new Hashtable<Integer, String>();
		opcion.put(getServicioOficina(), "Oficina");
		opcion.put(getServicioPersonal(), "Personal");
		opcion.put(getServicioTurismo(), "Turismo");
		Arrays.sort(arreglo);
		return opcion.get(arreglo[0]);
	}

	public void agregarServicio(long documentoIdentidad, Vehiculo vehiculo, String fecha, String direccionOrigen,
			String direccionDestino) {
		Servicios.addServicio(documentoIdentidad, vehiculo, fecha, direccionOrigen, direccionDestino);
		registros = Servicios.getInstance();
	}

	public int obtenerCantidadServicios(long documentoIdentidad) {
		for (int i = 0; i < registros.getServicios().size(); i++) {
			if (registros.getServicios().get(i).getDocumentoIdentidad() == documentoIdentidad) {
				return registros.getServicios().get(i).getContadorServicio();
			}
		}
		return -1;
	}

	public long getMasFrecuente() {
		int tempo = 0;
		long resultado = -1;
		for (int i = 0; i < registros.getServicios().size(); i++) {
			if (obtenerCantidadServicios(registros.getServicios().get(i).getDocumentoIdentidad()) >= tempo) {
				resultado = registros.getServicios().get(i).getDocumentoIdentidad();
				tempo = obtenerCantidadServicios(registros.getServicios().get(i).getDocumentoIdentidad());
			}
		}
		return resultado;
	}

	public long getSaldoCompleto() {
		return getServicioPersonal() * 15000 + getServicioTurismo() * 45000 + getServicioOficina() * 24000;
	}
}
