package com.sisi.reimbursement.controller;

import com.sisi.reimbursement.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value="/", method= RequestMethod.GET)
	private String home(Model model) {
		model.addAttribute("home", true);
		return "landing-page";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/admin")
	public String admin(Model model){
		model.addAttribute("home", true);
		return "home";
	}
	@RequestMapping("/staff")
	public String staff(Model model){
		model.addAttribute("home", true);
		return "home";
	}
}
