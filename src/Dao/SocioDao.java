package Dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Clases.Socio;
import Excepciones.ConnectionException;
import Excepciones.SocioException;

public class SocioDao {
	private static SocioDao instancia;
	
	private SocioDao(){
	}
	
	public static SocioDao getInstance(){
		if (instancia==null)
			instancia = new SocioDao();
		return instancia;
	}
	
public Socio findByDNI(String dni) throws ConnectionException, SocioException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Socio socio= null;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Socios where dni = "+dni);
			if(rs.next())
			{
				socio = new Socio(rs.getString("nombre"),rs.getString("DNI"), rs.getString("email"),rs.getString("domicilio"), rs.getString("telefono"));
				socio.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new SocioException("Error al recuperar el socio");
			if(!socio.isActivo())
				throw new SocioException("El socio esta inactivo");
			return socio;
		}
		catch(SQLException e){
			throw new SocioException("Error al recuperar el socio");
		}

	}

	public List<Socio> findAll() throws SocioException, ConnectionException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<Socio> resultado = new ArrayList<Socio>();
		Socio socio ;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Socios");
			rs.next();
			while (rs.getRow()!=0){
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

	public void save(Socio socio) throws ConnectionException, SocioException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Socios VALUES(?,?,?,?,?,1)");
		pstmt.setString(1, socio.getNombre());
		pstmt.setString(2, socio.getDNI());
		pstmt.setString(4, socio.getEmail());
		pstmt.setString(3, socio.getDomicilio());
		pstmt.setString(5, socio.getTelefono());
		pstmt.execute();
		} catch (SQLException e) {
			
			throw new SocioException("Error al crear el socio");
		}

	}
	
	public void delete (Socio socio) throws ConnectionException, SocioException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Socios set activo=0 where dni=?");
			pstmt.setString(1, socio.getDNI());
			pstmt.execute();
		} catch (SQLException e) {
			throw new SocioException("Error al borrar socio");
	}
	
	}
	
	public void update (Socio socio) throws ConnectionException, SocioException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Socios set nombre=?,email=?,domicilio=?,telefono=? where dni=?");
			pstmt.setString(1, socio.getNombre());
			pstmt.setString(2, socio.getEmail());
			pstmt.setString(3, socio.getDomicilio());
			pstmt.setString(4, socio.getTelefono());
			pstmt.setString(5, socio.getDNI());
			pstmt.execute();
		} catch (SQLException e) {
			throw new SocioException("Error al modificar socio");
		}

	}
	
	public void agregarApto(Socio socio, LocalDate fecha, String nombreProfesional, LocalDate vencimiento, String observaciones) throws ConnectionException, SocioException {
		  Connection con = AdminConexion.getInstance().obtenerConexion();
		  try {
			  PreparedStatement pstmt = con.prepareStatement("insert into AptosMedicos values(?,?,?,?)");
			  pstmt.setDate(1, Date.valueOf(fecha));
			  pstmt.setString(2,nombreProfesional);
			  pstmt.setString(3, observaciones);
			  pstmt.setDate(4, Date.valueOf(vencimiento));
			  pstmt.execute();
			  PreparedStatement pstmt2 = con.prepareStatement("select * from AptosMedicos");
			  ResultSet rs = pstmt2.executeQuery();
			  rs.next();
			  PreparedStatement pstmt3 = con.prepareStatement("insert into AptoSocio values(?,?)");
			  pstmt3.setString(1, socio.getDNI());
			  int aux = 0;
			  while(rs.getRow()!=0) {
				  aux++;
				  rs.next();
			  }
			  PreparedStatement pstmt4 = con.prepareStatement("select * from AptosMedicos");
			  ResultSet rs2 = pstmt4.executeQuery();
			  aux=aux-1;
			  rs2.next();
			  while(aux!=0) {
				  rs2.next();
				  aux=aux-1;
			  }
			  pstmt3.setInt(2, rs2.getInt("id"));
			  pstmt3.execute();
		  } catch (SQLException e) {
			  throw new SocioException("Acuda a su medico mas cercano");
		  }
		 }
	
	public boolean aptoAlDia(Socio socio) throws SocioException, ConnectionException
	{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Select * from AptoSocio where dni=? order by id desc");			
			pstmt.setString(1, socio.getDNI());
			ResultSet rs= pstmt.executeQuery();
			rs.next();
			if(rs.getRow()!=0)
			{
				int id= rs.getInt("id");
				PreparedStatement pstmt2;
				pstmt2 = con.prepareStatement("Select * from AptosMedicos where id=?");
				pstmt2.setInt(1, id);
				ResultSet rs2 = pstmt2.executeQuery();
				rs2.next();
				Date vencimiento = rs2.getDate("fechavto");				
				if(vencimiento.after(Date.valueOf(LocalDate.now())))
				{
					return true;
				}
				else
					return false;
			}
			else
				return false;
		} catch (SQLException e) {
			throw new SocioException("Error al modificar socio");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
