package com.qr.common.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * The AbstractHibernateDao class handles core database operations.
 * 
 */
public abstract class AbstractHibernateDao {

	private Transaction transaction = null;
	
	public Session getSession() {
		try {
			Session session = HibernateUtil.openSession();
			transaction = session.beginTransaction();
			return session;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void closeSession(Session session) {
		try {
			if (session != null) {
				if(transaction != null) {
					transaction.commit();
				}
				
				HibernateUtil.closeSession(session);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
