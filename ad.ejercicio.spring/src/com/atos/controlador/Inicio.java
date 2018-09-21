package com.atos.controlador;

import java.util.List;

import com.atos.jdbc.conexion.IConexion;
import com.atos.jdbc.dao.Abstract_DAO;
import com.atos.jdbc.dto.Pais;
import com.atos.jdbc.fachada.Gestion_Pais;
import com.atos.jdbc.fachada.IGestion_Pais;

public class Inicio {

	public static void main(String[] args) {
		IGestion_Pais gestion_pais = new Gestion_Pais();

		Pais pais=gestion_pais.consulta_PorCodigo(new Long(73));
		
		gestion_pais=new Gestion_Pais();
		
		List<Pais> lista=gestion_pais.consultar_Todos();
		

		System.out.println("");

	}

}
