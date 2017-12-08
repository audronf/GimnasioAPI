package Clases;
import java.util.Vector;

import Dao.ActividadDao;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.HorarioException;

public class Actividad {
	private int codigo;
	private String nombre;
	private Vector<Horario> horarios;
	private float precioHora;
	private Profesor profesor;
	private boolean activo;
	public Actividad(String nombre, float precioHora) {
		super();
		this.nombre = nombre;
		horarios = new Vector<Horario>();
		this.precioHora = precioHora;
		this.activo = true;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Vector<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(Vector<Horario> horarios) {
		this.horarios = horarios;
	}
	public float getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public ActividadView getView() {
		ActividadView v = new ActividadView(codigo, nombre, precioHora);
		return v;
	}
	public boolean sosLaActividad(int codigo) {
		return codigo==this.codigo;
	}
	public void agregarHorario(String horaInicio, String horaFin, String dia) throws ConnectionException, ActividadException {
		ActividadDao.getInstance().agregarHorario(this, horaInicio, horaFin, dia);
		
	}

	public void quitarHorario(String horaInicio, String horaFin, String dia) throws HorarioException, ConnectionException, ActividadException {
		ActividadDao.getInstance().quitarHorario(this, horaInicio, horaFin, dia);
		
	}
	public Horario devolverHorario(String horaInicio, String horaFin, String dia) throws HorarioException, ActividadException, ConnectionException {
		Horario A = ActividadDao.getInstance().buscarHorario(this, horaInicio, horaFin, dia);
		return A;

	}
	public void agregarProfesor(String DNI) throws ConnectionException, ActividadException {
		ActividadDao.getInstance().agregarProfesor(this, DNI);
		
	}
}
