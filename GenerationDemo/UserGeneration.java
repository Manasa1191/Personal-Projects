package com.generationApp.springboot.demogeneration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
//this class contains getters and setters for user related data fields
@Entity
public class UserGeneration {
	@Id
	private int user_year;
	private String result;
	

	public int getUser_year() {
		return user_year;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setUser_year(int user_year) {
		this.user_year = user_year;
	}

	@Override
	public String toString() {
		return " [user_year=" + user_year + ", result= " + result + "] ";
	}

	

	
	
	
}
