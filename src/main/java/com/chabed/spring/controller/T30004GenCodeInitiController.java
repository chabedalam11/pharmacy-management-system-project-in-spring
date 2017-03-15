package com.chabed.spring.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chabed.hibernate.dao.T30004DAO;
import com.chabed.hibernate.db.HibenateConnection;
import com.chabed.hibernate.pojo.T30004;
import com.chabed.spring.other.ProgramSession;

@Controller
public class T30004GenCodeInitiController {
	
	private static Logger log = Logger.getLogger(T30004GenCodeInitiController.class);
	
	//request for GenericCodeIni Page
	@RequestMapping("/adminT30004GenCodeIniti")
	public ModelAndView hello2(Principal principal) {
		log.info("call T30004_Generic_Code_Initialization page");
		
		//get user name from principal
		String loggedInUserName=principal.getName();
		
		// creating session if necessary 
		if(ProgramSession.sesssionControll==0){
			new HibenateConnection("open");
			ProgramSession.sesssionControll++;
		}
		
		return new ModelAndView("T30004_Generic_Code_Initialization", "userName", loggedInUserName);
	}
	
	@RequestMapping("/saveGenericCode")
	public ModelAndView saveGenericCode(Principal principal,@ModelAttribute("t30004") T30004 t30004) {
		log.info("call saveGenericCode method");
		
		if(t30004.getTActiveFlag()==null){
			t30004.setTActiveFlag("0");
		}
		
		log.info("Generic Name > "+t30004.getTLang2Nam());
		log.info("Active > "+t30004.getTActiveFlag());
		log.info("User Name > "+ principal.getName());
		
		//set T30004 table value
		t30004.setTEntryUser(principal.getName());
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    t30004.setTEntryDate(sqlDate);
	    
		log.info("table value > "+new T30004DAO().findMaxGenericCode());
		int tableGenMaxValue = Integer.parseInt(new T30004DAO().findMaxGenericCode());
		int netGenCode=tableGenMaxValue+1;
		t30004.setTGenCode(Integer.toString(netGenCode));
		
		//now save generic code
		if(new T30004DAO().saveGenericCode(t30004)){
			
		}
		
		
		//get user name from principal
		String loggedInUserName=principal.getName();
		return new ModelAndView("T30004_Generic_Code_Initialization", "userName", loggedInUserName);
	}
}
