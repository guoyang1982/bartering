package com.gy.barter.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gy.barter.dao.ThingsDao;
import com.gy.barter.model.Things;

public class ThingsDaoImpl extends HibernateDaoSupport implements ThingsDao {

	@Override
	public void saveThing(Things thing) {
		// TODO Auto-generated method stub

		getHibernateTemplate().save(thing);
		
	}

}
