package com.ad.hibernate.dao;

import org.hibernate.HibernateException;

import com.ad.hibernate.dto.Articulos;

public class Articulos_DAO extends BaseHibernateDAO {
	public void alta_Articulos(Articulos articulo_nuevo) throws HibernateException{
		getSession().save(articulo_nuevo);
	}
	
	public void baja_Articulos(Articulos articulo_nuevo) throws HibernateException{
		getSession().delete(articulo_nuevo);
	}
	
	public void modificacion_Articulos(Articulos articulo_nuevo) throws HibernateException{
		getSession().update(articulo_nuevo);
	}
	
	public Articulos consultar_PorClave(Integer clave_articulo) throws HibernateException{
		return (Articulos) getSession().get("com.ad.hibernate.dto.Articulos", clave_articulo);
	}
}
