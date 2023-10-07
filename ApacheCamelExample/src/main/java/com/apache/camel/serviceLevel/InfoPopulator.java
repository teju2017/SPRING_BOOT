package com.apache.camel.serviceLevel;

import java.awt.desktop.UserSessionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apache.camel.model.UserInformation;

@Component
public class InfoPopulator {
	
	@Autowired
	private UserInformation information;
	
	private static List<UserInformation> userList;
	
	private static int listSize;
	
	public InfoPopulator()
	{
		this.userList = new ArrayList<>();
	}
	
	
	
	public static void validateList()
	{
		if(userList.size() == 0)
		{
			populate();
			listSize=userList.size();
		}
	}
	
	
	
	public static void populate()
	{
		
		UserInformation inf= new UserInformation();
		inf.setFirstName("Tejas");
		inf.setLastName("HM");
		inf.setFullName(inf.getFirstName()+"  "+inf.getLastName());
		inf.setOriganization("UBS");
		UserInformation info = new UserInformation();
		info.setFirstName("Avyukth");
	    info.setLastName("Tejas");
	    info.setFullName(info.getFirstName()+"  "+info.getLastName());
		info.setOriganization("ABCD");
		UserInformation inform = new UserInformation();
		inform.setFirstName("Sheetal");
		inform.setLastName("Tejas");
		inform.setFullName(inform.getFirstName()+"  "+inform.getLastName());
		inform.setOriganization("PCCW");
		userList.add(inf);
		userList.add(info);
		userList.add(inform);
		
	}
	
	public List<UserInformation> getListOfUsers()
	{
		return userList;
	}
	
	
	  public UserInformation basedOnFirstName(String userName) {
		  
		  Optional<UserInformation> userInformation=userList.stream()
		                                           .filter(obj -> obj.getFirstName().equalsIgnoreCase(userName))
		                                           .findFirst();
		  if(userInformation.isPresent())
		  {
			  return userInformation.get();
		  }
		  return new UserInformation();
		           
		          
	  
	  }
	  
public String deleteBasedOnFirstName(String userName) {
		  
		  Optional<UserInformation> userInformation=userList.stream()
		                                           .filter(obj -> obj.getFirstName().equalsIgnoreCase(userName))
		                                           .findFirst();
		  
		  if(userInformation.isPresent())
		  {
			  userList.remove(userInformation.get());
			  return "Deletion Successful";
		  }
		  
		  return "No element deleted";
	  
	  }

public String getSomeInformationforCamel()
{
	return "Getting some information";
}
	 
}
