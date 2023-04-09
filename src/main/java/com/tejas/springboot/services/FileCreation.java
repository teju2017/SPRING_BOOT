package com.tejas.springboot.services;

import java.io.File;

import org.springframework.stereotype.Component;


@Component
public class FileCreation implements FileOperations {

	@Override
	public Boolean createOperation(String name) {
		
      try
      {
    	  File f = new File(name);
    	  if(f.exists())
    	  {
    		  return true;
    	  }
    	  else
    	  {
    		 return f.createNewFile();
    	  }
      }
      catch(Exception ae)
      {
    	  System.out.println("Hitting the new exception "+ae.getMessage());
    	  return false;
      }
		
		
	}

}
