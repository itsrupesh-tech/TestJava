package com.mkyong;

import java.util.Date;

import org.hibernate.Session;

import com.mkyong.user.DBUser;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");	
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		

		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(100);
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());
	

		session.save(user);
		session.getTransaction().commit();
	}
}