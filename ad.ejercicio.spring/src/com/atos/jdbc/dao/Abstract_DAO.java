package com.atos.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.atos.jdbc.conexion.Conexion;

/**
 * Padre comun a todos los daos de jdbc.<br/>
 * Se habilitan dos modalidades de obtencion de conexion partir de los dos
 * constructores.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 4-5-2018.
 */
public abstract class Abstract_DAO {
	// PROPIEDADES COMUNES PARA SU USO EN TODOS LOS DAOS.
	protected Connection conexion;
	protected Statement sta;
	protected ResultSet rs;
	protected ResourceBundle rb;
	protected PreparedStatement pta;
	protected CallableStatement cta;

	// *********** ZONA DE CONSTRUCTORES ***************
	/**
	 * Establecemos la conexion a la BD segun la operativa automatica.
	 */
	public Abstract_DAO() {
		// INICIAMOS EL PROCESO DE OBTENCION DE CONEXION
		Conexion con = new Conexion();
		// SOLICITAMOS CONEXION SEGUN LA ESTRATEGIA QUE NECESITEMOS
		con.crear_ConexionAutomatica();
		// RECOGEMOS LA CONEXION OBTENIDA
		conexion = con.getConexion();
		// CARGAMOS EL FICHERO DE TEXTO CON LAS SENTENCIAS SQL A USAR
		rb = ResourceBundle.getBundle("com.atos.jdbc.sql");
	}

	/**
	 * Establecemos la conexion a la BD segun la operativa manual de peticion
	 * concreta de conexion.<br/>
	 * El parametro del constructor esta definido por las constantes de clase de
	 * Conexion.
	 */
	public Abstract_DAO(int tipo_conexion) {
		// INICIAMOS EL PROCESO DE OBTENCION DE CONEXION
		Conexion con = new Conexion();
		// SOLICITAMOS CONEXION SEGUN LA ESTRATEGIA QUE NECESITEMOS
		con.crear_ConexionManual(tipo_conexion);
		// RECOGEMOS LA CONEXION OBTENIDA
		conexion = con.getConexion();
		// CARGAMOS EL FICHERO DE TEXTO CON LAS SENTENCIAS SQL A USAR
		rb = ResourceBundle.getBundle("com.atos.jdbc.sql");
	}

	// *********** FIN ZONA DE CONSTRUCTORES ***************

	/**
	 * Liberamos recursos para implementar el modelo desconectado.<br/>
	 * El proceso sera en el orden inverso de creacion.
	 * 
	 * @throws SQLException
	 */
	public void liberar_Recursos() throws SQLException {
		if (rs != null) {
			// CERRAMOS EL RESULTSET
			rs.close();
		}
		if (pta != null) {
			// CERRAMOS EL PREPARESTATEMENT
			pta.close();
		}
		if (sta != null) {
			// CERRAMOS EL STATEMENT
			sta.close();
		}
		if (cta != null) {
			// CERRAMOS EL CALLABLESTATEMENT
			cta.close();
		}
		if (conexion != null) {
			// CERRAMOS LA CONEXION
			conexion.close();
		}
	}

	// ********* PROCESOS COMUNES PARA TRANSACCIONES
	/**
	 * Proceso de inicio de la transaccion.
	 */
	public void iniciar_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.setAutoCommit(false);
		}
	}

	/**
	 * Proceso de confirmacion de transaccion.
	 * 
	 * @throws SQLException
	 */
	public void confirmar_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.commit();
		}
	}

	/**
	 * Proceso de anulacion de transaccion.
	 * 
	 * @throws SQLException
	 */
	public void anular_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.rollback();
		}
	}

	/**
	 * Proceso para recibir la conexion de otro dao y poder resolver las
	 * transacciones.
	 * 
	 * @param conexion
	 */
	public void recibir_Conexion(Connection conexion) throws SQLException {
		liberar_Recursos();
		this.conexion = conexion;
	}

	// METODO A�ADIDO PARA LA EJECUCION DE LAS PRUEBAS
	public Connection getConexion() {
		return conexion;
	}

	public ResourceBundle getRb() {
		return rb;
	}

	public void setRb(ResourceBundle rb) {
		this.rb = rb;
	}

}
