package com.example.tejas.SpringBootLearning.pojo;

public class BilliondataInput {
	
	private String fname;
	private String lname;
	private String Career;
	
	
	
	
	public BilliondataInput(String fname, String lname, String career) {
		super();
		this.fname = fname;
		this.lname = lname;
		Career = career;
	}
	
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCareer() {
		return Career;
	}
	public void setCareer(String career) {
		Career = career;
	}
	
	

}
