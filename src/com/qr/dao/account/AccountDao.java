package com.qr.dao.account;

import java.util.List;

import com.qr.model.account.Account;

public interface AccountDao {

	int saveAccount(Account account);

	boolean deleteAccount(int id);

	List<Account> getAllAccounts();
}
