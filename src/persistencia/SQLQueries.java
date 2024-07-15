package persistencia;

public class SQLQueries {

	public static final String OBTENER_CLIENTE = "SELECT * FROM " + "clientes "
			+ "WHERE email = '%s' AND password = '%s'";

	public static final String CREAR_ALQUILER = "INSERT INTO alquileres " + "(idAlquileres, DNICliente, nombreVehiculo, diasDeAlquiler, importe )"
			+ "VALUES ('%s', '%s', '%s', '%d', '%d')";

	public static final String OBTENER_VEHICULOS_DISPONIBLES = " SELECT * FROM " + " vehiculos "
			+ "WHERE isAlquilado = false";

	public static final String CAMBIO_A_ALQUILADO = "UPDATE vehiculos SET isAlquilado = true WHERE idVehiculo = '%s'";
	
	public static final String OBTENER_ALQUILERES_CLIENTE =	"SELECT * FROM " +  " alquileres "
			+ "WHERE DNICliente = '%s'";
	
}
