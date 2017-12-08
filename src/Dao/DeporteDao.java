package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Excepciones.ConnectionException;
import Excepciones.DeporteException;
import Clases.Deporte;

public class DeporteDao {
	private static DeporteDao instancia;
	
	private DeporteDao(){
	}
	
	public static DeporteDao getInstance(){
		if (instancia==null)
			instancia = new DeporteDao();
		return instancia;
	}
	
	public Deporte findByID(int codigo) throws ConnectionException, DeporteException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Deporte deporte= null;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Deportes where codigo = "+codigo);
			if(rs.next())
			{
				deporte = new Deporte(rs.getString("nombre"),rs.getString("descripcion"));
				deporte.setCodigo(rs.getInt("codigo"));
				deporte.setActivo(rs.getBoolean("activo"));
			}
			else
				throw new DeporteException("Error al recuperar el deporte");
			if(!deporte.isActivo())
				throw new DeporteException("El deporte esta inactivo");
			return deporte;
		}
		catch(SQLException e){
			throw new DeporteException("Error al recuperar el deporte");
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
	public void save(Deporte deporte) throws ConnectionException, DeporteException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Deportes (nombre, descripcion , activo) VALUES(?,?,1)");
		pstmt.setString(1, deporte.getNombre());
		pstmt.setString(2, deporte.getDescripcion());
		pstmt.execute();
		} catch (SQLException e) {			
			throw new DeporteException("Error al guardar el deporte");
		}
	}
	
	public void delete (Deporte deporte) throws ConnectionException, DeporteException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Deportes set activo=0 where codigo=?");
			pstmt.setInt(1, deporte.getCodigo());
			pstmt.execute();
		} catch (SQLException e) {
			throw new DeporteException("Error al borrar el deporte");
	}
	
	}
	
	public void update (Deporte deporte) throws ConnectionException, DeporteException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Deportes set nombre=?, descripcion=? where codigo=?");
			pstmt.setString(1, deporte.getNombre());
			pstmt.setString(2, deporte.getDescripcion());
			pstmt.setInt(3, deporte.getCodigo());
			pstmt.execute();
		} catch (SQLException e) {
			throw new DeporteException("Error al modificar un deporte");
		}

	}
	
	
}
