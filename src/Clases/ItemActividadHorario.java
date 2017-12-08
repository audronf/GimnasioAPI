package Clases;

import java.util.Calendar;
import java.util.Vector;

public class ItemActividadHorario {
	private Actividad actividad;
	private Vector<Horario>horarios;
	public ItemActividadHorario(Actividad actividad, Horario horario) {
		super();
		this.actividad = actividad;
		this.horarios = new Vector<Horario>();
		this.horarios.add(horario);
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	public Vector<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(Vector<Horario> horarios) {
		this.horarios = horarios;
	}

	public void agregarHorario(Horario h)
	{
		horarios.add(h);
	}
	public boolean enHorario() {
		Calendar c= Calendar.getInstance();
		int hoy=c.get(Calendar.DAY_OF_WEEK);
		String dia = "";
		if(hoy==1)
			dia="Domingo";
		if(hoy==2)
			dia="Lunes";
		if(hoy==3)
			dia="Martes";
		if(hoy==4)
			dia="Miercoles";
		if(hoy==5)
			dia="Jueves";
		if(hoy==6)
			dia="Viernes";
		if(hoy==7)
			dia="Sabado";
		for(Horario h : horarios)
		{
			if(h.getDia().equalsIgnoreCase(dia))
			{
				int hora= c.get(Calendar.HOUR_OF_DAY);
				int horaInicio= Integer.parseInt(h.getHoraInicio());
				if(horaInicio-hora==1 || horaInicio-hora==0 || horaInicio-hora==-1)
				{
					return true;
				}	
			}
		}
		return false;
	}
	
	
	
	
	
	
	
}

