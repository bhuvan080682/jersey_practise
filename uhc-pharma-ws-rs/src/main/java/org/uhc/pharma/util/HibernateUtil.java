package org.uhc.pharma.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static HibernateUtil instance = new  HibernateUtil();
	private static SessionFactory sessionFactory;
	
	private HibernateUtil(){
		this.sessionFactory = buildSessionFactory();
	}
	
	private synchronized static SessionFactory buildSessionFactory(){
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static HibernateUtil getInstance(){
		if(instance == null){
			return new HibernateUtil();
		}
		return instance;
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	

}
