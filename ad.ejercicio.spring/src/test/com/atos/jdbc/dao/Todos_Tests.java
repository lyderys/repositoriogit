package test.com.atos.jdbc.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.com.atos.jdbc.fachada.Test_GestionPais;

@RunWith(Suite.class)
@SuiteClasses({ Test_PaisDAO.class, Test_GestionPais.class })
public class Todos_Tests {

}
