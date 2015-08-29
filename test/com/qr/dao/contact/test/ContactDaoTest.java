package com.qr.dao.contact.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qr.dao.account.Imp.AccountDaoImp;
import com.qr.dao.contact.Imp.ContactDaoImpl;
import com.qr.model.account.Account;
import com.qr.model.contact.Address;
import com.qr.model.contact.Contact;

public class ContactDaoTest {

	private ContactDaoImpl contactDao;
	private Contact contact;
	private Address address;
	private Account account;
	private int id;
	
	@Before
	public void initialize() {
		System.out.println("Run @Before"); // for illustration
		contact=new Contact();
		contactDao=new ContactDaoImpl();
		address=new Address();
		account=new Account();
	}
	
	@Test
	public void testgetAllAcounts() {
		Assert.assertEquals(false, this.getAllContacts());
	}
	
	@Test
	public void testUpdateContact() {
		Assert.assertEquals(true, this.updateContact());
	}
	
	
	@Test
	public void testDeleteContact() {
		Assert.assertEquals(true, this.deleteContact());
	}
	
	
	@Test
	public void testSaveContact() {
		this.saveContact();
		Assert.assertEquals(this.getId(), contact.getId());
	}
	

	
	@After
	public void destroy() {
		System.out.println("Run @Aftere"); // for illustration
		address=null;
		contact=null;
		contactDao=null;
		account=null;
	}

	//**************************** Class private Methods **********************//
	
	
	private void saveContact() 
	{
		this.saveAddress();
		this.saveAccount();
		contact.setFirstName("jahanzaib");
		contact.setLastName("Ali");
		contact.setEmail("jali@globalrescue.com");
		contact.setGender("Male");
		contact.setPhoneNumber("123456789");
		contact.setStatus(true);
		contact.setAccount(account);
		contact.setAddress(address);
		
		int contact_id=0;
		try {
			contact_id=contactDao.saveContact(contact);
			this.setId(contact_id);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	
	
	private boolean deleteContact() {
		this.setId(38);
		return contactDao.deleteContact(this.getId());
	}
	
	private boolean updateContact() {
		return contactDao.updateContact(36, "Umar", "Shahid", "umar_spy@gmail.com", "Male", "1234567890", true);
	}
	
	
	private void saveAddress() 
	{
		address.setCity("Rawalpindi");
		address.setCountry("Pakistan");
		address.setProvince("Punjab");
		address.setState("PAK");
	}
	
	private void saveAccount() 
	{
		account.setAccountName("Current Account");
		account.setEmailDomain("jahanzaib@gamil.com");
		account.setTimeZoneCity("Islamabad/Pak+GMT");
		int account_id=new AccountDaoImp().saveAccount(account);
		System.err.println(account_id);
//		this.setId(account_id);
	}
	
	
	
	
	private boolean getAllContacts() {
		
//		for(int i=0; i<contactDao.getAllContacts().size(); i++) {
//			System.out.println("ID :"+contactDao.getAllContacts().get(i).getId()+"  "+contactDao.getAllContacts().get(i));
//		}
		
		boolean isContact=false;
		if(contactDao.getAllContacts().isEmpty()) {
			isContact=true;
		}
		return isContact;
	}
	

	
	private void setId(int id) {
		this.id=id;
	}
	
	private int getId() {
		return id;
	}
	
}
