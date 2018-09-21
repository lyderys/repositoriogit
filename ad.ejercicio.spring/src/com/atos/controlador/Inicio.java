package com.atos.controlador;
import org.springframework.context.*;
import java.util.List;

import com.atos.jdbc.conexion.IConexion;
import com.atos.jdbc.dao.Abstract_DAO;
import com.atos.jdbc.dto.Pais;
import com.atos.jdbc.fachada.Gestion_Pais;
import com.atos.jdbc.fachada.IGestion_Pais;
import com.atos.jdbc.spring.Acceso_Manolo;

public class Inicio {

	public static void main(String[] args) {
		Acceso_Manolo contexto = new ClassPathXmlApplicationContext("Manolo.xml");
		IGestion_Pais gestion_pais = new Gestion_Pais();

		Pais pais=gestion_pais.consulta_PorCodigo(new Long(73));
		
		gestion_pais=new Gestion_Pais();
		
		List<Pais> lista=gestion_pais.consultar_Todos();
		

		System.out.println("");

	}

}
