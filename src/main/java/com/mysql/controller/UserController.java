package com.mysql.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.mysql.Services.UserServiceIm;
import com.mysql.domain.User;
@Controller
@RequestMapping
public class UserController  implements WebMvcConfigurer {
	
	@Autowired
	private UserServiceIm userService;

	@GetMapping(path="/")
	public String getHome() {
		return "home";
	}
	@GetMapping(path="/search")
	public String getSearch() {
		return "search";
	}
	@PostMapping(path="/search")
	 public @ResponseBody Iterable<User> getLastnameUsers(@Valid String lastname){
		return userService.getByLastname(lastname);
	}
	
	@GetMapping(path="/delete")
	public String getdeleteById() {
		return "delete";
	}
	@PostMapping(path="/delete")
	@ResponseBody Iterable<User> deleteById(@Valid long id) 
	{
		userService.deleteById(id);
		return userService.getAllUsers();
	}
	
	@GetMapping(path="/user")
	public String showForm(User user) {
		return "form";
	}
	@PostMapping(path="/user")
	public String checkPersonInfo(@Valid User user) {

		
		if(!user.invalid()) {
			return "form";
			
		}
		userService.addNewUser(user);
		return "result";
	}
	
	@GetMapping(path="/id")
	public String getByid(){
		return "id";
	}
	@PostMapping(path="/id")
	public  @ResponseBody Optional<User> id(@Valid long id){

		return userService.getById(id);
	}

	
	

	@GetMapping(path="/deleteAll")
	public @ResponseBody String deleteAllUsers() {
		
		return userService.deleteAllUsers();
	}
	
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userService.getAllUsers();
	  }
	
	

}
