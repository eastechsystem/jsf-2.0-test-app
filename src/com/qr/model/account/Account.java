/**
 * 
 */
package com.qr.model.account;

import java.io.Serializable;

/**
 * @author jali
 *
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String timeZoneCity;
	private String accountName;
	private String emailDomain;
	private int id;
	
	public Account() {
	}

	public String getTimeZoneCity() {
		return timeZoneCity;
	}

	public void setTimeZoneCity(String timeZoneCity) {
		this.timeZoneCity = timeZoneCity;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Account [ accountName= "+this.getAccountName()+", emailDomain= "+this.getEmailDomain()+", timeZoneCity= "+this.getTimeZoneCity()+" ]";
	}
	
	
}
