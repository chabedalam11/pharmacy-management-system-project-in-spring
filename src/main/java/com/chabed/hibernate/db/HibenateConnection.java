package com.chabed.hibernate.db;

import org.hibernate.Session;

import com.chabed.hibernate.pojo.UserRoles;
import com.chabed.hibernate.pojo.Users;
import com.chabed.hibernate.util.NewHibernateUtil;

public class HibenateConnection {
	public static Session session;
	
	
	public HibenateConnection() {
		super();
	}
	public HibenateConnection(String s) {
		if(s.equals("open")){
			HibenateConnection.session = NewHibernateUtil.getSessionFactory().openSession();
			System.out.println("session is created");
		}else if(s.equals("close")){
			HibenateConnection.session.close();
			System.out.println("session is close");
		}
		
	}
}
