package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.conexion;

public class clientesDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	clientesDTO cliente=null;
	PreparedStatement ps;
	ResultSet rs;
		
	public boolean insertar_cliente(clientesDTO client) {
		int result;
		boolean res=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?)");
			ps.setLong(1,client.getCedula_cliente());
			ps.setString(2,client.getDireccion_cliente());
			ps.setString(3,client.getMail_cliente());
			ps.setString(4,client.getNombre_cliente());
			ps.setString(5,client.getTel_cliente());
			result=ps.executeUpdate();
			if(result>0)
				res=true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return res;
	}
	
	public clientesDTO consultarId(clientesDTO cli) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente =?");
			ps.setLong(1, cli.getCedula_cliente());
			rs=ps.executeQuery();
			if(rs.next()) {
				cliente=new clientesDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch(SQLException e) {
			
		}
		return cliente;
		
	}
	
	public int actualizarCli(clientesDTO cli) {
		int res=0;
		try {
			ps=cnn.prepareStatement("UPDATE clientes SET mail_cliente=?, nombre_cliente=?, direccion_cliente=?, tel_cliente=? WHERE cedula_cliente=?");
			ps.setString(1,cli.getMail_cliente());
			ps.setString(2,cli.getNombre_cliente());
			ps.setString(3,cli.getDireccion_cliente());
			ps.setString(4,cli.getTel_cliente());
			ps.setLong(5,cli.getCedula_cliente());
			res=ps.executeUpdate();
		} catch(SQLException e) {
			
		}
		return res;
	}
	
	public int eliminarCli(clientesDTO cli) {
		int res=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
			ps.setLong(1,cli.getCedula_cliente());
			res=ps.executeUpdate();
		} catch(SQLException e) {
			
		}
		return res;
		
	}
	
	public ArrayList<clientesDTO> consultaGral(){
		ArrayList<clientesDTO> listclientes=new ArrayList<>(); 
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes");
			rs=ps.executeQuery();
			while(rs.next()) {
				cliente=new clientesDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				listclientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listclientes;
	}
	

}
