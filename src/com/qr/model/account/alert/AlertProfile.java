package com.qr.model.account.alert;

import java.io.Serializable;

import com.qr.model.account.Account;


public class AlertProfile implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String city;
	private String country;
	private Account account;
	private int id;
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "AlertProfile [ name= "+this.getName()+", city= "+this.getCity()+", country= "+this.getCountry()+" ]";
	}
	
	
}
