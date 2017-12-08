package Clases;

public class Horario {
	private String horaInicio;
	private String horaFin;
	private String dia;
	public Horario(String horaInicio, String horaFin, String dia) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public boolean sosElHorario(String horaInicio, String horaFin, String dia) {
		return horaInicio.equals(this.horaInicio) && horaFin.equals(this.horaFin) && dia.equals(this.dia);
		
	}
}
