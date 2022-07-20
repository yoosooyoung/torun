package com.to21.torun.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.to21.torun.webDao.webDao;

public class webServiceImpl implements webService {

	@Autowired
	webDao webDao;
	
	@Override
	public String time() {
		return webDao.time();
	}
	
	
}
