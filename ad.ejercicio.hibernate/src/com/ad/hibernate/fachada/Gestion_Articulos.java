package com.ad.hibernate.fachada;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.ad.hibernate.dao.Articulos_DAO;
import com.ad.hibernate.dto.Articulos;

public class Gestion_Articulos implements IGestion_Articulos {
	private Articulos_DAO articulo_DAO;
	
	public Gestion_Articulos() {
		articulo_DAO=new Articulos_DAO();
	}
	
	/* (non-Javadoc)
	 * @see com.ad.hibernate.fachada.IGestion_Articulos#alta_Articulo(com.ad.hibernate.dto.Articulos)
	 */
	@Override
	public void alta_Articulo(Articulos articulo_nuevo) {
		Transaction tran=articulo_DAO.getSession().beginTransaction();
		
		try {
			articulo_DAO.alta_Articulos(articulo_nuevo);
			tran.commit();
		}catch(HibernateException e) {
			tran.rollback();
		}
		articulo_DAO.getSession().close();
	}
	
	/* (non-Javadoc)
	 * @see com.ad.hibernate.fachada.IGestion_Articulos#baja_Articulo(com.ad.hibernate.dto.Articulos)
	 */
	@Override
	public void baja_Articulo(Articulos articulo_nuevo) {
		Transaction tran=articulo_DAO.getSession().beginTransaction();
		
		try {
			articulo_DAO.baja_Articulos(articulo_nuevo);
			tran.commit();
		}catch(HibernateException e) {
			tran.rollback();
		}
		articulo_DAO.getSession().close();
	}
	
	/* (non-Javadoc)
	 * @see com.ad.hibernate.fachada.IGestion_Articulos#modificacion_Articulo(com.ad.hibernate.dto.Articulos)
	 */
	@Override
	public void modificacion_Articulo(Articulos articulo_nuevo) {
		Transaction tran=articulo_DAO.getSession().beginTransaction();
		
		try {
			articulo_DAO.modificacion_Articulos(articulo_nuevo);
			tran.commit();
		}catch(HibernateException e) {
			tran.rollback();
		}
		articulo_DAO.getSession().close();
	}
	
	/* (non-Javadoc)
	 * @see com.ad.hibernate.fachada.IGestion_Articulos#consultar_PorClave(java.lang.Integer)
	 */
	@Override
	public void consultar_PorClave(Integer clave_articulo) {
		Transaction tran=articulo_DAO.getSession().beginTransaction();
		
		try {
			articulo_DAO.consultar_PorClave(clave_articulo);
			tran.commit();
		}catch(HibernateException e) {
			tran.rollback();
		}
		articulo_DAO.getSession().close();
	}
}
