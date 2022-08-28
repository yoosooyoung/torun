package com.to21.torun.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to21.torun.vo.webVo;
import com.to21.torun.webDao.webDao;
@Service
public class webServiceImpl implements webService {

	@Autowired
	webDao webDao;
	
	
	@Override
	public String time() {
		return webDao.time();
	}

	@Override
	public void insertBoard(webVo vo) {
		webDao.insertBoard(vo);
	}
	
	@Override
	public List<Map<String, String>> boardList() {
		return webDao.boardList();
	}
	
}
