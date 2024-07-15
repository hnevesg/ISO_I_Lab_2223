package presentacion;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

import dominio.Alquiler;
import dominio.Cliente;
import dominio.GestorAlquileres;
import dominio.GestorVehiculos;
import dominio.Vehiculo;

public class InterfazCliente {
	final static Scanner KEYBOARD = new Scanner(System.in);
	public static final int SALIR = 0;
	public static final int REALIZAR_ALQUILER = 1;
	public static final int VISUALIZAR_ALQUILERES = 2;

	private Cliente cliente;

	public InterfazCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private static int mostrarMenu() {
		System.out.print("0. Salir del sistema \n1. Realizar alquiler \n2. Visualizar mis alquileres"
				+ "\nElige una opcion del menu (valor en rango [0, 2]) ");
		int opcion = leerEnRango(0, 2);
		System.out.println();
		return opcion;
	}

	private static int leerEnRango(int limiteInferior, int limiteSuperior) {
		int eleccion = getIntegerFromUser();
		while (eleccion < limiteInferior || eleccion > limiteSuperior) {
			System.out.print("The numero introducido tiene que ser mayor o igual que " + limiteInferior
					+ " o menor o igual igual " + limiteSuperior + ". Prueba otra vez. ");
			eleccion = getIntegerFromUser();
		}
		return eleccion;
	}

	private static int getIntegerFromUser() {
		boolean exito = false;
		int integer = 0;
		do {
			try {
				integer = KEYBOARD.nextInt();
				exito = true;
			} catch (InputMismatchException e) {
				System.out.println("Por favor, escribe una número");
				// Clean the buffer
				KEYBOARD.next();
			}
		} while (!exito);
		return integer;
	}

	public void run() throws Exception {
		System.out.println("Bienvenido " + cliente.getNombre() + " " + cliente.getApellidos());
		boolean exit = false;
		while (!exit) {
			int option = mostrarMenu();
			switch (option) {
			case SALIR:
				exit = true;
				System.out.println("Saliendo del sistema, " + cliente.getNombre() + " " + cliente.getApellidos());
				break;
			case REALIZAR_ALQUILER:
				realizarAlquiler();
				System.out.println();
				break;
			case VISUALIZAR_ALQUILERES:
				visualizarAlquileres(GestorAlquileres.obtenerAlquileres(cliente));
				break;
			}
		}
	}
	
	//Se realiza el alquiler del cliente logueado
	private void realizarAlquiler() throws Exception {
		List<Vehiculo> vehiculos = GestorVehiculos.obtenerVehiculos();
		if (vehiculos.isEmpty()) {
			System.out.println("Lo siento. Ningún vehículo está disponible actualmente");
		} else {
			Vehiculo vehiculo = null;
			int opcion = 0;

			listarVehiculos(vehiculos);
			System.out.print("Elija un vehículo para alquilar (valor en rango [1, " + vehiculos.size() + "]) ");
			opcion = leerEnRango(1, vehiculos.size());
			vehiculo = vehiculos.get(opcion - 1);
			System.out
					.print("Elija el número de días que quiere alquilar el vehículo (mínimo 1 día y máximo 14 días) ");

			int diasDeAlquiler = leerEnRango(1, 14);
			int importeTotal = GestorAlquileres.calcularImporte(diasDeAlquiler, vehiculo);

			Alquiler alquiler = new Alquiler(cliente, vehiculo, diasDeAlquiler, importeTotal);

			GestorAlquileres.hacerAlquiler(alquiler);
			GestorAlquileres.marcarComoAlquilado(vehiculo);
			System.out.println("Reserva realizada exitosamente");
		}
	}

	// Se muestra por pantalla los vehículos que el usuario puede alquilar
	private void listarVehiculos(List<Vehiculo> vehiculos) {
		int i = 1;
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println("-" + (i++) + ": " + "\n Nombre: " + vehiculo.getNombre() + "\n Años del vehiculo: "
					+ vehiculo.getAntiguedadVehiculo() + "\n Tipo de vehículo: " + vehiculo.getTipo()
					+ "\n Precio de alquiler por día: " + vehiculo.getPrecioBase());
			System.out.println();
		}
	}

	// Se muestra por pantalla los vehículos alquilados por un usuario
	private void visualizarAlquileres(List<Alquiler> alquileres) {

		int i = 1;
		if (alquileres.isEmpty()) {
			System.out.println("El cliente " + cliente.getNombre() + " " + cliente.getApellidos()
					+ " no tiene actualmente ningún alquiler");
			System.out.println();
		}
		for (Alquiler alquiler : alquileres) {
			System.out.println("-" + (i++) + ": " + "\n Nombre: " + alquiler.getNombreVehiculo()
					+ " \n Numero de días de alquiler: " + alquiler.getDiasDeAlquiler() + " \n Total del importe: "
					+ alquiler.getImporte() + " €");
			System.out.println();
		}

	}
}
