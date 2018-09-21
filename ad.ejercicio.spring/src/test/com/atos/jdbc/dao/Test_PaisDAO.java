package test.com.atos.jdbc.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.atos.jdbc.dao.Pais_DAO;

public class Test_PaisDAO {

	private Pais_DAO pais_dao;

	@Before
	public void inicio_Prueba() {
		pais_dao = new Pais_DAO();
	}

	@Test
	public void testPais_DAO() {
		assertNotNull("NO SE HA CREADO LA CONEXION", pais_dao.getConexion());
		assertNotNull("NO SE HA CREADO EL OBJETO LECTOR DEL PROPERTIES", pais_dao.getRb());
	}

	@Test
	public void testPais_DAOInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar_Todos() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar_PorCodigo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlta_Pais() {
		fail("Not yet implemented");
	}

	@Test
	public void testBaja_Pais() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificacion_Pais() {
		fail("Not yet implemented");
	}

}
