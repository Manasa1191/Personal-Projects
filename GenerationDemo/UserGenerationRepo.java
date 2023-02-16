package com.generationApp.springboot.demogeneration.repo;

import org.springframework.data.repository.CrudRepository;

import com.generationApp.springboot.demogeneration.model.UserGeneration;

public interface UserGenerationRepo extends CrudRepository<UserGeneration,Integer>{

	//void save(String result);

}
