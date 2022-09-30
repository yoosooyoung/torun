package com.to21.torun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to21.torun.webDao.memberDao;

@Service
public class memberServiceImpl implements memberService {
	
	@Autowired
	memberDao memberDao;
}
