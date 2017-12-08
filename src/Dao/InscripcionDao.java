package Dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Clases.Abono;
import Clases.Actividad;
import Clases.Horario;
import Clases.Inscripcion;
import Clases.ItemActividadHorario;
import Clases.Socio;
import Excepciones.ConnectionException;
import Excepciones.InscripcionException;
import Excepciones.SocioException;

public class InscripcionDao {
	private static InscripcionDao instancia;
	
	private InscripcionDao(){
	}
	
	public static InscripcionDao getInstance(){
		if (instancia==null)
			instancia = new InscripcionDao();
		return instancia;
	}
	
	public Inscripcion findByID(int codigo) throws ConnectionException, InscripcionException, SocioException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Inscripcion inscripcion= null;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Inscripciones where codigo = "+codigo);
			if(rs.next())
			{
				Socio s = SocioDao.getInstance().findByDNI(rs.getString("dni"));
				inscripcion = new Inscripcion(s);
				inscripcion.setCodigo(rs.getInt("codigo"));
				inscripcion.setVencimiento(rs.getDate("vencimiento").toLocalDate());
				inscripcion.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new InscripcionException("Error al recuperar la inscripcion");
			if(!inscripcion.isActivo())
				throw new InscripcionException("La inscripcion esta inactiva");
			return inscripcion;
		}
		catch(SQLException e){
			throw new InscripcionException("Error al recuperar la inscripcion");
		}

	}
	
