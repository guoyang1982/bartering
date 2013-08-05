package com.gy.barter.service;

import java.util.List;

import com.gy.barter.model.Citys;
import com.gy.barter.model.Users;
import com.gy.barter.vo.ThingsVO;
import com.gy.barter.vo.UserVO;

public interface PublishService {

	List<Citys> getTowCateById(String id);

	String getCategoryJson(List<Citys> citys,String id);
	
	void saveThings(ThingsVO thingsVO,String images,String street,Long userId);
	
	Users saveUsers(UserVO userVO);

	
}
