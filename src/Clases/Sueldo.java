package Clases;

import Clases.Empleado;
import Dao.SueldoDao;
import Excepciones.ConnectionException;
import Excepciones.SocioException;

public class Sueldo 
{
	private int mes;
	private int ano;
	private Empleado empleado;
	private double sueldoNeto;
	
	public Sueldo(int mes, int ano, Empleado empleado, double sueldo) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.empleado = empleado;
		this.sueldoNeto = sueldo;
	}

	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public double getSueldoNeto() {
		return sueldoNeto;
	}

	public void save() throws ConnectionException, SocioException {
		SueldoDao.getInstance().save(this);
		
	}
}
