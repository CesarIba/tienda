package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.conexion;

public class clientesDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	//ResultSet rs;
	
	public boolean insertar_usuario(clientesDTO client) {
		int result;
		boolean res=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
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
	

}
