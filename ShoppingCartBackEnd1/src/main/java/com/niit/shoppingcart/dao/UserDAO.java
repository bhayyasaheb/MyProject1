package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.User;

public interface UserDAO {

	// declare the methods
	// what type of operation you are going to do user
	// declare the methods with proper signature
	// access_ specifier return_type method-name(parameter_list) throws
	// exception_list

	// operations

	// 1)create /register -save
	public boolean save(User user);

	// 2) update the user details -update
	public boolean update(User user);

	// 3) validate the credentials -validate
	// we are going to use spring security in future
	// we can delete this method after using spring security
	public boolean validate(String id, String password);

	// 4) get all the users -list
	public List<User> list();

	// 5) get user details based on userId
	public User getUser(String id);

}
