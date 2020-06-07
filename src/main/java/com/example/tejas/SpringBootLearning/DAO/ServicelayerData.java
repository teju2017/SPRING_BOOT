package com.example.tejas.SpringBootLearning.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicelayerData {
	
	
	@Autowired
	private BillionarieInter bill;
	
	public void checkvalue(Object obj)
	{
		if(bill == null)
		{
			System.out.println("Null value, dependency failed");
			
		}
		else
		{
			Billionaire billto=(Billionaire)obj;
			bill.save(billto);
		}
	}
	

}
