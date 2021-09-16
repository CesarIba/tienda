package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.conexion;

public class usuariosDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	//ResultSet rs;
	
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
	

}
