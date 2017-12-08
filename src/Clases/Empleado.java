package Clases;

import java.util.List;

import Dao.EmpleadoDao;
import Excepciones.ConnectionException;
import Excepciones.EmpleadoException;

public class Empleado {
	private String nombre;
	private String DNI;
	private String domicilio;
	private String telefono;
	private String mail;
	private double sueldo;
	private double retenciones;
	private double deducciones;
	private String puesto;
	private boolean activo;
	public Empleado(String nombre, String DNI, String domicilio, String telefono, String mail, String puesto, double sueldo, double retenciones, double deducciones
			) {
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.sueldo = sueldo;
		this.puesto = puesto;
		this.retenciones = retenciones;
		this.deducciones = deducciones;
		this.activo = true;
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
	public double getSueldo() {
		return sueldo;
	}
	public double getRetenciones() {
		return retenciones;
	}
	public double getDeducciones() {
		return deducciones;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setRetenciones(double retenciones) {
		this.retenciones = retenciones;
	}
	public void setDeducciones(double deducciones) {
		this.deducciones = deducciones;
	}
	public boolean sosElEmpleado(String DNI) {
		return DNI.equalsIgnoreCase(this.DNI);

	}
	public EmpleadoView getView() {
		EmpleadoView v = new EmpleadoView(nombre, DNI, domicilio, telefono, mail, sueldo, retenciones, deducciones, puesto);
		return v;
	}
	public List<Empleado> findall() throws EmpleadoException, ConnectionException {
		return EmpleadoDao.getInstance().findAll();
	}
	public double liquidarSueldo()
	{
		return sueldo - retenciones - deducciones;
	}
	public void save() throws ConnectionException, EmpleadoException {
		EmpleadoDao.getInstance().save(this);
		}

	public void update() throws ConnectionException, EmpleadoException {
		EmpleadoDao.getInstance().update(this);
	}

	public void delete() throws ConnectionException, EmpleadoException {
		EmpleadoDao.getInstance().delete(this);
		
	}

}
