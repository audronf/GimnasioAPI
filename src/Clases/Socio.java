package Clases;
import java.time.LocalDate;
import java.util.Vector;

import Dao.SocioDao;
import Excepciones.ConnectionException;
import Excepciones.SocioException;

public class Socio {
	private String nombre;
	private String DNI;
	private String email;
	private String domicilio;
	private String telefono;
	private boolean activo; 
	private Vector<AptoMedico> aptosMedicos;
	public Socio(String nombre, String dNI, String email, String domicilio, String telefono) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.email = email;
		this.domicilio = domicilio;
		this.telefono = telefono;
		aptosMedicos = new Vector<AptoMedico>();
		this.activo=true;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Vector<AptoMedico> getAptosMedicos() {
		return aptosMedicos;
	}
	public void setAptosMedicos(Vector<AptoMedico> aptosMedicos) {
		this.aptosMedicos = aptosMedicos;
	}
	public boolean sosElSocio(String dni2) {
		return dni2==this.DNI;
	}
	public void registrarApto(LocalDate fecha, String nombreProfesional, String observaciones, LocalDate vencimiento) throws ConnectionException, SocioException {
		SocioDao.getInstance().agregarApto(this, fecha, nombreProfesional, vencimiento, observaciones);
		
	}
	public boolean aptoAldia() throws SocioException, ConnectionException
	{
		return SocioDao.getInstance().aptoAlDia(this);
	}
	public SocioView getView() {
		SocioView v = new SocioView(nombre,DNI,email,domicilio,telefono);
		return v;
	}
	public void save() throws ConnectionException, SocioException {
		SocioDao.getInstance().save(this);
		}
	public void update() throws ConnectionException, SocioException {
		SocioDao.getInstance().update(this);
	}

	public void delete() throws ConnectionException, SocioException {
		SocioDao.getInstance().delete(this);
		
	}

	public void enviarMail(String mensaje) {
		//Aca iría del codigo de mandar mails si supiera hacerlo
		
	}

		
}
