package persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dominio.Cliente;

public class Agente {
	// instancia del agente
	protected static Agente instancia = null;

	// parametros necesarios para conexion
	public final static String HOST = "localhost";
	public final static String PORT = "3306";
	public final static String DB_NAME = "landdreams";
	public final static String USER = "root";
	public final static String PASSWORD = "";

	public final static String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + "?" + "user=" + USER
			+ "&password=" + PASSWORD;
	
	// Conexion con la base de datos
	protected static Connection mBD;

	public static Agente getInstance() throws SQLException {
		if (instancia == null) {
			instancia = new Agente();
		}
		return instancia;
	}

	public int insert(String SQL) throws SQLException {
		int res = 0;
		try (Connection conn = DriverManager.getConnection(URL)) {
			try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
				res = stmt.executeUpdate();
			}
		}
		return res;
	}
	
	public int update(String SQL) throws SQLException {
		int res = 0;
		try (Connection conn = DriverManager.getConnection(URL)) {
			try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
				res = stmt.executeUpdate();
			}
		}
		return res;
	}
	
	
	public QueryResult select(String SQL) throws SQLException {
		QueryResult result = new QueryResult();

		try (Connection conn = DriverManager.getConnection(URL)) {
			try (Statement stmt = conn.createStatement()) {
				ResultSet queryResult = stmt.executeQuery(SQL);
				ResultSetMetaData metaData = queryResult.getMetaData();

				while (queryResult.next()) {
					result.insertRow();
					for (int i = 1; i <= metaData.getColumnCount(); i++) {	
						// Se evita conflictos entre atributos de distintas tablas que tengan el mismo nombre
						String attributeName = metaData.getTableName(i) + "." + metaData.getColumnLabel(i);
						result.addAttribute(attributeName, queryResult.getObject(i));
					}
				}
			}
		}
		return result;
	}
}