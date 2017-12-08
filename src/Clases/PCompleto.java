package Clases;

import Dao.ProfesorDao;
import Excepciones.ConnectionException;
import Excepciones.ProfesorException;

public class PCompleto extends Profesor {
	private float sueldo;
	private float retenciones;
	private float deducciones;

	public PCompleto(String nombre, String dNI, String domicilio, String telefono, String mail, float sueldo, float retenciones, float deducciones) {
		super(nombre, dNI, domicilio, telefono, mail);
		this.sueldo = sueldo;
		this.retenciones = retenciones;
		this.deducciones = deducciones;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public float getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(float retenciones) {
		this.retenciones = retenciones;
	}
	public float getDeducciones() {
		return deducciones;
	}

	public void setDeducciones(float deducciones) {
		this.deducciones = deducciones;
	}



	public void save() throws ConnectionException, ProfesorException {
		ProfesorDao.getInstance().saveCompleto(this);
		
	}
	public void update() throws ConnectionException, ProfesorException
	{
		ProfesorDao.getInstance().UpdateCompleto(this);
	}

	public void delete() throws ConnectionException, ProfesorException {
		ProfesorDao.getInstance().DeleteCompleto(this);
		
	}
	public PCompletoView getView() {
		PCompletoView p = new PCompletoView( nombre,  DNI,  domicilio,  telefono,  mail,  sueldo, retenciones, deducciones);
		return p;
	}
}
