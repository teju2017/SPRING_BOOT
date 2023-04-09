package com.tejas.springboot.controllers;

import java.io.File;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.springboot.services.FileOperations;


@RestController
public class SimpleController {
	
	@Autowired
	private FileOperations fileops;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getInitialPage()
	{
		return new ResponseEntity<String>("WELCOME",HttpStatus.OK);
	}
	
	@GetMapping("/working")
	public ResponseEntity<String> getErrorMessage()
	{
		return new ResponseEntity<String>("<html><h1>WORKING PAGE</h1><form action=\"/home\">\r\n"
				+ "	<button>Home</button>\r\n"
				+ "	</form></html>",HttpStatus.OK);
	}
	
	@PutMapping("/createFile")
	public ResponseEntity<Boolean> getCreateFile()
	{
		return new ResponseEntity<Boolean>(fileops.createOperation("Fileabc"),HttpStatus.OK);
	}
	
	

}
