package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.conexion;

public class ventasClienteDAO {

	conexion con = new conexion();
	Connection cnn = con.conexiondb();
	ventasClienteDTO venta = null;
	PreparedStatement ps;
	ResultSet rs;

	public  ArrayList<ventasClienteDTO> consultarVenta_cli() {
		ArrayList<ventasClienteDTO> listVentclientes=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT cli.cedula_cliente, cli.nombre_cliente, vent.cod_venta, vent.valor_venta \r\n"
					+ "FROM clientes cli\r\n"
					+ "INNER JOIN ventas vent ON cli.cedula_cliente=vent.cedula_cliente");
			rs=ps.executeQuery();
			while(rs.next()) {
				venta=new ventasClienteDTO(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
				listVentclientes.add(venta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVentclientes;
	}
}
