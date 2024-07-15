package presentacion;

import java.sql.SQLException;
import java.util.Scanner;

import dominio.Cliente;
import dominio.GestorClientes;

public class InterfazLogin {

	final static Scanner KEYBOARD = new Scanner(System.in);
	final static String LOGO = " __                           __  ____                                               \r\n"
			+ "/\\ \\                         /\\ \\/\\  _`\\                                             \r\n"
			+ "\\ \\ \\         __      ___    \\_\\ \\ \\ \\/\\ \\  _ __    __     __      ___ ___     ____  \r\n"
			+ " \\ \\ \\  __  /'__`\\  /' _ `\\  /'_` \\ \\ \\ \\ \\/\\`'__\\/'__`\\ /'__`\\  /' __` __`\\  /',__\\ \r\n"
			+ "  \\ \\ \\L\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\/\\ \\L\\ \\ \\ \\_\\ \\ \\ \\//\\  __//\\ \\L\\.\\_/\\ \\/\\ \\/\\ \\/\\__, `\\\r\n"
			+ "   \\ \\____/\\ \\__/.\\_\\ \\_\\ \\_\\ \\___,_\\ \\____/\\ \\_\\\\ \\____\\ \\__/.\\_\\ \\_\\ \\_\\ \\_\\/\\____/\r\n"
			+ "    \\/___/  \\/__/\\/_/\\/_/\\/_/\\/__,_ /\\/___/  \\/_/ \\/____/\\/__/\\/_/\\/_/\\/_/\\/_/\\/___/ \r\n"
			+ "                                                                                     \r\n"
			+ "                                                                                     ";

	// Inicio en donde el usuario debe de loguearse
	public void run() throws SQLException, Exception {

		boolean salir = false;

		mostrarTextoInicial();
		while (!salir) {
			Cliente cliente = null; 
			while ((cliente = obtenerCliente()) == null ) {
				System.out.println("ERROR. El email o la contraseña no son válidos");
				System.out.println();
			}
			
			InterfazCliente interfazCliente = new InterfazCliente(cliente);
			interfazCliente.run();
		}
	}

	private void mostrarTextoInicial() {
		System.out.println(LOGO);
		System.out.println("-----Los mejores alquileres------");
		System.out.println();
	}
	
	// Se obtiene el usuario de la base de datos según su email y su contraseña
	private Cliente obtenerCliente() throws SQLException, Exception {
		System.out.print("Ingrese su email: ");
		String email = KEYBOARD.next();
		System.out.println();
		System.out.print("Ingrese su password: ");
		String password = KEYBOARD.next();
		System.out.println();
		return GestorClientes.obtenerCliente(email, password);
		
	}
}
