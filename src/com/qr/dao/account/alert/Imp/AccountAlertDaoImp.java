package com.qr.dao.account.alert.Imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qr.common.dao.HibernateUtil;
import com.qr.model.account.Account;
import com.qr.model.account.alert.AlertProfile;

public class AccountAlertDaoImp {

	private SessionFactory factory=null;
	private Session session=null;
	private Transaction transaction=null;
	private int id;
	private AlertProfile alertProfile;
	
	public AccountAlertDaoImp() {
		super();
		factory=HibernateUtil.getSessionFactory();
		session=factory.openSession();
	}
	
	public int saveAlertProfile(AlertProfile alertProfile)
	{
		session = factory.openSession();
		try 
		{
			transaction=session.beginTransaction();
			id=(Integer)session.save(alertProfile);
			transaction. commit();
//			System.out.println("Deleted Account");
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
	
	public boolean deleteAlertProfile(int id)
	{
		boolean isDelete=false;
		session = factory.openSession();
		try
		{
			transaction = session.beginTransaction();
			alertProfile = (AlertProfile)session.get(AlertProfile.class, id); 
			session.delete(alertProfile); 
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
	
	public boolean updateAlertProfile(AlertProfile alertProfile)
	{
		boolean isUpdate=false;
		session = factory.openSession();
		try{
			transaction = session.beginTransaction();
			this.alertProfile = (AlertProfile)session.get(AlertProfile.class, alertProfile.getId()); 
			this.alertProfile.setName(alertProfile.getName());
			this.alertProfile.setCity(alertProfile.getCity());
			this.alertProfile.setCountry(alertProfile.getCountry());
			this.alertProfile.setAccount(alertProfile.getAccount());
			session.update(this.alertProfile); 
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
	
	public ArrayList<AlertProfile> getAllAlertProfile() {
		session=factory.openSession();
		ArrayList<AlertProfile> alertProfileList=new ArrayList<AlertProfile>();
		try {
			transaction=session.beginTransaction();
			Criteria cr=session.createCriteria(AlertProfile.class);

			List result=cr.list();
			for(Iterator iterator=result.iterator(); iterator.hasNext();) 
			{
				AlertProfile alertProfile=(AlertProfile) iterator.next();
				//System.out.println(account);
				alertProfileList.add(alertProfile);
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
		return alertProfileList;
	}
	//********************************* Using HQL *****************************//
	public ArrayList<AlertProfile> getAlertProfiles()
	{
		session=factory.openSession();
		
		ArrayList<AlertProfile> alertProfileList=new ArrayList<AlertProfile>();
		try 
		{
			transaction=session.beginTransaction();
			List result=session.createQuery("FROM Account").list();
			for(Iterator iterator=result.iterator(); iterator.hasNext();) 
			{
				AlertProfile alertProfile=(AlertProfile) iterator.next();
				//System.out.println(account);
				alertProfileList.add(alertProfile);
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
		return alertProfileList;
	}

	
}
