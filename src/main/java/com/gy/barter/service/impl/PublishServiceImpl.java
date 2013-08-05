package com.gy.barter.service.impl;

import java.sql.Timestamp
;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gy.barter.dao.CityDao;
import com.gy.barter.dao.ThingsDao;
import com.gy.barter.dao.UsersDao;
import com.gy.barter.model.Citys;
import com.gy.barter.model.Pics;
import com.gy.barter.model.Things;
import com.gy.barter.model.Users;
import com.gy.barter.service.PublishService;
import com.gy.barter.vo.ThingsVO;
import com.gy.barter.vo.UserVO;

@Service
public class PublishServiceImpl implements PublishService{

    @Autowired
    private CityDao cityDao;
    
    @Autowired
    private ThingsDao thingsDao;
    
    @Autowired
    private UsersDao usersDao;
	
	@Override
	public List<Citys> getTowCateById(String id) {
		// TODO Auto-generated method stub
		
		return cityDao.getTowCateById(id);
	}

	@Override
	public String getCategoryJson(List<Citys> citys,String id) {
		// TODO Auto-generated method stub
		
		StringBuffer json =new StringBuffer();
		
		//[{"id":"2","name":"tt","street":[{"id":"121","name":"最最1"},{"id":"12","name":"最最"}]},{"id":"3","name":"tt2","street":[{"id":"1222","name":"最最22"},{"id":"1222","name":"最最22"}]}]
		
		List list = new ArrayList();
		
		//json.append("[");
		for(Citys city:citys){
		//json
			Map map = new HashMap();
			
			map.put("id", city.getId());
			map.put("name", city.getName());
			
			List list2 = new ArrayList();
			
			List<Citys> listT = cityDao.getThreeCateById(id, Long.toString(city.getId()));
			for(Citys c:listT){
				Map map2 = new HashMap();
				map2.put("id", c.getId());
				map2.put("name", c.getName());
				
				list2.add(map2);
			}
			
			map.put("street", list2);
			
			list.add(map);
			
		}
		
		JSONArray jsonArray  = JSONArray.fromObject(list);
		
		//System.out.print(jsonArray);
		
		return jsonArray.toString();
	}

	/**
	 * [{"id":"file_0","imageUrl":"Chrysanthemum.jpg","is_covert":"true"},{"id":"file_1
","imageUrl":"Hydrangeas.jpg","is_covert":"false"}]
	 */
	
	@Override
	public void saveThings(ThingsVO thingsVO,String images,String street,Long userId) {
		// TODO Auto-generated method stub
		
		Things thing = new Things();
		
		Set<Pics> picSet = new HashSet<Pics>();
		
		JSONArray array = JSONArray.fromObject(images);
		
		for(int i =0;i<array.size();i++){
			
        	JSONObject jsonObjo = JSONObject.fromObject(array.getString(i));

        	Pics pic = new Pics();
        	
        	pic.setUrl(jsonObjo.getString("imageUrl"));
        	
        	pic.setIfcover(jsonObjo.getString("is_covert"));
        	
        	System.out.println(jsonObjo.getString("imageUrl"));
        	
        	picSet.add(pic);
			
		}
		
		BeanUtils.copyProperties(thingsVO,thing);
		
		thing.setPicList(picSet);
		
		thing.setCity_id(Long.parseLong(street));
		
		thing.setUser_id(userId);
		
		thing.setCreateTime(new Date());
		
		thingsDao.saveThing(thing);
	}

	@Override
	public Users saveUsers(UserVO userVO) {
		// TODO Auto-generated method stub
		
		Users user = new Users();
		
		BeanUtils.copyProperties(userVO,user);
		
		usersDao.saveUser(user);
		
		return usersDao.getUser(user.getUser_name());
		
	}

	
}
