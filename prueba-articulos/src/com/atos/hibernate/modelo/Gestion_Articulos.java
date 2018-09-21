package com.atos.hibernate.modelo;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.atos.hibernate.Articulos;
import com.atos.hibernate.dao.Articulos_DAO;

public class Gestion_Articulos {

	private Articulos_DAO articulo_DAO;

	public Gestion_Articulos() {
		articulo_DAO = new Articulos_DAO();
	}

	public void alta_Articulo(Articulos articulo_nuevo) {
		Transaction tran = articulo_DAO.getSession().beginTransaction();
		try {
			articulo_DAO.alta_Articulos(articulo_nuevo);
			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
		}
		articulo_DAO.getSession().close();
	}
}
