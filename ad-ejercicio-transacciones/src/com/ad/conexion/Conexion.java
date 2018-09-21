package com.ad.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion {
	
	private Connection conexion;
	
	private ResourceBundle rb;
	
	public Conexion() {
		rb = ResourceBundle.getBundle("com.ad.conexion.conexion");
	}
	
	public void establecer_Conexion() {
		String url = rb.getString("url");
		String usuario = rb.getString("usuario");
		String clave = rb.getString("clave");
		String driver = rb.getString("driver");
		boolean valido = true;
		try {
			// CARGAMOS EL DRIVER
			Class.forName(driver);
		} catch (Exception e) {
			valido = false;
		}
		if (valido) {
			try {
				// SI LA CARGA DEL DRIVER A SIDO CORRECTA SE CREA LA CONEXION
				conexion = DriverManager.getConnection(url, usuario, clave);
			} catch (SQLException e) {
			}
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}
}
