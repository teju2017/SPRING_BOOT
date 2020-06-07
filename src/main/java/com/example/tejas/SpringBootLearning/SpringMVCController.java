package com.example.tejas.SpringBootLearning;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tejas.SpringBootLearning.DAO.Billionaire;
import com.example.tejas.SpringBootLearning.DAO.BillionarieInter;
import com.example.tejas.SpringBootLearning.DAO.Checker;
import com.example.tejas.SpringBootLearning.DAO.ServicelayerData;
import com.example.tejas.SpringBootLearning.pojo.BilliondataInput;
import com.example.tejas.SpringBootLearning.pojo.Experience;

@Controller
public class SpringMVCController {
	
	
	//@Autowired
	// private BillionarieInter biliinter;
	
	@Autowired
	private ServicelayerData serv;
	
	
	/*
	 * Below provides the bean for calling the method
	 *  
	 */
	
	@Autowired
	private Checker chk;
	
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
        
        /*
         *  Below get request is an example of associating the values entered in the form to a POJO class
         *  In the Thymeleaf format we have the object obj containing all the form values
         *  This value is mapped to the fields in the Experience class, make sure the name mentioned in
         *  the field of the class should match with the name mentioned in the HTML ( This dependency
         *  injection for the exp class happens via the Spring MVC framework )
         */
        
        @GetMapping("/getinputs")
	    public String getInputs(@ModelAttribute("obj") Experience exp, Model mdt)
	    {
	    	System.out.println("Incoming attribues");
	    	System.out.println("values are "+exp.getExperience()+ "   technology ="+exp.getTechnology());
	    	mdt.addAttribute("experience", exp.getExperience());
	    	mdt.addAttribute("technology", exp.getTechnology());
	    	return "output";
	    }
        
        
        
        @GetMapping("/input_data")
	    public String getdata()
	    {
        	return "bill_data";
	    }
        
        @GetMapping("/insertdata")
        public String insertdata(@ModelAttribute("ins") BilliondataInput bildata,Model mdt)
        {
        	System.out.println("Incoming data values are ="+bildata.getFname()+" "+bildata.getLname()+"  "+bildata.getCareer());
        	Billionaire bilobj = new Billionaire(bildata.getFname(), bildata.getLname(), bildata.getCareer());
        	chk.testvalue();
        	//biliinter.save(bilobj);
            serv.checkvalue(bilobj);
            
        	return "insertiondone";
        	
        }
	    
	  
        
        
	

}
