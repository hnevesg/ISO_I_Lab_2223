package dominio;

import java.sql.SQLException;

import persistencia.Agente;
import persistencia.QueryResult;
import persistencia.Row;
import persistencia.SQLQueries;

public class GestorClientes {

	// Crea un objeto cliente con los datos de la base de datos landdreams. Si no existe, devuelve null.
	
	public static Cliente obtenerCliente(String email, String password) throws SQLException, Exception {
		QueryResult result = Agente.getInstance().select(SQLQueries.OBTENER_CLIENTE.formatted(email, password));

		if (result.isEmpty()) 
			return null;
		
		Row record = result.getRow(1);

		Cliente cliente = new Cliente(record);

		return cliente;

	}

}
