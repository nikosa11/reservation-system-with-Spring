package com.mysql.Services;

import java.util.Optional;

import com.mysql.domain.User;

public interface UserService {
	Iterable<User> getByLastname(String lastname);

	Iterable<User> getAllUsers();
	Optional<User> getById(long id);
	String addNewUser(User user);
	String deleteAllUsers();
	String deleteById(long id);

}
