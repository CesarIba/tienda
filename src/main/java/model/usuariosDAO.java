package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controller.conexion;

public class usuariosDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	usuariosDTO usuario=null;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean insertar_usuario(usuariosDTO user) {
		int result;
		boolean res=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
			ps.setLong(1,user.getCedula_usuario());
			ps.setString(2,user.getMail_usuario());
			ps.setString(3,user.getNombre_usuario());
			ps.setString(4,user.getClave());
			ps.setString(5,user.getUsuario());
			result=ps.executeUpdate();
			if(result>0)
				res=true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return res;
	}
	
	public usuariosDTO consultarId(usuariosDTO usu) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM USUARIOS WHERE cedula_usuario =?");
			ps.setLong(1, usu.getCedula_usuario());
			rs=ps.executeQuery();
			if(rs.next()) {
				usuario=new usuariosDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch(SQLException e) {
			
		}
		return usuario;
		
	}
	
	public int actualizarUsu(usuariosDTO usu) {
		int res=0;
		try {
			ps=cnn.prepareStatement("UPDATE usuarios SET mail_usuario=?, nombre_usuario=?, clave=?, usuario=? WHERE cedula_usuario=?");
			ps.setString(1,usu.getMail_usuario());
			ps.setString(2,usu.getNombre_usuario());
			ps.setString(3,usu.getClave());
			ps.setString(4,usu.getUsuario());
			ps.setLong(5,usu.getCedula_usuario());
			res=ps.executeUpdate();
		} catch(SQLException e) {
			
		}
		return res;
	}
	
	public int eliminarUsu(usuariosDTO usu) {
		int res=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setLong(1,usu.getCedula_usuario());
			res=ps.executeUpdate();
		} catch(SQLException e) {
			
		}
		return res;
		
	}
	

}
