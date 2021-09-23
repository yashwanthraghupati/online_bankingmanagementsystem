package com.example.demo.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginService;


@Controller
public class LoginController {
	
	public static String uname;
	@Autowired
	LoginService loginService;
	
	//@Autowired
	//Mailservice mailService;
	
	@RequestMapping("/login")
	public String loginMessage(){
		return "login";
	}

	@RequestMapping("/validatelogin")
	public String dashboard(@RequestParam String username,@RequestParam String password,
			ModelMap model)throws MessagingException, IOException{
		model.put("username",username);
		uname=username;
		if (loginService.isValid(username,password)) {
			System.out.println("Valid");
			//mailService.sendEmail();
			System.out.println("Valid MAIL");
			
			return "home";
		}
		return "login";
	}
	
	@RequestMapping("/logina")
	public String loginMessagea(){
		return "logina";
	}
	@RequestMapping("/validatelogina")
	public String dashboards(@RequestParam String username,@RequestParam String password,
			ModelMap model)throws MessagingException, IOException{
		model.put("username",username);
		uname=username;
		if (loginService.isValid(username,password)) {
			System.out.println("Valid");
			//mailService.sendEmail();
			System.out.println("Valid MAIL");
			
			return "home-admin";
		}
		return "login";
	}
}

