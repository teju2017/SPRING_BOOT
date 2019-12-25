package com.example.tejas.SpringBootLearning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRestApi {
	
	@GetMapping("/")
	public String workingok()
	{
		return "Workig ok";
	}
	
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

}
