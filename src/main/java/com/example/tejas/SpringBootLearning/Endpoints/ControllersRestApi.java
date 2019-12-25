package com.example.tejas.SpringBootLearning.Endpoints;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllersRestApi {
	
	@Value("${sports.name}")
	public String sports;
	
	@GetMapping("/checkTime")
	public String work()
	{
		return "Current time in Singapore is "+LocalTime.now();
	}
	
	
	@GetMapping("/Sports")
	public String sports()
	{
		return "Sport played in the weekend is "+sports;
	}

}
