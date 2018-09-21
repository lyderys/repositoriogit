package com.atos.jdbc.conexion;

/**
 * Interface para la clase de gestion de conexiones dentro del programa. Define
 * tambien las constantes de clase que se necesitan para la gestion dinamica de
 * la conexion.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0.
 * @since 4 may. 2018.
 */
public interface IConexion {

	// CONJUNTO DE CONSTANTES DE CLASE PARA PEDIR EL TIPO DE CONEXION QUE SE
	// QUIERE EN CADA MOMENTO
	public static final int DESARROLLO = 10;
	public static final int PRODUCCION = 20;
	public static final int PREPRODUCCION = 30;
	public static final int CASA = 40;

	/**
	 * Proceso de establecer la conexion con la base de datos a partir de la
	 * informacion contenida en el fichero de propiedades adjunto.<br/>
	 * El tipo de conexion viene definida por el valor leido en el properties.
	 */
	void crear_ConexionAutomatica();

	/**
	 * Proceso de conexion a partir del tipo pedido.
	 * 
	 * @param tipo_conexion
	 *            Valor numerico que indica el tipo de conexion.
	 */
	void crear_ConexionManual(int tipo_conexion);

}