package Clases;
import java.time.LocalDate;

public class AptoMedico {
	private LocalDate fecha;
	private String nombreProfesional;
	private String observaciones;
	private LocalDate fechaVencimiento;
	public AptoMedico(LocalDate fecha, String nombreProfesional, String observaciones, LocalDate fechaVencimiento) {
		super();
		this.fecha = fecha;
		this.nombreProfesional = nombreProfesional;
		this.observaciones = observaciones;
		this.fechaVencimiento = fechaVencimiento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public String getNombreProfesional() {
		return nombreProfesional;
	}
	public void setNombreProfesional(String nombreProfesional) {
		this.nombreProfesional = nombreProfesional;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
}
