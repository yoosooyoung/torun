package com.to21.torun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.to21.torun.service.webService;
import com.to21.torun.vo.webVo;

@Controller
public class WebController {

    @Autowired
    private webService webSvc;
	
    @RequestMapping("/")
    public String main(Model model, webVo vo) {
    	List<Map<String,String>> list = webSvc.boardList();
    	model.addAttribute("list", list);
        return "index";
    }
    
    @RequestMapping("/write")
    public String write(Model model, webVo vo) {
        return "write";
    }
        
    
    /**
     * 게시판 글 넣기
     * @param model
     * @param vo
     */
    @RequestMapping("/board/insert")
    @ResponseBody
    public Map<String, String >boardInsert(Model model, webVo vo) {
    	Map<String, String>result = new HashMap<>();
    	webSvc.insertBoard(vo);	
    	result.put("result", "success");    	
    	return result;
    }

    
    
}
