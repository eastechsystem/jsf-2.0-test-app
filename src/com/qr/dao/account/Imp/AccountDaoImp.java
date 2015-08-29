package com.qr.dao.account.Imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.qr.common.dao.AbstractHibernateDao;
import com.qr.dao.account.AccountDao;
import com.qr.model.account.Account;

public class AccountDaoImp extends AbstractHibernateDao implements AccountDao {

	@Override
	public int saveAccount(Account account) {
		Session session = getSession();
		try {
			int id = (Integer) session.save(account);
			return id;
		} catch (HibernateException ex) {
			throw ex;
		} finally {
			closeSession(session);
		}
	}

	@Override
	public boolean deleteAccount(int id) {
		boolean isDelete = false;
		
		Session session = getSession();
		try {
			Account account = (Account) session.get(Account.class, id);
			session.delete(account);
			isDelete = true;
		} catch (HibernateException ex) {
			throw ex;
		} finally {
			closeSession(session);
		}
		
		return isDelete;
	}

	@Override
	public List<Account> getAllAccounts() {
		Session session = getSession();
		try {
			Criteria criteria = session.createCriteria(Account.class);
			List<Account> accounts = criteria.list();
			return accounts;
		} catch (HibernateException ex) {
			throw ex;
		} finally {
			closeSession(session);
		}
	}
}
