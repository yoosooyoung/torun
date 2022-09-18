package com.to21.torun.service;

import java.util.List;
import java.util.Map;

import com.to21.torun.vo.commentVo;
import com.to21.torun.vo.webVo;

public interface webService {

	public String time();

	public void insertBoard(webVo vo);

	public List<Map<String, String>> boardList();

	public Map<String, String> selectBoard(String board_seq);

	public void updateBoard(webVo vo);

	public void updateViews(String board_seq);

	public void delBoard(String board_seq);

	public List<Map<String, String>> selectComment(String board_seq);

	public void insertComment(commentVo vo);

	public void delComment(String board_seq);

}
