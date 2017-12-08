package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Abono;
import Clases.Actividad;
import Clases.Horario;
import Clases.ItemActividadHorario;
import Excepciones.ConnectionException;
import Excepciones.AbonoException;
import Excepciones.ActividadException;

public class AbonoDao {
	private static AbonoDao instancia;
	
	private AbonoDao(){
	}
	
	public static AbonoDao getInstance(){
		if (instancia==null)
			instancia = new AbonoDao();
		return instancia;
	}
	
	public Abono findByID(int codigo) throws ConnectionException, AbonoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Abono abono= null;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Abonos where codigo = "+codigo);
			if(rs.next())
			{
				abono = new Abono(rs.getString("nombre"));
				abono.setActivo(rs.getBoolean("activo"));
				abono.setCodigo(rs.getInt("codigo"));
				
			}
			else
				throw new AbonoException("Error al recuperar el abono");
			
			if(!abono.isActivo())
				throw new AbonoException("El abono esta inactivo");
			return abono;
		}
		catch(SQLException e){
			throw new AbonoException("Error al recuperar el abono");
		}

	}
	
	public List<Abono> findAll() throws AbonoException, ConnectionException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<Abono> resultado = new ArrayList<Abono>();
		Abono abono ;
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from Abonos");
			rs.next();
			while (rs.getRow()!=0){
				abono = new Abono(rs.getString("nombre"));
				abono.setActivo(rs.getBoolean("activo"));
				abono.setCodigo(rs.getInt("codigo"));
				if(abono.isActivo())
					resultado.add(abono);
				rs.next();
			}			
		}
		catch(Exception e){
			throw new AbonoException("Error al recuperar el Abono");
		}
		return resultado;
	}
	
	public void save(Abono abono) throws ConnectionException, AbonoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
		pstmt = con.prepareStatement("insert into Abonos VALUES(?,1)");
		pstmt.setString(1, abono.getNombre());
		pstmt.execute();
		} catch (SQLException e) {
			throw new AbonoException("Error al guardar abono");
		}
	}
	
	public void delete (Abono abono) throws ConnectionException, AbonoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Abonos set activo=0 where codigo=?");
			pstmt.setInt(1, abono.getCodigo());
			pstmt.execute();
		} catch (SQLException e) {
			throw new AbonoException("Error al borrar abono");
	}
	
	}

	public void agregarActividad(Abono abono, Actividad actividad, Horario horario) throws AbonoException, ConnectionException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Insert into ActiHorAbono VALUES (?,?,?,?,?)");
			pstmt.setInt(1, abono.getCodigo());
			pstmt.setInt(2, actividad.getCodigo());
			pstmt.setString(3, horario.getHoraInicio());
			pstmt.setString(4, horario.getHoraFin());
			pstmt.setString(5, horario.getDia());
			pstmt.execute();
		} catch (SQLException e) {
			throw new AbonoException("Error al agregar la actividad al abono");
	}
		
	}

	public Abono conseguirActividades(Abono abono) throws ConnectionException, ActividadException, AbonoException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		List<ItemActividadHorario> actividades = new ArrayList<ItemActividadHorario>();
		try{
			pstmt = con.prepareStatement("select * from ActiHorAbono where codigoabo  =?");
			pstmt.setInt(1,abono.getCodigo());
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
			abono.setActividades(actividades);
			return abono;
			
			
		}
		catch(Exception e){
			throw new AbonoException("Error al recuperar el abono");
		
		
		}
	}
	public boolean ExisteAbono(int codigo) throws ConnectionException, AbonoException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement("select * from Abonos where codigo=?");		
				pstmt.setInt(1, codigo);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					return true;
				}
				else
					return false;
			}catch (SQLException e) {
				throw new AbonoException("Error en el abono");
			}

			
	}
/*	public void update (Abono abono) throws ConnectionException, AbonoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Update Abono set nombre=? where codigo=?");
			pstmt.setString(1, abono.getNombre());
			pstmt.setString(2, abono.getCodigo());
		} catch (SQLException e) {
			throw new SocioException("Algo fall� pero no estoy muy seguro de qu�");
		}

	}*/
	
	
}
