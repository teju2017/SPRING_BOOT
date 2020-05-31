package com.example.tejas.SpringBootLearning.pojo;

public class Experience {
	
	private int experience;
	private String technology;
	
	
	
	public Experience(int experience, String technology) {
		super();
		this.experience = experience;
		this.technology = technology;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	

}
