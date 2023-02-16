package com.generationApp.springboot.demogeneration;

import org.springframework.stereotype.Service;

import com.generationApp.springboot.demogeneration.model.UserGeneration;
//this class has code that generates results for the application
@Service
public class UserGenerationService {

	private String user_generation;
	public String getGeneration(int user_year) {
		
		user_generation = " ";
		if(1964<=user_year && user_year>=1946) {
			user_generation ="User Generation : Baby Boomers";
		}
		else if(1980<=user_year && user_year>=1965) {
			user_generation ="User Generation : GenX";
		}
		else if(1996<=user_year && user_year>=1981) {
			user_generation ="User Generation : Millenials";
		}
		else if(2012<=user_year && user_year>=1997) {
			user_generation ="User Generation : GenZ";
		}
		else {
			System.out.println("Not a valid input");
		}
		
		return user_generation;
	}
	
}
