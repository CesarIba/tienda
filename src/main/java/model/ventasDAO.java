package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			ps = cnn.prepareStatement("INSERT INTO ventas VALUES(?,?,?,?,?,?)");
			ps.setLong(1, venta.getCedula_cliente());
			ps.setLong(2, venta.getCedula_usuario());
			ps.setLong(3, venta.getIva_venta());
			ps.setLong(4, venta.getTotal_venta());
			ps.setLong(5, venta.getValor_venta());

			result = ps.executeUpdate();
			if (result > 0)
				res = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return res;
	}

}
