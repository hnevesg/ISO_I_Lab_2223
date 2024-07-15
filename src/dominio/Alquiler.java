package dominio;

import persistencia.Row;

public class Alquiler {
	private Vehiculo vehiculo;
	private Cliente cliente;
	private int diasDeAlquiler;
	private int importe;
	private String idAlquiler;
	private String DNICliente;
	private String nombreVehiculo;

	public Alquiler(Cliente cliente, Vehiculo vehiculo, int diasDeAlquiler, int importe) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.diasDeAlquiler = diasDeAlquiler;
		this.importe = importe;
	}

	public Alquiler(Row record) {
		this(record.getString("alquileres.idAlquileres"), record.getString("alquileres.nombreVehiculo"),
				record.getString("alquileres.DNICliente"), record.getInt("alquileres.diasDeAlquiler"),
				record.getInt("alquileres.importe"));
	}

	public Alquiler(String idAlquiler, String nombreVehiculo, String DNICliente, int diasDeAlquiler, int importe) {
		this.idAlquiler = idAlquiler;
		this.nombreVehiculo = nombreVehiculo;
		this.DNICliente = DNICliente;
		this.diasDeAlquiler = diasDeAlquiler;
		this.importe = importe;

	}

	public int getImporte() {
		return importe;
	}

	public String getIdAlquiler() {
		return idAlquiler;
	}

	public String getDNICliente() {
		return DNICliente;
	}

	public String getNombreVehiculo() {
		return nombreVehiculo;
	}

	public int getDiasDeAlquiler() {
		return diasDeAlquiler;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
