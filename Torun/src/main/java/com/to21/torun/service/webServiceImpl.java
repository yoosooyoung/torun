package com.to21.torun.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to21.torun.vo.commentVo;
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

	@Override
	public Map<String, String> selectBoard(String board_seq) {
		return webDao.selectBoard(board_seq);
	}
	
	@Override
	public void updateBoard(webVo vo) {
		webDao.updateBoard((vo));
	}
	
	@Override
	public void updateViews(String board_seq) {
		webDao.updateViews(board_seq);
	}
	
	@Override
	public void delBoard(String board_seq) {
		webDao.delViews(board_seq);
	}
	
	@Override
	public List<Map<String, String>> selectComment(String board_seq) {
		return webDao.selectComment(board_seq);
	}
	
	@Override
	public void insertComment(commentVo vo) {
		webDao.insertComment(vo);
	}
	
	@Override
	public void delComment(String board_seq) {
		webDao.delComment(board_seq);
	}
}
