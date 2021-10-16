package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controller.conexion;

public class productosDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	productosDTO prodto;
	
	public boolean insertar_Productos(String url) {
		boolean res=false;
		try
		{
			ps=cnn.prepareStatement("load data infile '"+url+"' into table productos fields terminated by ';' lines terminated by '\r\n';");
			res=ps.executeUpdate()>0;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return res;
	}
	
	public productosDTO consultarProd(productosDTO pro) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos WHERE cod_producto=?");
			ps.setLong(1, pro.getCod_producto());
			rs=ps.executeQuery();
			if(rs.next()){
				prodto=new productosDTO(rs.getLong(1), rs.getDouble(2), rs.getLong(3), rs.getString(4), rs.getDouble(5),rs.getDouble(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				  
		return prodto;  
	  }
	

}
