package com.gy.barter.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gy.barter.dao.UsersDao;
import com.gy.barter.model.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao{

	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(user);

	}

	@Override
	public Users getUser(String user_name) {
		// TODO Auto-generated method stub
		
		 String sql = "from Users u where u.user_name = '"+user_name+"'";
		 
		 Users user = (Users)getHibernateTemplate().find(sql).get(0);
		 
		return user;
	}
	
	
	@Override
	public Users getUser(String user_name,String user_pass) {
		// TODO Auto-generated method stub
		
		 String sql = "from Users u where u.user_name = '"+user_name+"' and u.user_passpowder = '"+user_pass+"'";
		 
		 Users user = (Users)getHibernateTemplate().find(sql).get(0);
		 
		return user;
	}
	
}
