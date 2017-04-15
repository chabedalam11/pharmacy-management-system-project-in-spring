package com.chabed.spring.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	public static List<T30004> t30004;
	
	
	//request for testing page Page
		@RequestMapping("/adminIndex")
		public String indexPage(Principal principal,Model model) {
			log.info("call testion page");
			
			//get user name from principal
			String loggedInUserName=principal.getName();
			
			// creating session if necessary 
			if(ProgramSession.sesssionControll==0){
				new HibenateConnection("open");
				ProgramSession.sesssionControll++;
			}
			
			if(t30004 == null){
				log.info("collect table t30004");
				t30004 = new T30004DAO().getT30004FullTable();
			}
			
			
			model.addAttribute("t30004", t30004);
			
			model.addAttribute("userName", loggedInUserName);
			return "index";
		}
	
		//request for T30006ManufactureCode page Page
				@RequestMapping("/adminT30006ManuFacCodeIniti")
				public String t30006ManufactureCode(Principal principal,Model model) {
					log.info("call testion page");
					
					//get user name from principal
					String loggedInUserName=principal.getName();
					
					// creating session if necessary 
					if(ProgramSession.sesssionControll==0){
						new HibenateConnection("open");
						ProgramSession.sesssionControll++;
					}
					
					if(t30004 == null){
						log.info("collect table t30004");
						t30004 = new T30004DAO().getT30004FullTable();
					}
					
					
					model.addAttribute("t30004", t30004);
					
					model.addAttribute("userName", loggedInUserName);
					return "T30006_Manufacture_Code_Initialization";
				}
		
	
	//request for GenericCodeIni Page
	@RequestMapping("/adminT30004GenCodeIniti")
	public String hello2(Principal principal,Model model) {
		log.info("call T30004_Generic_Code_Initialization page");
		
		//get user name from principal
		String loggedInUserName=principal.getName();
		
		// creating session if necessary 
		if(ProgramSession.sesssionControll==0){
			new HibenateConnection("open");
			ProgramSession.sesssionControll++;
		}
		
		if(t30004 == null){
			log.info("collect table t30004");
			t30004 = new T30004DAO().getT30004FullTable();
		}
		
		
		model.addAttribute("t30004", t30004);
		
		model.addAttribute("userName", loggedInUserName);
		return "T30004_Generic_Code_Initialization";
	}
	
	
	
	@RequestMapping("/saveGenericCode")
	public String saveGenericCode(Principal principal,@ModelAttribute("t30004") T30004 t30004,Model model) {
		log.info("call saveGenericCode method");
		
		//get user name from principal
		String loggedInUserName=principal.getName();
		
		if(t30004.getTActiveFlag()==null){
			t30004.setTActiveFlag("0");
		}
		
		log.info("Generic Name > "+t30004.getTLang2Nam());
		log.info("Active > "+t30004.getTActiveFlag());
		log.info("User Name > "+ loggedInUserName);
		
		//set T30004 table value
		t30004.setTEntryUser(loggedInUserName);
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    t30004.setTEntryDate(sqlDate);
	    
		log.info("table value > "+new T30004DAO().findMaxGenericCode());
		int tableGenMaxValue = Integer.parseInt(new T30004DAO().findMaxGenericCode());
		int netGenCode=tableGenMaxValue+1;
		t30004.setTGenCode(Integer.toString(netGenCode));
		
		t30004.setTLang2Nam(t30004.getTLang2Nam().toUpperCase());
		//now save generic code
		if(new T30004DAO().saveGenericCode(t30004)){
			log.info("collect table t30004 after save");
			T30004GenCodeInitiController.t30004 = new T30004DAO().getT30004FullTable();
			model.addAttribute("t30004", T30004GenCodeInitiController.t30004);
			model.addAttribute("userName", loggedInUserName);
			return "T30004_Generic_Code_Initialization";
		}else{
			log.info("passing old table t30004 after save");
			model.addAttribute("t30004", T30004GenCodeInitiController.t30004);
			model.addAttribute("userName", loggedInUserName);
			return "T30004_Generic_Code_Initialization";
		}
		
	}
	
	
	@RequestMapping("/updateGenericCode")
	public String updateGenericCode(Principal principal,@ModelAttribute("t30004") T30004 t30004,Model model) {
		log.info("call updateGenericCode method");
		
		//get user name from principal
		String loggedInUserName = principal.getName();
		
		if(t30004.getTActiveFlag()==null){
			t30004.setTActiveFlag("0");
		}
		
		log.info("Generic Code > "+t30004.getTGenCode());
		log.info("Generic Name > "+t30004.getTLang2Nam());
		log.info("Active > "+t30004.getTActiveFlag());
		log.info("User Name > "+ loggedInUserName);
		
		T30004 newT30004 = new T30004();
		//set T30004 table value
		
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    
	    newT30004.setTUpdUser(loggedInUserName);
	    newT30004.setTUpdDate(sqlDate);
	    newT30004.setTGenCode(t30004.getTGenCode());
	    newT30004.setTLang2Nam(t30004.getTLang2Nam().toUpperCase());
	    newT30004.setTActiveFlag(t30004.getTActiveFlag());
		
		//now update generic code
		if(new T30004DAO().updateGenericCode(newT30004)){
			log.info("collect table t30004 after update");
			T30004GenCodeInitiController.t30004 = new T30004DAO().getT30004FullTable();
			model.addAttribute("t30004", T30004GenCodeInitiController.t30004);
			model.addAttribute("userName", loggedInUserName);
			model.addAttribute("MSG", "UPDATE SUCCESSFULL");
			return "T30004_Generic_Code_Initialization";
		}else{
			log.info("passing old table t30004 because update not complete");
			model.addAttribute("t30004", T30004GenCodeInitiController.t30004);
			model.addAttribute("MSG", "UPDATE NOT SUCCESSFULL");
			model.addAttribute("userName", loggedInUserName);
			return "T30004_Generic_Code_Initialization";
		}
		
	}
	
	
	@RequestMapping("/deleteGenericCode")
	public String deleteGenericCode(Principal principal,@ModelAttribute("t30004") T30004 t30004,Model model) {
		log.info("call deleteGenericCode method");
		
		//get user name from principal
		String loggedInUserName=principal.getName();
		
		
		
		log.info("Generic CODE FOR DELETE > "+t30004.getTGenCode());
		
		
		
		//now delete generic code
		if(new T30004DAO().deleteGenericCode(t30004)){
			log.info("collect table t30004 after delete");
			T30004GenCodeInitiController.t30004 = new T30004DAO().getT30004FullTable();
			model.addAttribute("t30004", T30004GenCodeInitiController.t30004);
			model.addAttribute("userName", loggedInUserName);
			return "T30004_Generic_Code_Initialization";
		}else{
			log.info("passing old table t30004 because delete not complete");
			model.addAttribute("t30004", T30004GenCodeInitiController.t30004);
			model.addAttribute("userName", loggedInUserName);
			return "T30004_Generic_Code_Initialization";
		}
		
	}
}
