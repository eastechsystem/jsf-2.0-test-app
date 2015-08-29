package com.qr.dao.contact.Imp;

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

public class ContactDaoImpl {

	private SessionFactory factory=null;
	private Session session=null;
	private Transaction transaction=null;
	private Contact contact=null;
	private int id;
	
	public ContactDaoImpl() {
		factory=HibernateUtil.getSessionFactory();
		session=factory.openSession();
	}


	public int saveContact(Contact contact)
	{
		session = factory.openSession();
		try 
		{
			transaction=session. beginTransaction();
			id=(Integer)session. save(contact);
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
	
	public boolean deleteContact(int id)
	{
		boolean isDelete=false;
		session = factory.openSession();
		try
		{
			transaction = session.beginTransaction();
			contact = (Contact)session.get(Contact.class, id); 
			session.delete(contact); 
			transaction.commit();
			isDelete=true;
		}catch (HibernateException ex) 
		{
			if (transaction!=null) transaction.rollback();
			throw ex;
		}finally
		{
			session.close(); 
		}
		return isDelete;
	}
	
	public boolean updateContact(int id, String firstName, String lastName, 
			String email, String gender, String phoneNumber, 
			boolean status)
	{
		session = factory.openSession();
		boolean isUpdate=false;
		try{
			transaction = session.beginTransaction();
			contact = (Contact)session.get(Contact.class, id); 
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setEmail(email);
			contact.setGender(gender);
			contact.setPhoneNumber(phoneNumber);
			contact.setStatus(status);
			session.update(contact); 
			transaction.commit();
			isUpdate=true;
		}catch (HibernateException e)
		{
			if (transaction!=null) transaction.rollback();
			throw e;
		}finally 
		{
			session.close(); 
		}
		return isUpdate;
	}
	
	
	//****************************** Using Criteria **********************//
	
	public ArrayList<Contact> getAllContacts() {
		session=factory.openSession();
		ArrayList<Contact> contactList=new ArrayList<Contact>();
		try {
			transaction=session.beginTransaction();
			Criteria cr=session.createCriteria(Contact.class);

			List result=cr.list();
			for(Iterator iterator=result.iterator(); iterator.hasNext();) 
			{
				Contact contact=(Contact) iterator.next();
				//System.out.println(account);
				contactList.add(contact);
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
		return contactList;
	}
	//********************************* Using HQL *****************************//
	public ArrayList<Contact> getContacts()
	{
		session=factory.openSession();
		
		ArrayList<Contact> contactList=new ArrayList<Contact>();
		try 
		{
			transaction=session.beginTransaction();
			List result=session.createQuery("FROM Account").list();
			for(Iterator iterator=result.iterator(); iterator.hasNext();) 
			{
				Contact contact=(Contact) iterator.next();
				//System.out.println(account);
				contactList.add(contact);
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
		return contactList;
	}
	
}
