package dominio;

import persistencia.Row;

public class Vehiculo {

	private String idVehiculo;
	private int antiguedadVehiculo;
	private boolean isAlquilado;
	private String nombre;
	private int precioBase;
	private String tipo;

	public Vehiculo(String idVehiculo, int antiguedadVehiculo, String nombre, boolean isAlquilado, int precioBase, String tipo) {
		this.idVehiculo = idVehiculo;
		this.antiguedadVehiculo = antiguedadVehiculo;
		this.nombre = nombre;
		this.isAlquilado = isAlquilado;
		this.precioBase = precioBase; 
		this.tipo = tipo;
	}
	
	public Vehiculo(Row record) {
		this(record.getString("vehiculos.idVehiculo"), record.getInt("vehiculos.antiguedadVehiculo"),
				record.getString("vehiculos.nombre"), record.getBoolean("vehiculos.isAlquilado"), record.getInt("vehiculos.precioBase"),
				record.getString("vehiculos.tipo"));
	}

	public String getIdVehiculo() {
		return idVehiculo;
	}
	
	public boolean isAlquilado() {
		return isAlquilado;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getPrecioBase() {
		return precioBase;
	}
	
	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", antiguedadVehiculo=" + antiguedadVehiculo + ", isAlquilado="
				+ isAlquilado + ", nombre=" + nombre + "]";
	}

	public int getAntiguedadVehiculo() {
		return antiguedadVehiculo;
	}
}
