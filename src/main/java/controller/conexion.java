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
			//conexion = DriverManager.getConnection("mysql:jdbc://localhost:3306/bd_tienda","root", "Cartod861120");
			conexion = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/bd_tienda?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true",
					"root", "Cartod861120");
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