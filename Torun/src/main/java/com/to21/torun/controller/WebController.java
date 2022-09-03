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
    
    /**
     * 글쓰기 페이지
     * @param model
     * @param vo
     * @return
     */
    @RequestMapping("/write")
    public String write(Model model, webVo vo) {
    	if(vo.getBoard_seq() != null) {
    		Map<String, String>selectBoard = webSvc.selectBoard(vo.getBoard_seq().toString());
    		model.addAttribute("selectBoard", selectBoard);
    	}
        return "write";
    }
        
    
    /**
     * 게시판 글 넣기
     * @param model
     * @param vo
     */
    @RequestMapping("/board/insert")
    @ResponseBody
    public Map<String, String> boardInsert(Model model, webVo vo) {
    	Map<String, String>result = new HashMap<>();
    	webSvc.insertBoard(vo);	
    	result.put("result", "success");    	
    	return result;
    }
    
    /**
     * 뷰페이지
     * @param model
     * @param vo
     */
    @RequestMapping("/board/view")
    public String boardView(Model model, webVo vo) {
    	String board_seq = vo.getBoard_seq();
    	//조회수올리기
    	webSvc.updateViews(vo);
    	Map<String, String>selectBoard = webSvc.selectBoard(board_seq);
    	model.addAttribute("selectBoard", selectBoard);
    	return "view";
    }

    /**
     * 수정
     * @param model
     * @param vo
     */
    @RequestMapping("/board/update")
    @ResponseBody
    public Map<String, String> boardUpdate(Model model, webVo vo) {
    	Map<String, String>result = new HashMap<>();
    	webSvc.updateBoard(vo);
    	result.put("result", "success");    	
    	return result;
    }   
    
    /**
     * 삭제
     * @param model
     * @param vo
     */
    @RequestMapping("/board/delete")
    @ResponseBody
    public Map<String, String> boardDel(Model model, webVo vo) {
    	Map<String, String>result = new HashMap<>();
    	webSvc.delBoard(vo);
    	result.put("result", "success");    	
    	return result;
    }     
    
    
}
