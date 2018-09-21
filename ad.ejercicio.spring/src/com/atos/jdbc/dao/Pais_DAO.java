package com.atos.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atos.jdbc.dto.Pais;

public class Pais_DAO extends Abstract_DAO {

	/**
	 * Creacion del DAO obteniendo la conexion mediante el proceso por defecto.
	 * <br/>
	 * Resolviendo en el constructor de clase padre.
	 */
	public Pais_DAO() {
		super();
	}

	/**
	 * Creacion del DAO obteniendo la conexion mediante el proceso de peticion
	 * concreta de conexion.<br/>
	 * Resolviendo en el constructor de clase padre.
	 * 
	 * @param tipo_conexion
	 *            Valor numerico que define el tipo de conexion. Constante de
	 *            clase en Conexion.java
	 */
	public Pais_DAO(int tipo_conexion) {
		super(tipo_conexion);
	}

	// *********** CONSULTAS
	/**
	 * Proceso de consulta de todos los paises de la tabla, sin ningun criterio
	 * de consulta.
	 * 
	 * @return Coleccion con los DTO resultantes de la consulta.
	 * @throws SQLException
	 */
	public List<Pais> consultar_Todos() throws SQLException {
		// PREPARAMOS LA LISTA PARA OBTENER EL RESULTADO DE LA CONSULTA
		List<Pais> lista = new ArrayList<Pais>(0);
		// CREAMOS EL STATEMENT NECESARIO PARA LANZAR LA ORDEN SQL SIN
		// VARIABLES
		sta = conexion.createStatement();
		// EJECUTAMOS LA CONSULTA SACANDO EL CODIGO SQL DEL PROPERTIES
		rs = sta.executeQuery(rb.getString("consulta.paises.todos"));
		Pais nuevo_pais;
		// PROCESAMOS EL RESULTADO DE LA CONSULTA CREANDO LOS DTO NECESARIOS
		// PARA ALMACENAR TODA LA INFORMACION RECIBIDA
		while (rs.next()) {
			nuevo_pais = new Pais();
			// CARGA MANUAL DE DATOS EN EL DTO (SIN REFLEXION)
			nuevo_pais.setCodigo_pais(rs.getLong(1));
			nuevo_pais.setPais_iso2(rs.getString(3));
			nuevo_pais.setPais_iso3(rs.getString(4));
			nuevo_pais.setPais_isonum(rs.getInt(2));
			nuevo_pais.setPais_nombre(rs.getString(5));
			lista.add(nuevo_pais);
		}
		return lista;
	}

	/**
	 * Proceso de consulta por codigo_pais (clave primaria).
	 * 
	 * @param codigo_pais
	 *            Valor numerico que sera la clave a buscar en al BD.
	 * @return DTO con la informacion de la BD, o nulo en caso de no existir la
	 *         clave.
	 * @throws SQLException
	 */
	public Pais consultar_PorCodigo(Long codigo_pais) throws SQLException {
		// RECUPERAMOS LA SENTENCIA SQL
		String alta_pais = rb.getString("pais.consulta.codigopais");
		// CREAMOS EL OBJETO DE DATOS
		pta = conexion.prepareStatement(alta_pais);
		// SUSTITUIMOS LAS VARIABLES POR LOS VALORES CORRESPONDIENTES
		pta.setLong(1, codigo_pais);
		// EJECUTEMOS LA CONSULTA
		rs = pta.executeQuery();
		Pais pais = null;
		if (rs.next()) {
			pais = new Pais();
			// CARGA MANUAL DE DATOS EN EL DTO (SIN REFLEXION)
			pais.setCodigo_pais(rs.getLong(1));
			pais.setPais_iso2(rs.getString(3));
			pais.setPais_iso3(rs.getString(4));
			pais.setPais_isonum(rs.getInt(2));
			pais.setPais_nombre(rs.getString(5));
		}
		return pais;
	}

	// ****************** CRUD DE PAIS
	/**
	 * Proceso de alta de pais en la BD.
	 * 
	 * @param pais_nuevo
	 *            DTO con la informacion a dar de alta.
	 * @throws SQLException
	 */
	public void alta_Pais(Pais pais_nuevo) throws SQLException {
		// RECUPERAMOS LA SENTENCIA SQL
		String alta_pais = rb.getString("pais.alta");
		// CREAMOS EL OBJETO DE DATOS
		pta = conexion.prepareStatement(alta_pais);
		// SUSTITUIMOS LAS VARIABLES POR LOS VALORES CORRESPONDIENTES
		pta.setLong(1, pais_nuevo.getCodigo_pais());
		pta.setInt(2, pais_nuevo.getPais_isonum());
		pta.setString(3, pais_nuevo.getPais_iso2());
		pta.setString(4, pais_nuevo.getPais_iso3());
		pta.setString(5, pais_nuevo.getPais_nombre());
		pta.execute();
	}

	/**
	 * Proceso de baja de pais en la BD.
	 * 
	 * @param pais_nuevo
	 *            DTO con la clave primaria del registro a dar de baja.
	 * @throws SQLException
	 */
	public void baja_Pais(Pais pais_nuevo) throws SQLException {
		// RECUPERAMOS LA SENTENCIA SQL
		String baja_pais = rb.getString("pais.baja");
		// CREAMOS EL OBJETO DE DATOS
		pta = conexion.prepareStatement(baja_pais);
		// SUSTITUIMOS LAS VARIABLES POR LOS VALORES CORRESPONDIENTES
		pta.setLong(1, pais_nuevo.getCodigo_pais());
		pta.execute();
	}

	/**
	 * Proceso de modificacion del pais en la BD.
	 * 
	 * @param pais_nuevo
	 *            DTO con la informacion a modificar.
	 * @throws SQLException
	 */
	public void modificacion_Pais(Pais pais_nuevo) throws SQLException {
		// RECUPERAMOS LA SENTENCIA SQL
		String modificacion_pais = rb.getString("pais.modificacion");
		// CREAMOS EL OBJETO DE DATOS
		pta = conexion.prepareStatement(modificacion_pais);
		// SUSTITUIMOS LAS VARIABLES POR LOS VALORES CORRESPONDIENTES
		pta.setInt(1, pais_nuevo.getPais_isonum());
		pta.setString(2, pais_nuevo.getPais_iso2());
		pta.setString(3, pais_nuevo.getPais_iso3());
		pta.setString(4, pais_nuevo.getPais_nombre());
		pta.setLong(5, pais_nuevo.getCodigo_pais());
		pta.execute();
	}

}
