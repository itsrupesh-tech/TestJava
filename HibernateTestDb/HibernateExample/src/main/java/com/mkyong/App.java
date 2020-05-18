package com.mkyong;

import java.util.Date;

import org.hibernate.Session;

//import com.mkyong.user.DBUser;
import com.mkyong.user.DBUser1;
import com.mkyong.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		System.out.println("hi");	
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		

		session.beginTransaction();
		DBUser1 user = new DBUser1();

		user.setUserId(985);
		user.setUsername("superman");
		user.setCreatedBy("sy4stem");
		user.setCreatedDate(new Date());
	

		session.save(user);
		session.getTransaction().commit();
	}
}