package com.to21.torun.webDao;

import org.apache.ibatis.annotations.Mapper;

import com.to21.torun.vo.memberVo;

@Mapper
public interface memberDao {

	void insertMember(memberVo vo);

	memberVo memberLogin(memberVo vo);

}
