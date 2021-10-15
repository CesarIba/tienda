package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.conexion;

public class detalleventasDAO {

	conexion con = new conexion();
	Connection cnn = con.conexiondb();
	detalleventasDTO detventa = null;
	PreparedStatement ps;
	ResultSet rs;

	public boolean insertar_detventa(detalleventasDTO detventa) {
		int result;
		boolean res = false;
		try {
			ps = cnn.prepareStatement("Insert Into det_ventas(cant_producto,cod_producto,cod_venta,valor_total,valor_venta,valor_iva) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, detventa.getCant_producto());
			ps.setLong(2, detventa.getCod_producto());
			ps.setLong(3, detventa.getCod_venta());
			ps.setDouble(4, detventa.getValor_total());
			ps.setDouble(5, detventa.getValor_venta());
			ps.setDouble(6, detventa.getValor_iva());

			result = ps.executeUpdate();
			if (result > 0)
				res = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return res;
	}

}
