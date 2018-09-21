package com.atos.jdbc.fachada;

import java.sql.SQLException;
import java.util.List;

import com.atos.jdbc.dao.Pais_DAO;
import com.atos.jdbc.dto.Pais;

/**
 * Procesos contra la tabla de paises en la base de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 4-5-2018.
 *
 */
public class Gestion_Pais implements IGestion_Pais  {
	// DAO DE ACCESO A LA FUENTE DE DATOS (B.D.)
	private Pais_DAO pais_dao;

	// ******* CONSTRUCTORES
	public Gestion_Pais() {
		pais_dao = new Pais_DAO();
	}

	public Gestion_Pais(int tipo_conexion) {
		pais_dao = new Pais_DAO(tipo_conexion);
	}

	// ********************* CONSULTAS
	/**
	 * Operacion de consulta a la base de datos.
	 * 
	 * @return List<Pais> Coleccion de objeto sin ordenar.
	 */
	@Override
	public List<Pais> consultar_Todos() {
		List<Pais> lista = null;
		try {
			lista = pais_dao.consultar_Todos();
		} catch (SQLException e) {
			// SIN TRATAMIENTO
		} finally {
			try {
				pais_dao.liberar_Recursos();
			} catch (SQLException e) {
				// SIN TRATAMIENTO
			}
		}
		return lista;
	}

	/**
	 * Proceso de consulta por clave primaria.
	 * 
	 * @param codigo_pais
	 * @return
	 */
	@Override
	public Pais consulta_PorCodigo(Long codigo_pais) {
		Pais pais = null;
		try {
			pais = pais_dao.consultar_PorCodigo(codigo_pais);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pais_dao.liberar_Recursos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais;
	}

	// **************** CRUD PAIS
	@Override
	public void alta_Pais(Pais pais) {
		try {
			pais_dao.alta_Pais(pais);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pais_dao.liberar_Recursos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void baja_Pais(Pais pais) {
		try {
			pais_dao.baja_Pais(pais);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pais_dao.liberar_Recursos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modificacion_Pais(Pais pais) {
		try {
			pais_dao.modificacion_Pais(pais);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pais_dao.liberar_Recursos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
