package com.qr.service.account;

import java.util.List;

import javax.ejb.Remote;

import com.qr.model.account.Account;

@Remote
public interface AccountServiceRemote {
	int saveAccount(Account account);

	boolean deleteAccount(int id);
	
	List<Account> getAllAccounts();
}
