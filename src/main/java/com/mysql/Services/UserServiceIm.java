package com.mysql.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.domain.User;
import com.mysql.repository.UserReposritory;

@Service
public class UserServiceIm implements UserService{
	@Autowired
	private UserReposritory userRepository;
	

	@Override
	public Iterable<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public String addNewUser(User user) {
		userRepository.save(user);
		return "Saved";
	}

	@Override
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "All users deleted";
	}

	@Override
	public String deleteById(long id) {
		userRepository.deleteById(id);
		return null;
	}

	@Override
	public Iterable<User> getByLastname(String lastname) {
		Iterable<User> users=new ArrayList<User>();
		ArrayList<User> lastnameUsers=new ArrayList<User>();
		users=userRepository.findAll();
		for(User use :users) {
			if (use.getLastname().equals(lastname)) {
				lastnameUsers.add(use);
			}
			
			
		}
		return lastnameUsers;
	}

	

}
