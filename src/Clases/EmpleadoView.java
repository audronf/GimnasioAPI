package Clases;

public class EmpleadoView {
	private String nombre;
	private String DNI;
	private String domicilio;
	private String telefono;
	private String mail;
	private double sueldo;
	private double retenciones;
	private double deducciones;
	private String puesto;
	public EmpleadoView(String nombre, String dNI, String domicilio, String telefono, String mail, double sueldo, double retenciones, double deducciones, String puesto
			) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.sueldo = sueldo;
		this.puesto = puesto;
		this.retenciones=retenciones;
		this.deducciones=deducciones;
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
	public double getSueldo() {
		return sueldo;
	}
	public String getPuesto() {
		return puesto;
	}
	public double getRetenciones() {
		return retenciones;
	}
	public void setRetenciones(double retenciones) {
		this.retenciones = retenciones;
	}
	public double getDeducciones() {
		return deducciones;
	}
	public void setDeducciones(double deducciones) {
		this.deducciones = deducciones;
	}
	
	
}
