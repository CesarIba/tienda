package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.conexion;

public class productosDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	//ResultSet rs;
	
	public boolean insertar_Productos(String url) {
		boolean res=false;
		try
		{
			ps=cnn.prepareStatement("load data infile '"+url+"' into table productos fields terminated by ';' lines terminated by '\r\n';");
			res=ps.executeUpdate()>0;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error al cargar archivo en DAO");
		}
		return res;
	}
	

}
