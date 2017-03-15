
package com.chabed.spring.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chabed.hibernate.dao.UserDAO;
import com.chabed.hibernate.db.HibenateConnection;
import com.chabed.hibernate.pojo.Users;
import com.chabed.spring.other.ProgramSession;


@Controller
public class LoginOutController {
	
	

	/*@RequestMapping("/helloworld")
	public ModelAndView hello(ModelMap model,Principal principal) {
		System.out.println("call hello page");

		String loggedInUserName=principal.getName();
		
		return new ModelAndView("hello", "userName", loggedInUserName);
	}*/
	
	
	
	@RequestMapping("/admin")
	public ModelAndView helloAdmin(Principal principal) {
		System.out.println("call admin page");
		String loggedInUserName=principal.getName();
		
		// creating session if necessary 
		if(ProgramSession.sesssionControll==0){
			new HibenateConnection("open");
			ProgramSession.sesssionControll++;
		}
		
		return new ModelAndView("adminIndex", "userName", loggedInUserName);
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("call login page");
		return "login";

	}
	
	@RequestMapping(value="/signUP", method = RequestMethod.POST)
	public String signUP(@ModelAttribute("users") Users users, Model model) {
		System.out.println("call signUP page");
		System.out.println("user name = "+users.getUsername());
		System.out.println("password = "+users.getPassword());
		System.out.println("enable = "+users.getEnabled());
		model.addAttribute("msg", new UserDAO().createUser(users));
		return "login";

	}

	@RequestMapping(value="/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		System.out.println("call login page for error");
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model) {
		System.out.println("call login out method");
		//model.addAttribute("error", "true");
		new HibenateConnection("close");
		ProgramSession.sesssionControll=0;
		return "login";
	}
	
	// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied(Principal user) {
			System.out.println("call 403 page");
			ModelAndView model = new ModelAndView();
			if (user != null) {
				model.addObject("msg", "Hi " + user.getName()
				+ ", You can not access this page!");
			} else {
				model.addObject("msg",
				"You can not access this page!");
			}

			model.setViewName("403");
			return model;
		}
		
		
		
}

