package Clases;

public class PParticularView {
	private String nombre;
	private String DNI;
	private String domicilio;
	private String telefono;
	private String mail;
	private String valorHora;
	
	public PParticularView(String nombre, String dNI, String domicilio, String telefono, String mail, float sueldo) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.valorHora = Float.toString(sueldo);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSueldo() {
		return valorHora;
	}
	public void setSueldo(float sueldo) {
		this.valorHora = Float.toString(sueldo);
	}
	
	
}