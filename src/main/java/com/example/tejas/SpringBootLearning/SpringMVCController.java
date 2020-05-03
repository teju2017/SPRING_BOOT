package com.example.tejas.SpringBootLearning;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringMVCController {
	
	  @GetMapping("/")
	    public String mainmethod(Model model) 
	  {
		    //String country= new String("Singapore");
		    String tasks="working";
	        // model.addAttribute("country", country);
		    model.addAttribute("theDate", new Date());
	        model.addAttribute("tasks", tasks);

	        return "hello"; //view
	    }
	  
	  
	  
	    @GetMapping("/error")
	     public String errorpage(Model model) 
	    {
		  @SuppressWarnings("unused")
		String errors="SOME ERROR IN DISPLAYING THE PAGE AND HENCE GETTING THIS ERROR";
		  model.addAttribute("tejas",new String("SOME ERROR IN DISPLAYING THE PAGE AND HENCE GETTING THIS ERROR"));
          return "error"; //view
	    }
	    
	    
	    @GetMapping("/errorPage")
	     public String errorpage1(Model model) 
	    {
		  @SuppressWarnings("unused")
		String errors="SOME ERROR IN DISPLAYING THE PAGE AND HENCE GETTING THIS ERROR";
		  //model.addAttribute("ERRORS", new String("SOME ERROR IN DISPLAYING THE PAGE AND HENCE GETTING THIS ERROR"));
		  // model.addAttribute("ERRORS",errors);
		  // model.addAttribute("tejas",errors);
		  model.addAttribute("tejas",new String("SOME ERROR IN DISPLAYING THE PAGE AND HENCE GETTING THIS ERROR"));
		 //  System.out.println("Model value is "+model.toString());
         return "error"; //view
	    }
	  
	

}
