package Clases;
import java.util.ArrayList;
import java.util.List;
import Dao.AbonoDao;
import Excepciones.AbonoException;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;

public class Abono {
	private int codigo;
	private String nombre;
	private List<ItemActividadHorario> actividades;
	private boolean activo;
	public Abono(String nombre) {
		super();
		this.nombre = nombre;
		actividades = new ArrayList<ItemActividadHorario>();
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
	public List<ItemActividadHorario> getActividades() {
		return actividades;
	}
	public void setActividades(List<ItemActividadHorario> actividades) {
		this.actividades = actividades;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public double calcularprecio() {
		int horas=0;
		double precio=0;
		for(ItemActividadHorario i : actividades)
		{
			horas=0;
			for(Horario h : i.getHorarios())
			{
				int horaParcial = (Integer.valueOf(h.getHoraFin())-Integer.valueOf(h.getHoraInicio()));
				if(horaParcial>0)
					horas+=horaParcial;
				else
					horas+=24-horaParcial;
				
			}
			precio+=horas*i.getActividad().getPrecioHora();
			
		}
		precio=precio*0.8;
		return precio;
		
		
	}
	public void agregarActividad(Actividad AC, Horario H) throws AbonoException, ConnectionException {
		AbonoDao.getInstance().agregarActividad(this, AC, H);
	}
	public AbonoView getView() {
		  AbonoView v = new AbonoView(codigo, nombre, actividades);
		  return v; 
		 }

	public void save() throws ConnectionException, AbonoException {
		AbonoDao.getInstance().save(this);
		
	}
	public void conseguirActividades() throws ConnectionException, ActividadException, AbonoException
	{
		AbonoDao.getInstance().conseguirActividades(this);
	}

	public boolean activadadEnHorario() {
		for(ItemActividadHorario i : actividades)
		{
			if(i.enHorario())
				return true;
		}
		return false;
	}

	public void delete() throws ConnectionException, AbonoException {
		AbonoDao.getInstance().delete(this);
		
	}


}

