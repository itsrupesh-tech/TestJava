package com.mkyong.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration(); cfg.configure();
			  cfg.setProperty("hibernate.connection.password", "rupesh");
			 cfg.setProperty("hibernate.connection.username", "RUPESH_123"); 
			 cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
			 SessionFactory sessionFactory = cfg.buildSessionFactory(); 
			 return sessionFactory;
			//return new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
	/*
	 * public static SessionFactory changeConfiguration(String login, String
	 * password){ Configuration cfg = new Configuration(); cfg.configure();
	 * cfg.setProperty("hibernate.connection.password", password);
	 * cfg.setProperty("hibernate.connection.username", login); SessionFactory
	 * sessionFactory = cfg.buildSessionFactory(); return sessionFactory; }
	 */

}