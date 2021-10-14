package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.conexion;

public class proveedoresDAO {
	
	conexion con=new conexion();
	Connection cnn=con.conexiondb();
	proveedoresDTO proveedor=null;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean insertar_proveedor(proveedoresDTO prov) {
		int result;
		boolean res=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO proveedores VALUES(?,?,?,?,?)");
			ps.setLong(1,prov.getNit_proveedor());
			ps.setString(2,prov.getCiudad_priveedor());
			ps.setString(3,prov.getDireccion_proveedor());
			ps.setString(4,prov.getNombre_proveedor());
			ps.setString(5,prov.getTel_proveedor());
			result=ps.executeUpdate();
			if(result>0)
				res=true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return res;
	}
	
	public proveedoresDTO consultarnit(proveedoresDTO prov) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor =?");
			ps.setLong(1, prov.getNit_proveedor());
			rs=ps.executeQuery();
			if(rs.next()) {
				proveedor=new proveedoresDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch(SQLException e) {
			
		}
		return proveedor;
		
	}
	
	public int actualizarProv(proveedoresDTO prov) {
		int res=0;
		try {
			ps=cnn.prepareStatement("UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, tel_proveedor=? WHERE nit_proveedor=?");
			ps.setString(1,prov.getCiudad_priveedor());
			ps.setString(2,prov.getDireccion_proveedor());
			ps.setString(3,prov.getNombre_proveedor());
			ps.setString(4,prov.getTel_proveedor());
			ps.setLong(5,prov.getNit_proveedor());
			res=ps.executeUpdate();
		} catch(SQLException e) {
			
		}
		return res;
	}
	
	public int eliminarProv(proveedoresDTO prov) {
		int res=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM proveedores WHERE nit_proveedor=?");
			ps.setLong(1,prov.getNit_proveedor());
			res=ps.executeUpdate();
		} catch(SQLException e) {
		
		}
		return res;
	}
	public ArrayList<proveedoresDTO> consultaGral(){
		ArrayList<proveedoresDTO> listproveedores=new ArrayList<>(); 
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores");
			rs=ps.executeQuery();
			while(rs.next()) {
				proveedor=new proveedoresDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				listproveedores.add(proveedor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listproveedores;
	}
}