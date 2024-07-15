package dominio;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import persistencia.QueryResult;
import persistencia.Row;
import persistencia.Agente;
import persistencia.SQLQueries;

public class GestorAlquileres {

	public static void hacerAlquiler(Alquiler alquiler) throws Exception {
		try {
			Agente.getInstance()
					.insert(SQLQueries.CREAR_ALQUILER.formatted(alquiler.getVehiculo().getIdVehiculo(),
							alquiler.getCliente().getDNI(), alquiler.getVehiculo().getNombre(),
							alquiler.getDiasDeAlquiler(), alquiler.getImporte()));

		} catch (SQLException e) {
			System.out.println("Error SQL");
		}
	}

	public static int calcularImporte(int diasDeAlquiler, Vehiculo vehiculo) {
		return diasDeAlquiler * vehiculo.getPrecioBase();
	}

	public static void marcarComoAlquilado(Vehiculo vehiculo) {

		try {
			Agente.getInstance().update(SQLQueries.CAMBIO_A_ALQUILADO.formatted(vehiculo.getIdVehiculo()));
		} catch (SQLException e) {
			System.out.println("Error SQL");
		}
	}
	
	// Devuele lista de los alquileres según el DNI del cliente
	public static List<Alquiler> obtenerAlquileres(Cliente cliente) throws SQLException {
		List<Alquiler> alquileres = new ArrayList<>();

		QueryResult result = Agente.getInstance()
				.select(SQLQueries.OBTENER_ALQUILERES_CLIENTE.formatted(cliente.getDNI()));

		for (Row record : result.getRecords()) {
			alquileres.add(new Alquiler(record));

		}

		return alquileres;
	}

}
