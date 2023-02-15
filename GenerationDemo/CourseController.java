package com.generationApp.springboot.demogeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.generationApp.springboot.demogeneration.model.UserGeneration;
import com.generationApp.springboot.demogeneration.repo.UserGenerationRepo;

@Controller
public class CourseController {
	
	@Autowired
	UserGenerationRepo repo;
	@Autowired
	private UserGenerationService generation;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	// this method saves user birth year and generation into database using repo object 
	//@RequestMapping("/addUserDetails")
	public void addUserDetails(UserGeneration usg) {
		
		int year = usg.getUser_year();
		String result = generation.getGeneration(year);
		usg.setUser_year(year);
		usg.setResult(result);
		repo.save(usg);
				
	}
	
	// this method stores user birth year and generation in modelview object and prints them on results page
	@RequestMapping("/getUserGeneration")
	public ModelAndView  getUserGeneration(UserGeneration  usg) {
		
		addUserDetails(usg);
		ModelAndView mv = new ModelAndView();
		System.out.println("generation "+usg.getResult());
		mv.addObject("usg", usg);
		mv.setViewName("results");
		return mv;
	}
	
}
