package com.qr.common.dao;

import com.qr.dao.account.AccountDao;
import com.qr.dao.account.Imp.AccountDaoImp;

public class DaoManager {

	private static DaoManager daoManager;
	
	private AccountDao accountDao;
	
	private DaoManager() {
		this.accountDao = new AccountDaoImp();
	}

	public static DaoManager getInstance() {
		if (daoManager == null) {
			daoManager = new DaoManager();
		}

		return daoManager;
	}

	/**
	 * @return the accountDao
	 */
	public AccountDao getAccountDao() {
		return accountDao;
	}

	/**
	 * @param accountDao the accountDao to set
	 */
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
