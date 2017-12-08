package Clases;

public class PCompletoView {
	private String nombre;
	private String DNI;
	private String domicilio;
	private String telefono;
	private String mail;
	private String sueldo;
	private String retenciones;
	private String deducciones;
	public PCompletoView(String nombre, String dNI, String domicilio, String telefono, String mail, float sueldo,
			float retenciones, float deducciones) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.sueldo = Float.toString(sueldo);
		this.retenciones = Float.toString(retenciones);
		this.deducciones = Float.toString(deducciones);
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
	public String getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = Float.toString(sueldo);
	}
	public String getRetenciones() {
		return retenciones;
	}
	public void setRetenciones(float retenciones) {
		this.retenciones = Float.toString(retenciones);
	}
	public String getDeducciones() {
		return deducciones;
	}
	public void setDeducciones(float deducciones) {
		this.deducciones = Float.toString(deducciones);
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}