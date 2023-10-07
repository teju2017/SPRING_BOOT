package com.apache.camel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apache.camel.model.UserInformation;
import com.apache.camel.serviceLevel.InfoPopulator;

@RestController
@RequestMapping("/")
public class BaseController {
	
	@Autowired
	private InfoPopulator populator;

	
	@GetMapping("/getInfo")
	public ResponseEntity<List<UserInformation>> usersList()
	{
		
		InfoPopulator.validateList();
		return new ResponseEntity<List<UserInformation>>(populator.getListOfUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/getInfo/{firstName}")
	public ResponseEntity<UserInformation> userFinder(@PathVariable("firstName") String name )
	{
		InfoPopulator.validateList();
		return new ResponseEntity<UserInformation>(populator.basedOnFirstName(name), HttpStatus.OK);
	}
	
	@GetMapping("/delete/{firstName}")
	public ResponseEntity<String> deleteEntry(@PathVariable("firstName") String name )
	{
		
		return new ResponseEntity<String>(populator.deleteBasedOnFirstName(name), HttpStatus.OK);
	}
}
