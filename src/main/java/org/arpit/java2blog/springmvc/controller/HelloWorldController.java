
package org.arpit.java2blog.springmvc.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	/*@RequestMapping("/helloworld")
	public ModelAndView hello(ModelMap model,Principal principal) {
		System.out.println("call hello page");

		String loggedInUserName=principal.getName();
		
		return new ModelAndView("hello", "userName", loggedInUserName);
	}*/
	
	@RequestMapping("/adminp2")
	public String hello2(ModelMap model,Principal principal) {
		System.out.println("call p2 page");

		return "p2";
	}
	
	@RequestMapping("/admin")
	public ModelAndView helloAdmin(ModelMap model,Principal principal) {
		System.out.println("call admin page");

		String loggedInUserName=principal.getName();
		
		return new ModelAndView("adminIndex", "userName", loggedInUserName);
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("call login page");
		return "login";

	}

	@RequestMapping(value="/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		System.out.println("call login page for error");
		model.addAttribute("error", "true");
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

