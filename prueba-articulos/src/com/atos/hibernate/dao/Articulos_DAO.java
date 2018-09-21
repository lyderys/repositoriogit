package com.atos.hibernate.dao;

import org.hibernate.HibernateException;

import com.atos.hibernate.Articulos;

public class Articulos_DAO extends BaseHibernateDAO {

	public void alta_Articulos(Articulos articulo_nuevo) throws HibernateException {
		getSession().save(articulo_nuevo);
	}

	public void baja_Articulos(Articulos articulo_nuevo) throws HibernateException {
		getSession().delete(articulo_nuevo);
	}

	public void modificacion_Articulos(Articulos articulo_nuevo) throws HibernateException {
		getSession().update(articulo_nuevo);
	}

	public Articulos consultar_PorClave(Integer clave_articulo) throws HibernateException {
		return (Articulos) getSession().get("com.atos.hibernate.Articulos", clave_articulo);
	}
}
