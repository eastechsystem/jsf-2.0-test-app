package com.qr.dao.account.test;



import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qr.dao.account.Imp.AccountDaoImp;
import com.qr.model.account.Account;


public class AccountDaoTest {

	private AccountDaoImp accountDao;
	private Account account;
	private int id;
	
	@Before
	public void initialize() {
		System.out.println("Run @Before"); // for illustration
		account=new Account();
		accountDao=new AccountDaoImp();
	}
	
	
	@Test
	public void testgetAllAcounts() {
		Assert.assertEquals(false, this.getAllacounts());
	}
	
//	@Test(expected=IllegalArgumentException.class)
	@Test
	public void testDeleteAccount() {
		Assert.assertEquals(true, this.deleteAccount());
	}
	

	
	
	
	@Test
	public void testSaveAccount() {
		this.saveAccount();
		Assert.assertEquals(this.getId(), account.getId());
	}
	

	@After
	public void destroy() {
		System.out.println("Run @Aftere"); 
		accountDao=null;
		account=null;
		
	}

	//**************************** Class private Methods **********************//
	
	
	private void saveAccount() 
	{
		account.setAccountName("Current Account");
		account.setEmailDomain("jahanzaib@gamil.com");
		account.setTimeZoneCity("Islamabad/Pak+GMT");
		this.setId(accountDao.saveAccount(account));
	}
	
	
	private boolean deleteAccount(){
		this.setId(3);
		return accountDao.deleteAccount(this.getId());
	}

	
	private boolean getAllacounts() {
		
//		for(int i=0; i<accountDao.getAllAccounts().size(); i++) {
//			System.out.println("ID :"+accountDao.getAccounts().get(i).getId()+"  "+accountDao.getAccounts().get(i));
//		}
		
		boolean isAccounts=false;
		if(accountDao.getAllAccounts().isEmpty()) {
			isAccounts=true;
		}
		return isAccounts;
	}
	
	private void setId(int id) {
		this.id=id;
	}
	
	private int getId() {
		return id;
	}
}
