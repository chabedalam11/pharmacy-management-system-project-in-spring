package com.chabed.hibernate.db;

import org.hibernate.Session;

import com.chabed.hibernate.pojo.Users;
import com.chabed.hibernate.util.NewHibernateUtil;

public class DatabaseCommunication {
	public static void main(String[] args) {
		Users users = new Users("test 2", "test 2");
		Session s = NewHibernateUtil.getSessionFactory().openSession();
		s.save(users);
		s.beginTransaction().commit();
		s.close();
		System.out.println("done");
		
	}
}
