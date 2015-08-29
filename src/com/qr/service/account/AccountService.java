package com.qr.service.account;

import java.util.List;

import javax.ejb.Stateless;

import com.qr.common.dao.DaoManager;
import com.qr.dao.account.AccountDao;
import com.qr.model.account.Account;

@Stateless
public class AccountService implements AccountServiceRemote {

	private AccountDao getAccountDao() {
		return DaoManager.getInstance().getAccountDao();
	}

	@Override
	public int saveAccount(Account account) {
		return getAccountDao().saveAccount(account);
	}

	@Override
	public boolean deleteAccount(int id) {
		return getAccountDao().deleteAccount(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		return getAccountDao().getAllAccounts();
	}
}
