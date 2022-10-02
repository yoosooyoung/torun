package com.to21.torun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to21.torun.vo.memberVo;
import com.to21.torun.webDao.memberDao;

@Service
public class memberServiceImpl implements memberService {
	
	@Autowired
	memberDao memberDao;
	
	@Override
	public void insertMember(memberVo vo) {
		memberDao.insertMember(vo);
	}
	
	@Override
	public memberVo memberLogin(memberVo vo) {
		return memberDao.memberLogin(vo);
	}
}
