package Controlador;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Clases.Abono;
import Clases.AbonoView;
import Clases.Actividad;
import Clases.ActividadHorarioView;
import Clases.ActividadView;
import Clases.Deporte;
import Clases.DeporteView;
import Clases.Empleado;
import Clases.EmpleadoView;
import Clases.Horario;
import Clases.Inscripcion;
import Clases.PCompleto;
import Clases.PCompletoView;
import Clases.PParticular;
import Clases.PParticularView;
import Clases.Socio;
import Clases.Sueldo;
import Dao.AbonoDao;
import Dao.ActividadDao;
import Dao.DeporteDao;
import Dao.EmpleadoDao;
import Dao.InscripcionDao;
import Dao.ProfesorDao;
import Dao.SocioDao;
import Clases.SocioView;
import Excepciones.AbonoException;
import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Excepciones.DeporteException;
import Excepciones.EmpleadoException;
import Excepciones.HorarioException;
import Excepciones.InscripcionException;
import Excepciones.ProfesorException;
import Excepciones.SocioException;
 
public class ControladoraABM {
    private static ControladoraABM instancia;
   
    public ControladoraABM() {
    }
   
    public static ControladoraABM getInstance(){
        if (instancia == null)
            instancia = new ControladoraABM();
        return instancia;
    }
    
    //SOCIOS
    public void altaSocio(String nombre, String dni, String email, String domicilio, String telefono) throws SocioException, ConnectionException {
        Socio ns = new Socio(nombre,dni,email,domicilio,telefono);
        ns.save();
    }
 
   
    public void modificarSocio(String dni, String nombre,String email, String domicilio, String telefono) throws SocioException, ConnectionException {
        Socio so = buscarSocio(dni);
        so.setNombre(nombre);
        so.setEmail(email);
        so.setDomicilio(domicilio);
        so.setTelefono(telefono);
        so.update();
 
    }
    public void bajaLogicaSocio(String dni) throws SocioException, ConnectionException {
        Socio so = buscarSocio(dni);
        so.delete();
      
    }
    private Socio buscarSocio(String dni) throws SocioException, ConnectionException {
        return SocioDao.getInstance().findByDNI(dni);
    }
    public void registrarAptoSocio(String dni, LocalDate fecha, String nombreProfesional, String observaciones, LocalDate vencimiento) throws SocioException, ConnectionException {
        
        Socio so = buscarSocio(dni);
     	so.registrarApto(fecha, nombreProfesional,observaciones,vencimiento);
     
    }
    
    //EMPLEADOS
   
    public void altaEmpleado(String nombre,String DNI, String Domicilio, String Telefono, String Mail, String Puesto, double sueldo,double retenciones,double deducciones) throws EmpleadoException, ConnectionException {
        Empleado e = new Empleado(nombre,DNI,Domicilio,Telefono,Mail,Puesto,sueldo,retenciones,deducciones);
        e.save();
    }
 
   
    public void modificarEmpleado(String DNI, String nombre, String Domicilio, String Telefono, String Mail, String Puesto, double sueldo, double retenciones, double deducciones) throws EmpleadoException, ConnectionException
    {
            Empleado E= buscarEmpleado(DNI);
            E.setDomicilio(Domicilio);
            E.setMail(Mail);
            E.setPuesto(Puesto);
            E.setSueldo(sueldo);
            E.setTelefono(Telefono);
            E.setNombre(nombre);
            E.setRetenciones(retenciones);
            E.setDeducciones(deducciones);
            E.update();
       
    }
    public void bajaLogicaEmpleado(String DNI) throws EmpleadoException, ConnectionException
    {
        Empleado E=buscarEmpleado(DNI);
        E.delete();
    }
    private Empleado buscarEmpleado(String DNI) throws EmpleadoException, ConnectionException {
        return EmpleadoDao.getInstance().findByDNI(DNI);
    }
    
    //PROFESORES
    
    private PCompleto buscarProfesorC(String dni) throws ConnectionException, ProfesorException {
    	return ProfesorDao.getInstance().findByDNICompleto(dni);
    }
    private PParticular buscarProfesorP(String dni) throws ConnectionException, ProfesorException {
    	return ProfesorDao.getInstance().findByDNIParticular(dni);
    }
    private boolean existeProfesor(String DNI) throws ProfesorException, ConnectionException{
  	  return ProfesorDao.getInstance().existeProfesor(DNI);
    }

