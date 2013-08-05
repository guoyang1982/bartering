package com.gy.barter.dao;

import com.gy.barter.model.Users;

public interface UsersDao {

	void saveUser(Users user);
	
	Users getUser(String user_name);
	
}
