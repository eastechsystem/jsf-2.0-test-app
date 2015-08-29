package com.qr.controller.account;

import java.util.ArrayList;
import java.util.List;

import com.qr.model.account.Account;

public class AccountBean extends AccountController {

	private Account account = new Account();
	private List<Account> accounts = new ArrayList<Account>();

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts
	 *            the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void clear() {
		this.account = new Account();
		this.accounts.clear();
	}

	public void load(Account account) {
		this.account = account;
	}
}
