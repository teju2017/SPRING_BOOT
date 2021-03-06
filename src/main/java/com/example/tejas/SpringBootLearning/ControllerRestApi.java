package com.example.tejas.SpringBootLearning;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRestApi {
	
	
	/*
	 * Getmapping for the RESTCONTROLLER API, no view section
	 */

	
	@GetMapping("/springboot/show")
	public String show()
	{
		return " Creating the show method";
	}
	
	@GetMapping("/springboot/showtime")
	public String showtime()
	{
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		String abcd  = formatter.format(date);
		return "Current time is "+abcd;
		
	}
	
	@GetMapping("/springboot/showyear")
	public String showyear()
	{
		return " this year is 2020";
	}
	
	@GetMapping("/springboot/sparksql")
	public String sparksql()
	{
		return "this is a spark-SQLscxcxczczczx";
	}
	
	/* a new addition on May 3rd 2020 */
	
	
	@GetMapping("/springboot/unexpected")
	public String pandemic()
	{
		return "COVID-19 is a pandemic";
	}
	
	


}
