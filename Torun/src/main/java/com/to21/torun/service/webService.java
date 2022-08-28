package com.to21.torun.service;

import java.util.List;
import java.util.Map;

import com.to21.torun.vo.webVo;

public interface webService {

	public String time();

	public void insertBoard(webVo vo);

	public List<Map<String, String>> boardList();


}