    public void altaProfesorC(String nombre,String DNI, String domicilio, String telefono, String mail, float sueldo, float retenciones, float deducciones) throws ProfesorException, ConnectionException
    {
        PCompleto pc = new PCompleto(nombre,DNI,domicilio,telefono, mail, sueldo, retenciones, deducciones);
        pc.save();
    }
    public void altaProfesorP(String nombre,String DNI, String Domicilio, String Telefono, String Mail, float precioHora) throws ProfesorException, ConnectionException
    {
       PParticular PP = new PParticular(nombre, DNI, Domicilio, Telefono, Mail, precioHora);
       PP.save();
    }
    public void modificarProfesorC(String DNI, String nombre, String Domicilio, String Telefono, String Mail, float sueldo, float retenciones, float deducciones) throws ProfesorException, ConnectionException
    {
        PCompleto P = buscarProfesorC(DNI);
        P.setNombre(nombre);
        P.setDomicilio(Domicilio);
        P.setTelefono(Telefono);
        P.setMail(Mail);
        P.setSueldo(sueldo);
        P.setRetenciones(retenciones);
        P.setDeducciones(deducciones);
        P.update();

    }
    public void modificarProfesorP(String DNI, String nombre, String Domicilio, String Telefono, String Mail, float valorHora) throws ProfesorException, ConnectionException
    {
        PParticular P = buscarProfesorP(DNI);
        if (P!=null) {
        P.setNombre(nombre);
        P.setDomicilio(Domicilio);
        P.setTelefono(Telefono);
        P.setMail(Mail);
        P.setvalorHora(valorHora);
        P.update();
        }
        
    }
    public void bajaLogicaProfesorC(String DNI) throws ProfesorException, ConnectionException
    {
        PCompleto P=buscarProfesorC(DNI);
        P.delete();
    }
    
    public void bajaLogicaProfesorP(String DNI) throws ProfesorException, ConnectionException
    {
        PParticular P=buscarProfesorP(DNI);
        P.delete();
    }
    
    //ABONOS
    
    public void altaAbono(String nombre) throws ConnectionException, AbonoException {
        Abono ab = new Abono(nombre);
        ab.save();   
    }
    public void bajaLogicaAbono(int codigo) throws AbonoException, ConnectionException {
        Abono ab = buscarAbono(codigo);
        ab.delete();
       
    }
    private Abono buscarAbono(int codigo) throws AbonoException, ConnectionException {
        return AbonoDao.getInstance().findByID(codigo);
    }
    public void cargarActividadAbono(int codigoAbo, int codigoAct, String horaInicio, String horaFin, String dia) throws ActividadException, HorarioException, AbonoException, ConnectionException
    {
        Actividad AC = buscarActividad(codigoAct);
        Horario H = AC.devolverHorario(horaInicio, horaFin, dia);
        Abono A= buscarAbono(codigoAbo);
        A.agregarActividad(AC, H);
    }
  
   //DEPORTES + ACTIVIDADES + HORARIOS
    
    public void altaDeporte(String titulo, String descripcion) throws ConnectionException, DeporteException
    {
        Deporte d = new Deporte(titulo, descripcion);
        d.save();
    }
    public void modificarDeporte(int codigo, String nombre, String descripcion) throws DeporteException, ConnectionException
    {
        Deporte d = buscarDeporte(codigo);
        d.setNombre(nombre);
        d.setDescripcion(descripcion);
        d.update();
    }
    private Deporte buscarDeporte(int codigo) throws DeporteException, ConnectionException
    {
        return DeporteDao.getInstance().findByID(codigo);
       
    }
   
    public void bajaLogicaDeporte(int codigo) throws DeporteException, ConnectionException
    {
        Deporte d = buscarDeporte(codigo);
        d.delete();
    }
   
    public void altaActividad(int codigoD, String nombre, float precioHora) throws DeporteException, ActividadException, ConnectionException
    {
        Deporte d = buscarDeporte(codigoD);
        Actividad a = new Actividad(nombre,precioHora);
        d.saveAct(a);
       
    }
 

    public void agregarHorario(int codigoA, String horaInicio, String horaFin, String dia) throws ActividadException, ConnectionException
    {
       Actividad A = buscarActividad(codigoA);
       A.agregarHorario(horaInicio, horaFin, dia);
    }
    public void agregarProfesor(String DNI, int codigoA) throws ProfesorException, DeporteException, ActividadException, ConnectionException
    {
        Actividad A = buscarActividad(codigoA);
        if(existeProfesor(DNI))
        {
        	A.agregarProfesor(DNI);
        }
        else
        	throw new ProfesorException("No existe el profesor");
    }
   
   
    public void quitarHorario(int codigoA, String horaInicio, String horaFin, String dia) throws ActividadException, HorarioException, ConnectionException
    {
       Actividad A = buscarActividad(codigoA);
       A.quitarHorario(horaInicio, horaFin, dia);
    }
    public Actividad buscarActividad(int codigo) throws ConnectionException, ActividadException
    {
 	   return ActividadDao.getInstance().findByID(codigo);
    }
    

    //INSCRIPCIONES
    
    public void abrirInscripcion(String dni) throws SocioException, InscripcionException, ConnectionException {
        Socio so = buscarSocio(dni);
        if(ExisteInscripcionconSocio(dni))
        {
            throw new InscripcionException("El socio ya posee una inscripcion");
        }
        else
        {
            Inscripcion I = new Inscripcion(so);
            I.save();
        }      
    }
    public void cerrarInscripcion(int codigo) throws InscripcionException, ConnectionException, SocioException{
        Inscripcion I = buscarInscripcion(codigo);
        I.delete();
    }
    private boolean ExisteInscripcionconSocio(String dni) throws ConnectionException, InscripcionException {
       
        return InscripcionDao.getInstance().ExisteInscripcionconSocio(dni);
    }
    
