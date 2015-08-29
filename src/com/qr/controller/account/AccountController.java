package com.qr.controller.account;

import java.util.List;

import com.qr.common.controller.AbstractController;
import com.qr.common.service.ServiceManager;
import com.qr.model.account.Account;
import com.qr.service.account.AccountServiceRemote;

public class AccountController extends AbstractController {

	private AccountBean getAccountBean() {
		return (AccountBean) getControllerObject("accountBean", AccountBean.class);
	}
	
	protected AccountServiceRemote getAccountService() {
		return (AccountServiceRemote) ServiceManager.getService(AccountServiceRemote.class);
	}
	
	public void saveAccount() {
		AccountBean accountBean = getAccountBean();
		Account account = accountBean.getAccount();
		
		account.setAccountName("Global Rescue");
		account.setEmailDomain("globalrescue.com");
		account.setTimeZoneCity("Boston/United States");
		
		int accountId = getAccountService().saveAccount(account);
		
		System.out.println("Saved AccountId: " + accountId);
	}
	
	public void loadAllAccounts() {
		AccountBean accountBean = getAccountBean();
		
		List<Account> accounts = getAccountService().getAllAccounts();
		
		if(accounts != null) {
			accountBean.setAccounts(accounts);
			System.out.println("Total Accounts: " + accounts.size());
		}
	}
	
}
