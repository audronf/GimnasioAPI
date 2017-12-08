package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Clases.PCompleto;
import Clases.PParticular;
import Excepciones.ConnectionException;
import Excepciones.ProfesorException;

public class ProfesorDao {
	private static ProfesorDao instancia;
	
	private ProfesorDao(){
	}
	
	public static ProfesorDao getInstance(){
		if (instancia==null)
			instancia = new ProfesorDao();
		return instancia;
	}

	public void saveCompleto(PCompleto profesor) throws ConnectionException, ProfesorException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Profesores (tipo,nombre,dni,domicilio,telefono,mail,sueldo,retenciones,deducciones,activo) VALUES('Completo',?,?,?,?,?,?,?,?,1)");
		pstmt.setString(1, profesor.getNombre());
		pstmt.setString(2, profesor.getDNI());
		pstmt.setString(3, profesor.getDomicilio());
		pstmt.setString(4, profesor.getTelefono());
		pstmt.setString(5, profesor.getMail());
		pstmt.setFloat(6, profesor.getSueldo());
		pstmt.setFloat(7, profesor.getRetenciones());
		pstmt.setFloat(8, profesor.getDeducciones());
		pstmt.execute();
		} catch (SQLException e) {
			
			throw new ProfesorException("Error al crear el profesor");
		}
	
	}
	
	public void saveParticular(PParticular profesor) throws ConnectionException, ProfesorException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Profesores (tipo,nombre,dni,domicilio,telefono,mail,valorhora,activo)VALUES('Particular',?,?,?,?,?,?,1)");
		pstmt.setString(1, profesor.getNombre());
		pstmt.setString(2, profesor.getDNI());
		pstmt.setString(3, profesor.getDomicilio());
		pstmt.setString(4, profesor.getTelefono());
		pstmt.setString(5, profesor.getMail());
		pstmt.setFloat(6, profesor.getvalorHora());
		pstmt.execute();
		} catch (SQLException e) {
			
			throw new ProfesorException("Error al crear el profesor");
		}	
	}
	
	public void UpdateParticular(PParticular profesor) throws ConnectionException, ProfesorException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("Update Profesores set nombre=?,domicilio=?,telefono=?,mail=?, valorhora=? where dni=?");
		pstmt.setString(1, profesor.getNombre());
		pstmt.setString(2, profesor.getDomicilio());
		pstmt.setString(3, profesor.getTelefono());
		pstmt.setString(4, profesor.getMail());
		pstmt.setFloat(5, profesor.getvalorHora());
		pstmt.setString(6, profesor.getDNI());
		pstmt.execute();
		} catch (SQLException e) {
			
			throw new ProfesorException("Error al modificar el profesor");
		}	
	}
	
	public void UpdateCompleto(PCompleto profesor) throws ConnectionException, ProfesorException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("Update Profesores set nombre=?,domicilio=?,telefono=?, mail=?,sueldo=?,retenciones=?,deducciones=? where dni=?");
		pstmt.setString(1, profesor.getNombre());
		pstmt.setString(2, profesor.getDomicilio());
		pstmt.setString(3, profesor.getTelefono());
		pstmt.setString(4, profesor.getMail());
		pstmt.setFloat(5, profesor.getSueldo());
		pstmt.setFloat(6, profesor.getRetenciones());
		pstmt.setFloat(7, profesor.getDeducciones());
		pstmt.setString(8, profesor.getDNI());
		pstmt.execute();
		} catch (SQLException e) {
			
			throw new ProfesorException("Error al modificar el profesor");
		}	
	}
	public PCompleto findByDNICompleto(String dni) throws ConnectionException, ProfesorException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PCompleto profesor = null;
		try{
			PreparedStatement pstmt = con.prepareStatement("select * from Profesores where dni = ? and tipo = 'Completo'");
			pstmt.setString(1, dni);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				profesor = new PCompleto(rs.getString("nombre"),rs.getString("DNI"), rs.getString("domicilio"),rs.getString("telefono"), rs.getString("mail"), rs.getFloat("sueldo"), rs.getFloat("retenciones"), rs.getFloat("deducciones"));
				profesor.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new ProfesorException("Error al recuperar el profesor");
			if(!profesor.isActivo())
				throw new ProfesorException("El profesor esta inactivo");
			return profesor;
		}	
		catch(SQLException e){
			throw new ProfesorException("Error al recuperar el profesor");
		}

	}
	public PParticular findByDNIParticular(String dni) throws ConnectionException, ProfesorException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PParticular profesor = null;
		try{
			PreparedStatement pstmt = con.prepareStatement("select * from Profesores where dni = ? and tipo = 'Particular'");
			pstmt.setString(1, dni);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				profesor = new PParticular(rs.getString("nombre"),rs.getString("DNI"), rs.getString("domicilio"),rs.getString("telefono"), rs.getString("mail"), rs.getFloat("valorhora"));
				profesor.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new ProfesorException("Error al recuperar el profesor");
		
		if(!profesor.isActivo())
			throw new ProfesorException("El profesor esta inactivo");
		return profesor;
		}
		catch(SQLException e){
			throw new ProfesorException("Error al recuperar el profesor");
		}

	}
	
	public boolean existeProfesor(String dni) throws ConnectionException, ProfesorException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		try{
			PreparedStatement pstmt = con.prepareStatement("select * from Profesores where dni = ?");
			pstmt.setString(1, dni);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{	
				if(rs.getBoolean("Activo"))
					return true;
			}
			else
				return false;
		}
		catch(Exception e){
			throw new ProfesorException("Error al recuperar el profesor");
		}
		return false;
	}
	
	
	public void DeleteCompleto(PCompleto profesor) throws ConnectionException, ProfesorException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("Update Profesores set activo=0 where dni=? and tipo='Completo'");
		pstmt.setString(1, profesor.getDNI());
		pstmt.execute();
		} catch (SQLException e) {
			
			throw new ProfesorException("Error al borrar el profesor");
		}
		
	}
	
	public void DeleteParticular(PParticular profesor) throws ConnectionException, ProfesorException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("Update Profesores set activo=0 where dni=? and tipo='Particular'");
		pstmt.setString(1, profesor.getDNI());
		pstmt.execute();
		} catch (SQLException e) {
			
			throw new ProfesorException("Error al borrar el profesor");
		}
		
	}
}