    public void cargarActividadInscripcion(int codigoIns, int codigoAct, String horaInicio, String horaFin, String dia) throws ActividadException, HorarioException, InscripcionException, ConnectionException, SocioException
    {
 
        Inscripcion I = buscarInscripcion(codigoIns);
        Actividad AC = buscarActividad(codigoAct);
        Horario H = AC.devolverHorario(horaInicio, horaFin, dia);
        I.agregarActividad(AC, H);
    }
 
    public double calcularPrecio(int codigoIns) throws InscripcionException, ConnectionException, SocioException
    {
    	Inscripcion i = buscarInscripcion(codigoIns);
    	i.conseguirActividades();
    	i.conseguirAbono();
    	return i.calcularprecio();
    }
    
    private Inscripcion buscarInscripcion(int codigo) throws InscripcionException, ConnectionException, SocioException{
        return InscripcionDao.getInstance().findByID(codigo);
    }
    private Inscripcion buscarInscripcionSocio(Socio s) throws InscripcionException, ConnectionException
    {
    	return InscripcionDao.getInstance().findBySocio(s);
    }
   
    public void cargarAbonoInscripcion(int codigoIns, int codigoAbo) throws InscripcionException, ConnectionException, DeporteException, AbonoException, SocioException{
        Inscripcion i = buscarInscripcion(codigoIns);
        Abono A = buscarAbono(codigoAbo);
        i.cargarAbono(A);
    }
    
    //FUNCIONES DEL SISTEMA
    
    public double liquidarSueldosEmpleados(int mes, int ano) throws EmpleadoException, ConnectionException, SocioException
    {
        List<Empleado> lista;
        lista = EmpleadoDao.getInstance().findAll();
        double total=0;
        for (int i=0; i< lista.size();i++)
        {
            Sueldo s = new Sueldo(mes,ano,lista.get(i),lista.get(i).liquidarSueldo());
            total = total + s.getSueldoNeto();
            s.save();
        }
        return total;
        }
    
    public boolean validarIngreso(String dni) throws ConnectionException
    {
		try {
		Socio c = buscarSocio(dni);
		boolean apto = c.aptoAldia();
		if(!apto)
			return false;		
		Inscripcion i = buscarInscripcionSocio(c);
		i.conseguirAbono();
		i.conseguirActividades();
		boolean ins = i.actividadEnHorario();
		if(!ins)
			return false;
		return true;
		} catch (SocioException | InscripcionException e) {
			return false;
		}
		
    }
    
    public void envioMailActividad(String actividad, String mensaje) throws ConnectionException, ActividadException, InscripcionException, SocioException
    {
		actividad =actividad.replaceAll(";", " ");
		String[] aux = actividad.split(" ");
		int codigo = Integer.valueOf(aux[1]);
		Actividad a = buscarActividad(codigo);
		Set<Inscripcion> inscripciones = new HashSet<Inscripcion>();
		inscripciones = InscripcionDao.getInstance().findByActividad(a);
		for(Inscripcion i : inscripciones)
		{
			i.enviarMail(mensaje);
		}

    }
    

	public void envioMasivo(String mensaje) throws SocioException, ConnectionException {
		List<Socio> socios = new ArrayList<Socio>();
		socios = SocioDao.getInstance().findAll();
		for(Socio s : socios)
		{
			s.enviarMail(mensaje);
		}
	}
    
    
    
    
    
    
    //VIEWS
    

    public PCompletoView devolverProfesorCompleto(String dni) throws ProfesorException, ConnectionException{
         PCompleto P = buscarProfesorC(dni);
        return P.getView();
    }
    public PParticularView devolverProfesorParticular(String dni) throws ProfesorException, ConnectionException{
        PParticular P = buscarProfesorP(dni);
        return P.getView();
    }
    public SocioView devolverSocio(String dni) throws SocioException, ConnectionException {
        Socio c = buscarSocio(dni);
        return c.getView();
    }
    
    public EmpleadoView devolverEmpleado(String dni) throws EmpleadoException, ConnectionException {
        Empleado e = buscarEmpleado(dni);
        return e.getView();
    }
    public DeporteView devolverDeporte(int codigo) throws DeporteException, ConnectionException {
        Deporte d = buscarDeporte(codigo);
        return d.getView();
    }
     public AbonoView devolverAbono(int codigo) throws AbonoException, ConnectionException, ActividadException {
          Abono a = buscarAbono(codigo);
          a.conseguirActividades();
          return a.getView();
         }
     
     public List<ActividadHorarioView> devolverActividadesDia(String dia) throws ActividadException, ConnectionException
     {
		List<ActividadHorarioView> resultado = new ArrayList<ActividadHorarioView>();
		resultado = ActividadDao.getInstance().findByDia(dia);
    	return resultado;
     }

	public List<ActividadView> obtenerActividades() throws ActividadException, ConnectionException {
		List<Actividad> actividades = ActividadDao.getInstance().findAll();
		List<ActividadView> resultado = new ArrayList<ActividadView>();
		for(Actividad i : actividades)
		{
			resultado.add(i.getView());
		}
		return resultado;

	}


     
   
 
     
     
     
     
     
     
}