package com.chabed.hibernate.dao;



import org.hibernate.Session;


import com.chabed.hibernate.pojo.UserRoles;
import com.chabed.hibernate.pojo.Users;
import com.chabed.hibernate.util.NewHibernateUtil;


public class UserDAO{
		public String createUser(Users users){
			try{
				Session session = NewHibernateUtil.getSessionFactory().openSession();
				session.save(users);
				session.beginTransaction().commit();
				UserRoles ur = new UserRoles(users, "ROLE_ADMIN");
				session.save(ur);
				session.beginTransaction().commit();
				session.close();
				System.out.println("Congratulations !! new user is successfully created");
				return "Congratulations !! new user is successfully created";
			}catch(Exception e){
				System.out.println(e);
				return e.getMessage();
			}
			
			
		}
}
