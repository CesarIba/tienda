package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.conexion;

public class ventasDAO {

	conexion con = new conexion();
	Connection cnn = con.conexiondb();
	ventasDTO venta = null;
	PreparedStatement ps;
	ResultSet rs;

	public boolean insertar_venta(ventasDTO venta) {
		int result;
		boolean res = false;
		try {
			ps = cnn.prepareStatement("INSERT INTO ventas (cedula_cliente,cedula_usuario,iva_venta,total_venta,valor_venta) VALUES(?,?,?,?,?)");
			ps.setLong(1, venta.getCedula_cliente());
			ps.setLong(2, venta.getCedula_usuario());
			ps.setDouble(3, venta.getIva_venta());
			ps.setDouble(4, venta.getTotal_venta());
			ps.setDouble(5, venta.getValor_venta());

			result = ps.executeUpdate();
			if (result > 0)
				res = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return res;
	}
	
	public  ventasDTO consultarcodventa() {
		try {
			ps=cnn.prepareStatement("SELECT MAX(cod_venta),cedula_cliente,cedula_usuario,iva_venta,total_venta,valor_venta AS id FROM ventas");
			rs=ps.executeQuery();
			if(rs.next()) {
				venta=new ventasDTO(rs.getInt(1), rs.getLong(2), rs.getLong(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return venta;
	}
}
