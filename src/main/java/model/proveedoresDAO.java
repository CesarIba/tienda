package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.conexion;

public class proveedoresDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	//ResultSet rs;
	
	public boolean insertar_usuario(proveedoresDTO prove) {
		int result;
		boolean res=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
			ps.setLong(1,prove.getNit_proveedor());
			ps.setString(2,prove.getCiudad_priveedor());
			ps.setString(3,prove.getDireccion_proveedor());
			ps.setString(4,prove.getNombre_proveedor());
			ps.setString(5,prove.getTel_proveedor());
			result=ps.executeUpdate();
			if(result>0)
				res=true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return res;
	}
	

}
