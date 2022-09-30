package com.to21.torun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.to21.torun.service.memberService;
import com.to21.torun.vo.memberVo;

@Controller
public class MemberController {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
    @Autowired
    private memberService memberSvc;
    
    @Autowired
    private PasswordEncoder pwEncoder;
    
    /**
     * 회원가입 화면
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/signup")
    public String signUp() {
    	
        return "/member/signup";
    }
    
    /**
     * 회원가입 체크
     * @param model
     * @param vo
     * @return
     */
    @PostMapping("/signup/check")
    public String signUpCheck(Model model, memberVo vo) {
    	
    	//패스워드암호화진행
    	vo.setUser_pw(pwEncoder.encode(vo.getUser_pw()));
    	//https://myeongdev.tistory.com/m/29 참고
    	
        return "/member/signup";
    }
}
