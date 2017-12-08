package Clases;

public abstract class Profesor {
	protected String nombre;
	protected String DNI;
	protected String domicilio;
	protected String telefono;
	protected String mail;
	protected boolean activo;
	public Profesor(String nombre, String dNI, String domicilio, String telefono, String mail) {
		super();
		this.nombre = nombre;
		this.DNI = dNI;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		activo = true;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public boolean sosElProfesor(String DNI) {
		return DNI.equals(this.DNI);
	}

	 

}
