package com.to21.torun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.to21.torun.vo.webVo;
import com.to21.torun.webDao.webDao;

@Controller
public class WebController {
	
	@Autowired
	webDao webDao;
	
	private webVo vo;
	
    @RequestMapping("/")
    public String jspcheck(Model model, webVo vo) {
        String time = webDao.time();
        vo.setBoard_init_date(time);
        model.addAttribute("vo",vo);
        return "index";
    }
}
