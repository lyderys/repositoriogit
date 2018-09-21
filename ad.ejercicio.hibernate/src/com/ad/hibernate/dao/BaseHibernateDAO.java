package com.ad.hibernate.dao;
import org.hibernate.Session;
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	/* (non-Javadoc)
	 * @see com.ad.hibernate.dao.IBaseHibernateDAO#getSession()
	 */
	@Override
	public Session getSession() {
		return (Session) HibernateUtil.getSessionFactory();
	}
}
