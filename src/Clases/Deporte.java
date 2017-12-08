package Clases;
import java.util.Vector;

import Dao.ActividadDao;
import Dao.DeporteDao;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.DeporteException;

public class Deporte {
	private int codigo;
	private String nombre;
	private String descripcion;
	private boolean activo;
	private Vector<Actividad> actividades;
	public Deporte(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = true;
		actividades = new Vector<Actividad>();
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
		if(this.activo==false)
		{
			for(int i=0;i<=actividades.size();i++)
			{
				actividades.elementAt(i).setActivo(false);
			}
		}
	}
	public Vector<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(Vector<Actividad> actividades) {
		this.actividades = actividades;
	}
	public boolean sosElDeporte(int codigo) {		
		return codigo==this.codigo;
	}
	public DeporteView getView() {
		DeporteView v = new DeporteView(codigo ,nombre ,descripcion);
		return v;
	}

	public boolean existeActividad(int codigo) {
		for(Actividad A : actividades) {
			if(A.getCodigo()==codigo) 
				return true;			
		}
		return false;	
	}
	private Actividad buscarActividad(int codigo) throws ActividadException {
		for(Actividad A : actividades)
		{
			if(A.sosLaActividad(codigo))
			{
				return A;
			}
		}
		throw new ActividadException("No existe la actividad");
	}
	public boolean tieneLaActividad(int codigoA) throws ActividadException 
	{
		Actividad A= buscarActividad(codigoA);
		if(A!=null && A.isActivo()==true)
			return true;
		else
			return false;
		
	}
	public void agregarProfesor(Profesor P, int codigoA) throws ActividadException 
	{
		for(Actividad A : actividades) {
			if(A.getCodigo()==codigoA) 
				A.setProfesor(P);
		}
		

		
	}

	public Actividad devolverActividad(int codigoAct) throws ActividadException {
		Actividad A = buscarActividad(codigoAct);
		return A;			
	}
	public void bajaActividad(int codigo) throws ActividadException {
		Actividad A= buscarActividad(codigo);		
		if(A!=null)
		{
			for(int i=0;i<=actividades.size();i++)
			{
				if(A.getCodigo()==actividades.elementAt(i).getCodigo())
					actividades.elementAt(i).setActivo(false);
			}
			
		}
	}
	public void save() throws ConnectionException, DeporteException {
		DeporteDao.getInstance().save(this);
		
	}
	public void update() throws ConnectionException, DeporteException {
		DeporteDao.getInstance().update(this);
		
	}
	public void delete() throws ConnectionException, DeporteException {
		DeporteDao.getInstance().delete(this);
		
	}
	public void saveAct(Actividad a) throws ConnectionException, ActividadException {
		ActividadDao.getInstance().save(this,a);
		
	}
	
	
}
