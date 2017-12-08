package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Excepciones.ActividadException;
import Excepciones.ConnectionException;
import Clases.Actividad;
import Clases.ActividadHorarioView;
import Clases.Deporte;
import Clases.Horario;

public class ActividadDao {
	private static ActividadDao instancia;
	
	private ActividadDao(){
	}
	
	public static ActividadDao getInstance(){
		if (instancia==null)
			instancia = new ActividadDao();
		return instancia;
	}
	
	public Actividad findByID(int codigo) throws ConnectionException, ActividadException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Actividad actividad= null;
		try{
			PreparedStatement pstmt = con.prepareStatement("select * from Actividades where codigo = ?");
			pstmt.setInt(1, codigo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				actividad = new Actividad(rs.getString("nombre"),rs.getFloat("preciohora"));
				actividad.setCodigo(rs.getInt("codigo"));
				actividad.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new ActividadException("Error al recuperar la actividad");
			if(!actividad.isActivo())
				throw new ActividadException("La actividad est� inactivo");
			return actividad;	
		}
		catch(SQLException e){
			throw new ActividadException("Error al recuperar la actividad");
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
	public void save(Deporte deporte, Actividad actividad) throws ConnectionException, ActividadException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		
		try {
		pstmt = con.prepareStatement("insert into Actividades (nombre,preciohora,activo) VALUES(?,?,1)");
		pstmt.setString(1, actividad.getNombre());
		pstmt.setFloat(2, actividad.getPrecioHora());
		pstmt.execute();
		} catch (SQLException e) {
					throw new ActividadException("Error al guardar actividad");
		}
		Statement stm1;
		Statement stm2;
		try {
		stm1 = con.createStatement();
		ResultSet rs = stm1.executeQuery("select * from Actividades");
		rs.next();
		int aux = 0;
		while(rs.getRow()!=0){
			aux++;
			rs.next();
		}
		stm2 = con.createStatement();
		ResultSet rs2 = stm2.executeQuery("select * from Actividades");
		aux=aux-1;
		rs2.next();
		while(aux!=0){
			rs2.next();
			aux=aux-1;
		}
		actividad.setCodigo(rs2.getInt("codigo"));
		} catch (SQLException e){
			throw new ActividadException("Error al recuperar la actividad");
		}
		PreparedStatement pstmt2;
		try {
			pstmt2 = con.prepareStatement("insert into DeporteActividad (codigoDep, codigoAct) VALUES(?,?)");
			pstmt2.setInt(2, actividad.getCodigo());
			pstmt2.setInt(1, deporte.getCodigo());
			pstmt2.execute();
			} catch (SQLException e){
				throw new ActividadException("Error al recuperar la actividad");	
			}
		
	}
	/*		try {
		pstmt2 = con.prepareStatement("insert into DeporteActividad (codigoDep,codigoAct) VALUES(?,?)");
		pstmt2.setString(1, actividad.getNombre());
		pstmt2.setFloat(2, actividad.getPrecioHora());
		pstmt2.executeQuery();
		} catch (SQLException e) {
					throw new ActividadException("Error al crear la actividad, probablemente ya exista (Eso espero, si no es as� entonces no tengo ni idea de por qu� sali� esta excepci y todo el sistema anda mal)");
		}*/
	public void delete (Actividad actividad) throws ConnectionException, ActividadException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Actividades set activo=0 where codigo=?");
			pstmt.setInt(1, actividad.getCodigo());
			pstmt.execute();
		} catch (SQLException e) {
			throw new ActividadException("Error al borrar actividad");
		}	
	
	}
	
	public void update (Actividad actividad) throws ConnectionException, ActividadException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Actividades set nombre=?, descripcion=? where codigo=?");
			pstmt.setString(1, actividad.getNombre());
			pstmt.setFloat(2, actividad.getPrecioHora());
			pstmt.setInt(3, actividad.getCodigo());
			pstmt.execute();
		} catch (SQLException e) {
			throw new ActividadException("Error al modificar actividad");
		}

	}

	public void agregarProfesor(Actividad actividad, String DNI) throws ConnectionException, ActividadException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement("Update Actividades set profesor=? where codigo=?");
			pstmt.setString(1, DNI);
			pstmt.setInt(2, actividad.getCodigo());
			pstmt.execute();
		} catch (SQLException e){
			throw new ActividadException("Error al agrgar el profesor a la actividad");
		
		}
	
	}
	public void agregarHorario(Actividad actividad ,String horaInicio, String horaFin, String dia) throws ConnectionException, ActividadException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement("Select * from Horarios where horainicio=? and horafin=? and dia=?");
			pstmt.setString(1, horaInicio);
			pstmt.setString(2, horaFin);
			pstmt.setString(3, dia);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				PreparedStatement pstmt2 = con.prepareStatement("Insert into HorarioActiv VALUES (?,?,?,?)");
				pstmt2.setInt(1, actividad.getCodigo());
				pstmt2.setString(2, horaInicio);
				pstmt2.setString(3, horaFin);
				pstmt2.setString(4, dia);
				pstmt2.execute();
			}	
			else
			{
				PreparedStatement pstmt3 = con.prepareStatement("Insert into Horarios VALUES (?,?,?)");
				pstmt3.setString(1, horaInicio);
				pstmt3.setString(2, horaFin);
				pstmt3.setString(3, dia);
				pstmt3.execute();
				PreparedStatement pstmt2 = con.prepareStatement("Insert into HorarioActiv VALUES (?,?,?,?)");
				pstmt2.setInt(1, actividad.getCodigo());
				pstmt2.setString(2, horaInicio);
				pstmt2.setString(3, horaFin);
				pstmt2.setString(4, dia);
				pstmt2.execute();
			}	
		} catch (SQLException e){
			throw new ActividadException("Error al agrgar el horario a la actividad");
		
		}
	
	}

	public void quitarHorario(Actividad actividad, String horaInicio, String horaFin, String dia) throws ConnectionException, ActividadException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement("Delete From HorarioActiv where codigoAct=? and horainicio=? and horafin = ? and dia=?");
			pstmt.setInt(1, actividad.getCodigo());
			pstmt.setString(2, horaInicio);
			pstmt.setString(3, horaFin);
			pstmt.setString(4, dia);
			pstmt.execute();
		} catch (SQLException e){
			throw new ActividadException("Error al borrar el horario");
		
		}
	
	}

	public Horario buscarHorario(Actividad actividad, String horaInicio, String horaFin, String dia) throws ActividadException, ConnectionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement("select * from HorarioActiv where codigoAct=? and horainicio=? and horaFin=? and dia=?");
			pstmt.setInt(1, actividad.getCodigo());
			pstmt.setString(2, horaInicio);
			pstmt.setString(3, horaFin);
			pstmt.setString(4, dia);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				Horario H = new Horario(rs.getString("horainicio"), rs.getString("horafin"), rs.getString("dia"));
				return H;
			}
			else
				throw new ActividadException("No hay un horario correspondiente a esa activdad");
		} catch (SQLException e){
			throw new ActividadException("Error al encontrar el horario");
		
		}
	
	}

	public List<ActividadHorarioView> findByDia(String dia) throws ActividadException, ConnectionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<ActividadHorarioView> resultado = new ArrayList<ActividadHorarioView>();
		ActividadHorarioView a ;
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement("select * from HorarioActiv where dia=?");
			pstmt.setString(1, dia);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			while (rs.getRow()!=0){
				int codact = rs.getInt("codigoAct");
				PreparedStatement pstmt2 = con.prepareStatement("select * from Actividades where codigo=?");
				pstmt2.setInt(1, codact);
				ResultSet rs2 = pstmt2.executeQuery();
				rs2.next();
				String nombre = rs2.getString("nombre");
				a = new ActividadHorarioView(rs.getInt("codigoAct"),nombre,rs.getString("horainicio"), rs.getString("horafin"), rs.getString("dia"));
				resultado.add(a);
				rs.next();
			}	
			return resultado;
		}
		catch(Exception e){
			throw new ActividadException("Error al recuperar las actividades");
		}


	}
	public List<Actividad> findAll() throws ActividadException, ConnectionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<Actividad> resultado = new ArrayList<Actividad>();
		Actividad a ;
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement("select * from Actividades");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			while (rs.getRow()!=0){
				a = new Actividad(rs.getString("nombre"), rs.getFloat("preciohora"));
				a.setCodigo(rs.getInt("codigo"));
				resultado.add(a);
				rs.next();
			}	
			return resultado;
		}
		catch(SQLException e){
			throw new ActividadException("Error al recuperar las actividades");
		}


	}
	
}