/*	public List<Socio> findAll() throws SocioException, ConnectionException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<Socio> resultado = new ArrayList<Socio>();
		Socio socio ;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Socios");
			rs.next();
			while (!rs.isLast()){
				socio = new Socio(rs.getString("nombre"),rs.getString("DNI"), rs.getString("email"),rs.getString("domicilio"), rs.getString("telefono"));
				socio.setActivo(rs.getBoolean("activo"));
				if(socio.isActivo())
					resultado.add(socio);
				rs.next();
			}			
		}
		catch(Exception e){
			throw new SocioException("Error al recuperar el socio");
		}
		return resultado;
	}
	*/
	public void save(Inscripcion inscripcion) throws ConnectionException, InscripcionException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Inscripciones (dni, vencimiento, activo) VALUES(?,?,1)");
		pstmt.setString(1, inscripcion.getSocio().getDNI());
		pstmt.setDate(2, Date.valueOf(inscripcion.getVencimiento()));
		pstmt.execute();
		} catch (SQLException e) {
			throw new InscripcionException("Error");
		}
	}
	
	public void delete (Inscripcion inscripcion) throws ConnectionException, InscripcionException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Inscripciones set activo=0 where codigo=?");
			pstmt.setInt(1, inscripcion.getCodigo());
			pstmt.execute();
		} catch (SQLException e) {
			throw new InscripcionException("Error");
	}
	
	}
	
	/*
	 public void update (Deporte deporte) throws ConnectionException, DeporteException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Deportes set nombre=?, descripcion=? where codigo=?");
			pstmt.setString(1, deporte.getNombre());
			pstmt.setString(2, deporte.getDescripcion());
		} catch (SQLException e) {
			throw new DeporteException("Error en deporte");
		}

	}
*/
	public boolean ExisteInscripcionconSocio(String dni) throws ConnectionException, InscripcionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
			Statement stm;
			try {
			stm = con.createStatement();			 
			ResultSet rs = stm.executeQuery("select * from Inscripciones where dni= "+dni);
			if(rs.next())
			{
				return true;
			}
			else
				return false;
			}catch (SQLException e) {
				throw new InscripcionException("Error en inscripcion");
			}

			
	}

	public void cargarAbono(Inscripcion inscripcion, Abono a) throws InscripcionException, ConnectionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("Update Inscripciones set codigoabono=? where codigo=? ");	 
		pstmt.setInt(1, a.getCodigo());
		pstmt.setInt(2, inscripcion.getCodigo());
		pstmt.execute();

		}
		catch (SQLException e) {
			throw new InscripcionException("Error en inscripcion");
		}
	}

	public void agregarActividad(Inscripcion inscripcion, Actividad aC, Horario horario) throws  InscripcionException, ConnectionException {
			Connection con = AdminConexion.getInstance().obtenerConexion();
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement("Insert into ActHorInscripcion VALUES (?,?,?,?,?)");
				pstmt.setInt(1, inscripcion.getCodigo());
				pstmt.setInt(2, aC.getCodigo());
				pstmt.setString(3, horario.getHoraInicio());
				pstmt.setString(4, horario.getHoraFin());
				pstmt.setString(5, horario.getDia());
				pstmt.execute();
			} catch (SQLException e) {
				throw new InscripcionException("Error al agregar la actividad a la Inscripcion");
			}
			
	}
		
	public Inscripcion conseguirActividades(Inscripcion inscripcion) throws ConnectionException, InscripcionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		List<ItemActividadHorario> actividades = new ArrayList<ItemActividadHorario>();
		try{
			pstmt = con.prepareStatement("select * from ActHorInscripcion where codigoIns =?");
			pstmt.setInt(1,inscripcion.getCodigo());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			while(rs.getRow()!=0)
			{
				
				boolean aux = false;
				for (ItemActividadHorario e : actividades) {
				    if(e.getActividad().getCodigo()==rs.getInt("codigoact"))
				    {
				    	Horario h = new Horario(rs.getString("horainicio"),rs.getString("horafin"),rs.getString("dia"));
				    	e.agregarHorario(h);
				    	aux=true;
				    	break;
				    }
				}
				if(aux==false)
				{
					Actividad a = ActividadDao.getInstance().findByID(rs.getInt("codigoact"));
					Horario hor = new Horario(rs.getString("horainicio"),rs.getString("horafin"),rs.getString("dia"));
					ItemActividadHorario iah= new ItemActividadHorario(a, hor);
					actividades.add(iah);
				}				
				rs.next();
			}
			inscripcion.setActividades(actividades);			
			return inscripcion;
			
			
		}
		catch(Exception e){
			throw new InscripcionException("Error recuperar las actividades");
		
		
		}
	}
	
	public Inscripcion conseguirAbono(Inscripcion inscripcion) throws ConnectionException, InscripcionException
	{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement("select * from Inscripciones where codigo =?");
			pstmt.setInt(1,inscripcion.getCodigo());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if(AbonoDao.getInstance().ExisteAbono(rs.getInt("codigoabono"))){
				Abono a = AbonoDao.getInstance().findByID(rs.getInt("codigoabono"));
				a.conseguirActividades();
				inscripcion.setAbono(a);
				return inscripcion;	
			}
			return inscripcion;
		}
		catch(Exception e){
			throw new InscripcionException("Error en la Inscripcion");
		
		}
	}

	public Inscripcion findBySocio(Socio s) throws InscripcionException, ConnectionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Inscripcion inscripcion= null;
		try{
			PreparedStatement pstmt = con.prepareStatement("select * from Inscripciones where dni=?");
			pstmt.setString(1, s.getDNI());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{				
				inscripcion = new Inscripcion(s);
				inscripcion.setCodigo(rs.getInt("codigo"));
				inscripcion.setVencimiento(rs.getDate("vencimiento").toLocalDate());
				inscripcion.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new InscripcionException("Error al recuperar la inscripcion");
			if(!inscripcion.isActivo())
				throw new InscripcionException("La inscripcion esta inactiva");
			return inscripcion;
		}
		
		catch(Exception e){
			throw new InscripcionException("Error al recuperar la inscripcion");
		}
		
	}

	public Set<Inscripcion> findByActividad(Actividad a) throws InscripcionException, ConnectionException, SocioException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Set<Inscripcion> resultado = new HashSet<Inscripcion>();
		Inscripcion i;
		try {
		PreparedStatement pstmt = con.prepareStatement("select * from ActHorInscripcion where codigoAct=?");
		pstmt.setInt(1, a.getCodigo());
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		while(rs.getRow()!=0)
		{
			PreparedStatement pstmt2 = con.prepareStatement("select * from Inscripciones where codigo=?");
			pstmt.setInt(1, rs.getInt("codigoIns"));
			ResultSet rs2 = pstmt2.executeQuery();
			rs2.next();
			Socio s = SocioDao.getInstance().findByDNI(rs2.getString("dni"));
			i = new Inscripcion(s);
			i.setCodigo(rs2.getInt("codigo"));
			i.setActivo(rs2.getBoolean("activo"));
			if(i.isActivo())
				resultado.add(i);
			rs.next();
		}
		return resultado;
		} catch (SQLException e) {
			throw new InscripcionException("Error al recuperar la inscripcion");
		}
	}
	
}

	
	
	

