package com.example.tejas.SpringBootLearning;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tejas.SpringBootLearning.pojo.Experience;

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
	    
	    @GetMapping("/submissionform")
	    public String submitDetails()
	    {
	    	return "Submission";
	    }
	  
	    
        @GetMapping("/getDetail")
	    public String getDetail(@ModelAttribute("fname") String fname, Model map)
	    {
	    	System.out.println("Fname value is "+fname);
	    	map.addAttribute("fname",fname);
	    	return "hello";
	    }
        
        @GetMapping("/submissionform_1")
	    public String submitDetailsone()
	    {
	    	return "Input_value";
	    }
        
        @GetMapping("/getinputs")
	    public String getInputs(@ModelAttribute("obj") Experience exp, Model mdt)
	    {
	    	System.out.println("Incoming attribues");
	    	System.out.println("values are "+exp.getExperience()+ "   technology ="+exp.getTechnology());
	    	mdt.addAttribute("experience", exp.getExperience());
	    	mdt.addAttribute("technology", exp.getTechnology());
	    	return "output";
	    }
	  
        
        
	

}
