package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Dao.InscripcionDao;
import Excepciones.ConnectionException;
import Excepciones.InscripcionException;

public class Inscripcion {
	private int codigo;
	private Socio socio;
	private List<ItemActividadHorario> actividades;
	private LocalDate vencimiento;
	private Abono abono;
	private boolean activo;
	public Inscripcion(Socio socio) {
		super();
		this.socio = socio;
		this.activo = true;
		actividades = new ArrayList<ItemActividadHorario>();
		vencimiento =LocalDate.now().plusMonths(1);
	}
	
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Socio getSocio() {
		return socio;
	}


	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public List<ItemActividadHorario> getActividades() {
		return actividades;
	}


	public void setActividades(List<ItemActividadHorario> actividades) {
		this.actividades = actividades;
	}


	public LocalDate getVencimiento() {
		return vencimiento;
	}


	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}


	public Abono getAbono() {
		return abono;
	}


	public void setAbono(Abono abono) {
		this.abono = abono;
	}

	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
   @Override
   public int hashCode() {
      return this.codigo;
   }
   @Override
   public boolean equals(Object ins) {
      if (this == ins)
         return true;
      if (ins == null)
         return false;
      if (this.getClass() != ins.getClass())
         return false;
      Inscripcion aux = (Inscripcion) ins;
      if (codigo != aux.getCodigo())
         return false;
      return true;
   }
	public void agregarActividad(Actividad AC, Horario H) throws InscripcionException, ConnectionException {
		InscripcionDao.getInstance().agregarActividad(this, AC, H);
		
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
		precio+=abono.calcularprecio();
		return precio;
		
			
		}

	public void conseguirAbono() throws ConnectionException, InscripcionException
	{
		InscripcionDao.getInstance().conseguirAbono(this);
	}
	public void conseguirActividades() throws ConnectionException, InscripcionException
	{
		InscripcionDao.getInstance().conseguirActividades(this);
	}

	public void save() throws ConnectionException, InscripcionException {
		InscripcionDao.getInstance().save(this);
		
	}


	public void delete() throws ConnectionException, InscripcionException {
		InscripcionDao.getInstance().delete(this);
		
	}


	public void cargarAbono(Abono a) throws InscripcionException, ConnectionException {
		InscripcionDao.getInstance().cargarAbono(this, a);
		
	}


	public boolean actividadEnHorario() {
		for(ItemActividadHorario i : actividades)
		{
			if(i.enHorario())
				return true;
		}
		if(abono.activadadEnHorario())
		{
			return true;
		}
		return false;
	}


	public void enviarMail(String mensaje) {
		this.socio.enviarMail(mensaje);
		
	}
}

