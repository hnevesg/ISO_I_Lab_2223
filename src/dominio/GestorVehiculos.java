package dominio;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import persistencia.Agente;
import persistencia.Row;
import persistencia.SQLQueries;
import persistencia.QueryResult;

public class GestorVehiculos {

	// Devuelve lista con los vehículos actualmente disponibles
	public static List<Vehiculo> obtenerVehiculos() throws SQLException {
		List<Vehiculo> vehiculos = new ArrayList<>();

		QueryResult result = Agente.getInstance().select(SQLQueries.OBTENER_VEHICULOS_DISPONIBLES);

		for (Row record : result.getRecords()) {
			vehiculos.add(new Vehiculo(record));
		}

		return vehiculos;
	}

}
