package com.atos.jdbc.fachada;

import java.util.List;

import com.atos.jdbc.dto.Pais;

public interface IGestion_Pais {

	// ********************* CONSULTAS
	/**
	 * Operacion de consulta a la base de datos.
	 * 
	 * @return List<Pais> Coleccion de objeto sin ordenar.
	 */
	List<Pais> consultar_Todos();

	/**
	 * Proceso de consulta por clave primaria.
	 * 
	 * @param codigo_pais
	 * @return
	 */
	Pais consulta_PorCodigo(Long codigo_pais);

	// **************** CRUD PAIS
	void alta_Pais(Pais pais);

	void baja_Pais(Pais pais);

	void modificacion_Pais(Pais pais);

}