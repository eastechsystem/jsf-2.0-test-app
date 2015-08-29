/**
 * 
 */
package com.qr.model.contact;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.qr.model.account.Account;

/**
 * @author jali
 *
 */
public class Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName=null;
	private String lastName=null;
	private String email=null;
	private String gender=null;
	private String phoneNumber=null;
	private boolean status=false;	//************* Status For Active or not Active ***************//
	
	/********
	 * ******@oneToMany  is use Lazy loading which recommended maximum
	 * ****** 			 flexibility to define the relation in your domain
	*********/
	private Account account;
	private Address address;
	
	
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
		account=new Account();
		address=new Address();
	}
	
	
	
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}



	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}



	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  address.toString()+" Contact [ firstName= "+this.getFirstName()+", lastName= "+
						this.getLastName()+", emailAddress= "+ this.email +
						", gender= " + this.gender + ", Phone Number=  " + 
						this.phoneNumber + ", Status= " + this.status + "]";
	}
		
}
