package com.to21.torun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.to21.torun.service.webService;
import com.to21.torun.vo.commentVo;
import com.to21.torun.vo.webVo;

@Controller
public class WebController {

    @Autowired
    private webService webSvc;
	
    /**
     * 리스트페이지
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/")
    public String main(Model model, webVo vo) {
    	
    	List<Map<String,String>> list = webSvc.boardList();
    	model.addAttribute("list", list);
        return "index";
    }
    
    /**
     * 수정하기 위해 글쓰기 페이지
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/write/{board_seq}")
    public String ModifyWrite(Model model, @PathVariable String board_seq) {
    	//뷰에서 수정하기 -> 글쓰기 페이지 이동시
    	Map<String, String>selectBoard = webSvc.selectBoard(board_seq);
    	model.addAttribute("selectBoard", selectBoard);
        return "write";
    }
    /**
     * 글쓰기 페이지
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/write")
    public String ModifyWrite(Model model) {
    	return "write";
    }
        
    
    /**
     * 게시판 글 넣기
     * @param model
     * @param vo
     */
    @PostMapping("/board")
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
    @GetMapping("/board/view/{board_seq}")
    public String boardView(Model model, @PathVariable String board_seq) {
    	//조회수올리기
    	webSvc.updateViews(board_seq);
    	Map<String, String> selectBoard = webSvc.selectBoard(board_seq);
    	List<Map<String,String>> selectComment = webSvc.selectComment(board_seq);
    	model.addAttribute("selectBoard", selectBoard);
    	model.addAttribute("selectComment", selectComment);
    	return "view";
    }

    /**
     * 글쓰기 수정
     * @param model
     * @param vo
     */
    @PutMapping("/board")
    @ResponseBody
    public Map<String, String> boardUpdate(Model model, webVo vo) {
    	Map<String, String>result = new HashMap<>();
    	webSvc.updateBoard(vo);
    	result.put("result", "success");    
    	result.put("seq", vo.getBoard_seq().toString());  
    	return result;
    }   
    
    /**
     * 삭제
     * @param model
     * @param vo
     */
    @DeleteMapping("/board/{board_seq}")
    @ResponseBody
    public Map<String, String> boardDel(@PathVariable String board_seq) {
    	Map<String, String>result = new HashMap<>();
    	try {
        	webSvc.delBoard(board_seq);
        	webSvc.delComment(board_seq);
        	result.put("result", "success");  
		} catch (Exception e) {
			result.put("result","fail");
		}
    	return result;
    }    
    
    /**
     * 댓글인서트 && 뷰페이지 읽기
     * @param model
     * @param vo
     */
    @PostMapping("/board/comment/insert")
    @ResponseBody
    public Map<String, Object> commentInsert(Model model, commentVo vo){
    	Map<String, Object>result = new HashMap<>();
    	if(!vo.getWriter().equals("")) {
        	webSvc.insertComment(vo);	
    	}
    	String board_seq = vo.getBoard_seq();
    	List<Map<String,String>> selectComment = webSvc.selectComment(board_seq);
    	result.put("selectComment", selectComment);    	
    	return result;
    }
    
    /**
     * 댓글 읽기
     * @param model
     * @param vo
     */
    @GetMapping("/board/comment/{board_seq}")
    @ResponseBody
    public Map<String, Object> commentView(@PathVariable String board_seq){
    	Map<String, Object>result = new HashMap<>();

    	List<Map<String,String>> selectComment = webSvc.selectComment(board_seq);
    	result.put("selectComment", selectComment);    	
    	return result;
    }    
    
}
