package com.to21.torun.webDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.to21.torun.vo.commentVo;
import com.to21.torun.vo.webVo;

@Mapper
public interface webDao {
	
	public String time();

	public void insertBoard(webVo vo);

	public List<Map<String, String>> boardList();

	public Map<String, String> selectBoard(String board_seq);

	public void updateBoard(webVo webVo);

	public void updateViews(webVo webVo);

	public void delViews(webVo webVo);

	public List<Map<String, String>> selectComment(String board_seq);

	public void insertComment(commentVo vo);

}
