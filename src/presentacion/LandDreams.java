package presentacion;

import java.sql.SQLException;

// Clase que contine el main method
public class LandDreams {

	public static void main(String[] args) throws SQLException, Exception {
		InterfazLogin login = new InterfazLogin();
		login.run();
	}
}
