package Clases;

import Dao.ProfesorDao;
import Excepciones.ConnectionException;
import Excepciones.ProfesorException;

public class PParticular extends Profesor {
	private float valorHora;

	public PParticular(String nombre, String dNI, String domicilio, String telefono, String mail, float valorHora) {
		super(nombre, dNI, domicilio, telefono, mail);
		this.valorHora = valorHora;
	}

	public float getvalorHora() {
		return valorHora;
	}

	public void setvalorHora(float valorHora) {
		this.valorHora = valorHora;
	}
	public void modificarProfesor(String nombre, String DNI, String domicilio, String telefono, float valorHora) 
	{
		this.nombre=nombre;
		this.DNI=DNI;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.valorHora=valorHora;
		
	}

	public void save() throws ConnectionException, ProfesorException {
		ProfesorDao.getInstance().saveParticular(this);
		
	}

	public void update() throws ConnectionException, ProfesorException {
		ProfesorDao.getInstance().UpdateParticular(this);
		
	}
	public void delete() throws ConnectionException, ProfesorException {
		ProfesorDao.getInstance().DeleteParticular(this);
		
	}
	public PParticularView getView() {
		PParticularView p = new PParticularView( nombre,  DNI,  domicilio,  telefono,  mail,  valorHora);
		return p;
	}
}
