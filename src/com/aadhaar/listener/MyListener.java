package com.aadhaar.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;

import com.hibernateresources.HibernateUtility;

public class MyListener implements ServletContextListener {

	private static ServletContext cnt=null;
	 Session session = null;
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		// TODO Auto-generated method stub
		if(null!=session)
			session.close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		// TODO Auto-generated method stub
		try{
			cnt = arg.getServletContext();
			session = HibernateUtility.getSessionFactory().openSession();
			
		}
		catch(Exception ex){
			System.out.println("Exception in MyListener Class");
			ex.printStackTrace();
		}
	}
	public static ServletContext getApplicationCntx(){
		return cnt; 
	}

}
