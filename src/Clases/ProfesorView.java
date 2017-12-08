package Clases;

public class ProfesorView {
	private String nombre;
	private String DNI;
	private String domicilio;
	private String telefono;
	private String mail;
	
	public ProfesorView(String nombre, String dNI, String domicilio, String telefono, String mail) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDNI() {
		return DNI;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getMail() {
		return mail;
	}
	
}
