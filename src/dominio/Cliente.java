package dominio;

import persistencia.Row;

public class Cliente {
	private String nombre;
	private String apellidos;
	private String DNI; 
	private String email; 
	private String password;
	private String telefono;
	private String tarjetaCredito;

	public Cliente(String nombre, String apellidos, String DNI, String email, String password, String telefono, String tarjetaCredito) {
		this.nombre = nombre; 
		this.apellidos = apellidos;
		this.DNI = DNI; 
		this.email = email; 
		this.password = password; 
		this.telefono = telefono;
		this.tarjetaCredito = tarjetaCredito;
	}
	
	public Cliente(Row record) {
		this(record.getString("clientes.nombre"), record.getString("clientes.apellidos"),
				record.getString("clientes.DNI"), record.getString("clientes.email"), record.getString("clientes.password"),
				record.getString("clientes.telefono"), record.getString("clientes.tarjetaCredito"));
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getTelefono() {
		return telefono;
	}


	public String getTarjetaCredito() {
		return tarjetaCredito;
	}
	
	
}
