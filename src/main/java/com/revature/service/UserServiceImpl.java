package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Service;

import com.revature.model.User;

import com.revature.repository.UserRepository;

@Service
//@Component
public class UserServiceImpl {
	
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<User> getAllUsers() {
    	return ur.findAll();
    }
	
	
//	@Autowired
//	private RevatureFeignClient feignClient;

	private UserRepository ur;

//	@GetMapping("/create")
//	public String bulkcreate(){
//	// save a single Customer
//	repository.save(new UserBean(1, "Rajesh", "Bhojwani"));
//	return "Customers are created";
//	}
	
	
	
	public UserRepository getRepository() {
		return ur;
	}

	@Autowired
	public void setRepository(UserRepository ur) {
		this.ur = ur;
	}
	
	

}