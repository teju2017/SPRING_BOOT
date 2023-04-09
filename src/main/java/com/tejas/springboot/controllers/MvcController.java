package com.tejas.springboot.controllers;

import java.security.Principal;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;

@Controller
public class MvcController {
	
	
	@RequestMapping("/")
	public String firstPage()
	{
		return "abc";
	}
	
	@RequestMapping("/home")
	public String revertBack()
	{
		return firstPage();
	}
	
	@RequestMapping("/user")
	public String userPage()
	{
		return "user";
	}
	
	@RequestMapping("/extendedUser")
	public String extendedUser()
	{
		return "extUser";
	}
	
	@RequestMapping("/admin")
	public String adminPage()
	{
		return "admin";
	}
	
	@RequestMapping("/testFreemarker")
	public String testJsp()
	{
		return "test";
	}

}
