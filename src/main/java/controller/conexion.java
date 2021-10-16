package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {

	Connection conexion;

	public Connection conexiondb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*conexion = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/bd_tienda?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true",
					"root", "xxxxxxxx");*/
			conexion = DriverManager.getConnection(
					"jdbc:mysql://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/bd_TiendaG43_6?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true",
							"admin", "123456789");
			//JOptionPane.showMessageDialog(null,"Conexion Exitosa");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
		}
		return conexion;
	}

	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}