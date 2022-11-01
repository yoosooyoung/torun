package com.to21.torun.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to21.torun.common.Pagination;
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
	@Override
	public List<Map<String, String>> boardList(Pagination pagination) throws Exception {
		return webDao.boardList(pagination);
	}
	@Override
	public int boardListCount() throws Exception {
		return webDao.boardListCount();
	}
	
	@Override
	public void insertLikeBoard(Map<String, String> params) throws Exception {
		webDao.insertLikeBoard(params);
	}
	
	@Override
	public int likeCount(Map<String, String> params) throws Exception {
		return webDao.likeCount(params);
	}
	
	@Override
	public void deleteLikeBoard(Map<String, String> params) throws Exception {
		webDao.deleteLikeBoard(params);
	}
}
