package Clases;

public class SocioView {
	private String  nombre;
	private String  DNIi;
	private String  email;
	private String  domicilio;
	private String telefono;
	public SocioView(String nombre, String dNIi, String email, String domicilio, String telefono) {
		super();
		this.nombre = nombre;
		DNIi = dNIi;
		this.email = email;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDNIi() {
		return DNIi;
	}
	public String getEmail() {
		return email;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	
}
