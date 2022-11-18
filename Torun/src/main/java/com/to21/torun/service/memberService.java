package com.to21.torun.service;

import com.to21.torun.vo.memberVo;

public interface memberService {

	void insertMember(memberVo vo);

	memberVo memberLogin(memberVo member);

	int checkId(memberVo vo);

}
