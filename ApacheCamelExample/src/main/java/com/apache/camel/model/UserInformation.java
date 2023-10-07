package com.apache.camel.model;

import java.util.Objects;

import org.springframework.stereotype.Component;


@Component
public class UserInformation {
	
	private String firstName;
	private String lastName;
	private String origanization;
	private String fullName;
	
	public UserInformation()
	{
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOriganization() {
		return origanization;
	}

	public void setOriganization(String origanization) {
		this.origanization = origanization;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, fullName, lastName, origanization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInformation other = (UserInformation) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(origanization, other.origanization);
	}

	

	
	
	

}
