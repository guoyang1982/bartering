package com.gy.barter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gy.barter.dao.UsersDao;
import com.gy.barter.model.Users;
import com.gy.barter.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersDao usersDao;
	
	@Override
	public Users getUser(String user_name) {
		// TODO Auto-generated method stub
		
		Users user = getUser(user_name);
		
		return user;
	}

}
