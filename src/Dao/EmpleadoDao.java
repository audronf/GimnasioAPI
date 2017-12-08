package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Empleado;
import Excepciones.ConnectionException;
import Excepciones.EmpleadoException;

public class EmpleadoDao {
private static EmpleadoDao instancia;
	
	private EmpleadoDao(){
	}
	
	public static EmpleadoDao getInstance(){
		if (instancia==null)
			instancia = new EmpleadoDao();
		return instancia;
	}
	
	public Empleado findByDNI(String dni) throws ConnectionException, EmpleadoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Empleado empleado= null;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Empleados where dni = "+dni);
			if(rs.next())
			{
				empleado = new Empleado(rs.getString("nombre"),rs.getString("dni"), rs.getString("domicilio"),rs.getString("telefono"), rs.getString("mail"), rs.getString("puesto"), rs.getDouble("sueldo"),(rs.getDouble("retenciones")),rs.getDouble("deducciones"));
				empleado.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new EmpleadoException("Error al recuperar el empleado");
			if(!empleado.isActivo())
				throw new EmpleadoException("El empleado esta inactivo");
			return empleado;
		}
		catch(SQLException e){
			throw new EmpleadoException("Error al recuperar el empleado");
		}

	}
	
	public List<Empleado> findAll() throws EmpleadoException, ConnectionException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<Empleado> resultado = new ArrayList<Empleado>();
		Empleado empleado ;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Empleados");
			rs.next();
			while (rs.getRow()!=0){
				empleado = new Empleado(rs.getString("nombre"),rs.getString("DNI"), rs.getString("domicilio"),rs.getString("telefono"), rs.getString("mail"), rs.getString("puesto"), rs.getDouble("sueldo"),rs.getDouble("retenciones"),rs.getDouble("deducciones"));
				empleado.setActivo(rs.getBoolean("activo"));
				if(empleado.isActivo())
					resultado.add(empleado);
				rs.next();
			}			
		}
		catch(Exception e){
			throw new EmpleadoException("Error al recuperar el empleado");
		}
		return resultado;
	}
	
	public void save(Empleado empleado) throws ConnectionException, EmpleadoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Empleados VALUES(?,?,?,?,?,?,?,?,?,1)");
		pstmt.setString(1, empleado.getNombre());
		pstmt.setString(2, empleado.getDNI());
		pstmt.setString(3, empleado.getMail());
		pstmt.setString(4, empleado.getDomicilio());
		pstmt.setString(5, empleado.getTelefono());
		pstmt.setString(6, empleado.getPuesto());
		pstmt.setDouble(7, empleado.getSueldo());
		pstmt.setDouble(8, empleado.getRetenciones());
		pstmt.setDouble(9, empleado.getDeducciones());
		pstmt.execute();
		} catch (SQLException e) {
			
			
			throw new EmpleadoException("Error al guardar empleado");
		}

	}
	
	public void delete (Empleado empleado) throws ConnectionException, EmpleadoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Empleados set activo=0 where dni=?");
			pstmt.setString(1, empleado.getDNI());
			pstmt.execute();
		} catch (SQLException e) {
			throw new EmpleadoException("Error al borrar el empleado");
	}
	
	}
	
	public void update (Empleado empleado) throws ConnectionException, EmpleadoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Empleados set nombre=?,mail=?,domicilio=?,telefono=?,puesto=?,sueldo=?,retenciones=?,deducciones=? where dni=?");
			pstmt.setString(1, empleado.getNombre());
			pstmt.setString(2, empleado.getMail());
			pstmt.setString(3, empleado.getDomicilio());
			pstmt.setString(4, empleado.getTelefono());
			pstmt.setString(5, empleado.getPuesto());
			pstmt.setDouble(6, empleado.getSueldo());
			pstmt.setDouble(7, empleado.getRetenciones());
			pstmt.setDouble(8, empleado.getDeducciones());
			pstmt.setString(9, empleado.getDNI());
			pstmt.execute();
		} catch (SQLException e) {
			throw new EmpleadoException("Error al modificar empleado");
		}

	}
	
}