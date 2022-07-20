package com.to21.torun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.to21.torun.webDao.webDao;

@Controller
public class WebController {
	
	@Autowired
	webDao webDao;
	
    @RequestMapping("/")
    public String jspcheck(Model model) {
        System.out.println("WebController 들어옴");
        String time = webDao.time();
        model.addAttribute("message", time);
        return "index";
    }
}
