package com.example.tejas.SpringBootLearning.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Billionaire {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="first_name",nullable=false)
	private String fname;
	
	@Column(name="last_name",nullable=false)
	private String lname;
	
	@Column(name="career", nullable=false)
	private String career;
	
	
	public Billionaire()
	{
		
	}
	

	public Billionaire(String fname, String lname, String career) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.career = career;
	}
	

	public Billionaire(long id, String fname, String lname, String career) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.career = career;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}
	
	
	
	

	

}
