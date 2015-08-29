package com.qr.dao.address.Imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qr.common.dao.HibernateUtil;
import com.qr.model.account.Account;
import com.qr.model.contact.Address;
import com.qr.model.contact.Contact;

public class AddressDaoImp {

	private SessionFactory factory=null;
	private Session session=null;
	private Transaction transaction=null;
	private Address address=null;
	private int id;
	
	
	public AddressDaoImp() {
		factory=HibernateUtil.getSessionFactory();
		session=factory.openSession();
	}


	public int saveAddress(Address address)
	{
		session = factory.openSession();
		try 
		{
			transaction=session. beginTransaction();
			id=(Integer)session. save(address);
			transaction. commit();
		}catch(HibernateException ex) 
		{
			if(transaction != null)transaction. rollback();
			throw ex;
		}finally 
		{
			session.close();		
		}
		return id;
	}
	
	public void deleteAddress(int id)
	{
		session = factory.openSession();
		try
		{
			transaction = session.beginTransaction();
			address = (Address)session.get(Address.class, id); 
			session.delete(address); 
			transaction.commit();
		}catch (HibernateException ex) 
		{
			if (transaction!=null) transaction.rollback();
			throw ex;
		}finally
		{
			session.close(); 
		}
	}
	
	public Address updateAddress(int id, String city, String state, String province, String country)
	{
		session = factory.openSession();
		try{
			transaction = session.beginTransaction();
			address = (Address)session.get(Address.class, id); 
			address.setCity(city);
			address.setCountry(country);
			address.setProvince(province);
			address.setState(state);
			session.update(address); 
			transaction.commit();
		}catch (HibernateException e)
		{
			if (transaction!=null) transaction.rollback();
			throw e;
		}finally 
		{
			session.close(); 
		}
		return address;
	}
	
	
	//****************************** Using Criteria **********************//
	
	public ArrayList<Address> getAllAddresses() {
		session=factory.openSession();
		ArrayList<Address> addressList=new ArrayList<Address>();
		try {
			transaction=session.beginTransaction();
			Criteria cr=session.createCriteria(Address.class);

			List result=cr.list();
			for(Iterator iterator=result.iterator(); iterator.hasNext();) 
			{
				Address address=(Address) iterator.next();
				//System.out.println(account);
				addressList.add(address);
			}
			transaction.commit();
		}catch(HibernateException ex) 
		{
			if (transaction!=null) transaction.rollback();
			ex.printStackTrace();
		}finally 
		{
			session.close(); 
		}
		return addressList;
	}
	//********************************* Using HQL *****************************//
	public ArrayList<Address> getAddresses()
	{
		session=factory.openSession();
		
		ArrayList<Address> addressList=new ArrayList<Address>();
		try 
		{
			transaction=session.beginTransaction();
			List result=session.createQuery("FROM Account").list();
			for(Iterator iterator=result.iterator(); iterator.hasNext();) 
			{
				Address address=(Address) iterator.next();
				//System.out.println(account);
				addressList.add(address);
				//System.out.println(emp);
			}
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			if(transaction!=null) transaction.rollback();
			ex.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return addressList;
	}

}
