package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Clases.Sueldo;
import Excepciones.ConnectionException;
import Excepciones.SocioException;

public class SueldoDao {
private static SueldoDao instancia;
	
	private SueldoDao(){
	}
	
	public static SueldoDao getInstance(){
		if (instancia==null)
			instancia = new SueldoDao();
		return instancia;
	}
	public void save(Sueldo sueldo) throws ConnectionException, SocioException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Sueldos VALUES(?,?,?,?)");
		pstmt.setInt(1, sueldo.getMes());
		pstmt.setInt(2, sueldo.getAno());
		pstmt.setString(3, sueldo.getEmpleado().getDNI());
		pstmt.setDouble(4, sueldo.getSueldoNeto());
		pstmt.execute();
		} catch (SQLException e) {
			throw new SocioException("Error al guardar sueldo");
		}

	}
	
}