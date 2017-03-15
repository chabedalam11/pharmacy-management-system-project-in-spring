package com.chabed.hibernate.dao;



import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

import com.chabed.hibernate.db.HibenateConnection;
import com.chabed.hibernate.pojo.T30004;


public class T30004DAO extends HibenateConnection{
	private static Logger log = Logger.getLogger(T30004DAO.class);
	
	public boolean saveGenericCode(T30004 t30004){
		try{
			session.save(t30004);
			session.beginTransaction().commit();
			log.info("generic code Save");
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}
	}
	
	public String findMaxGenericCode(){
		Criteria criteria = session
			    .createCriteria(T30004.class)
			    .setProjection(Projections.max("TGenCode"));
			String maxGenericCode =(String) criteria.uniqueResult();
		return maxGenericCode;
	}
	
	/*public static void main(String[] args) {
		T30004 t = new T30004("101");
		new T30004DAO().createUser(t);
	}*/
}
