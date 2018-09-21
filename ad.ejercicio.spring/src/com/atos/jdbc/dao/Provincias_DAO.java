package com.atos.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atos.jdbc.dto.Provincias;

/**
 * DAO para el proceso de la tabla Provincias,
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 * @since 4-5-2018.
 */
public class Provincias_DAO extends Abstract_DAO {

	public Provincias_DAO() {
		super();
	}

	public Provincias_DAO(int tipo_conexion) {
		super(tipo_conexion);
	}

	// *********** CONSULTAS
	/**
	 * Proceso de consulta de todas las provincias.
	 * 
	 * @return Coleccion de objetos provincias con el resultado de la consulta
	 * @throws SQLException
	 */
	public List<Provincias> consultar_Provincias() throws SQLException {
		List<Provincias> lista = new ArrayList<Provincias>(0);
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("consulta.provincias.todas");
		// CREAMOS EL STATEMENT
		sta = conexion.createStatement();
		// HACEMOS LA CONSULTA
		rs = sta.executeQuery(consulta);
		Provincias provi_nueva;
		// CARGAMOS EL RESULTADO DE LA CONSULTA POR REFLEXION
		while (rs.next()) {
			provi_nueva = new Provincias();
			provi_nueva.setCodigo_provincia(new Byte((byte) rs.getInt(1)));
			provi_nueva.setProvincia(rs.getString(2));
			lista.add(provi_nueva);
		}
		return lista;
	}

	public Provincias consultar_PorCodigo(Byte codigo_provincia) throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("provincias.consulta.codigoprovincia");
		pta = conexion.prepareStatement(consulta);
		pta.setByte(1, codigo_provincia);
		rs = pta.executeQuery();
		Provincias provincia = null;
		if (rs.next()) {
			provincia = new Provincias();
			provincia.setCodigo_provincia(new Byte(rs.getByte(1)));
			provincia.setProvincia(rs.getString(2));
		}
		return provincia;
	}

	// ****************** CRUD PROVINCIAS
	/**
	 * Proceso de altas en la tabla provincias
	 * 
	 * @param provincia_nueva
	 * @throws SQLException
	 */
	public void alta_Provincia(Provincias provincia_nueva) throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("provincias.alta");
		// CREACION DEL PREPARESTATEMENT PARA LANZAR LA ORDEN
		pta = conexion.prepareStatement(consulta);
		// SUSTITUIMOS LAS VARIABLES POR SUS VALORES
		pta.setByte(1, provincia_nueva.getCodigo_provincia());
		pta.setString(2, provincia_nueva.getProvincia());
		// REALIZAR LA ORDEN
		pta.execute();
	}

	/**
	 * Proceso de baja en la tabla provincias.
	 * 
	 * @param provincia_aeliminar
	 * @throws SQLException
	 */
	public void baja_Provincia(Provincias provincia_aeliminar) throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("provincias.baja");
		// CREACION DEL PREPARESTATEMENT PARA LANZAR LA ORDEN
		pta = conexion.prepareStatement(consulta);
		// SUSTITUIMOS LAS VARIABLES POR SUS VALORES
		pta.setByte(1, provincia_aeliminar.getCodigo_provincia());
		// REALIZAR LA ORDEN
		pta.execute();
	}

	/**
	 * Proceso de modificacion en la tabla provincias
	 * 
	 * @param provincia_amodificar
	 * @throws SQLException
	 */
	public void modificacion_Provincia(Provincias provincia_amodificar) throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("provincias.modificacion");
		// CREACION DEL PREPARESTATEMENT PARA LANZAR LA ORDEN
		pta = conexion.prepareStatement(consulta);
		// SUSTITUIMOS LAS VARIABLES POR SUS VALORES
		pta.setByte(2, provincia_amodificar.getCodigo_provincia());
		pta.setString(1, provincia_amodificar.getProvincia());
		// REALIZAR LA ORDEN
		pta.execute();
	}

}
