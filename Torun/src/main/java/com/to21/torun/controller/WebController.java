package com.to21.torun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.to21.torun.common.CommonCodes;
import com.to21.torun.common.Pagination;
import com.to21.torun.service.webService;
import com.to21.torun.vo.commentVo;
import com.to21.torun.vo.memberVo;
import com.to21.torun.vo.webVo;

@Controller
public class WebController<memberVO> {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Autowired
    private webService webSvc;
	
    /**
     * 메인
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/")
    public String main(Model model, webVo vo) {
    	
        return "index";
    }
    
    /**
     * 리스트
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/board/list")
    public String boardList(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "cntPerPage", required = false, defaultValue = "10") int cntPerPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,   		
            Map<String, Object> map, HttpServletRequest request, webVo vo, Model model) throws Exception {
    	memberVo memberVO = (memberVo)request.getSession().getAttribute("member");
    	int listCnt = webSvc.boardListCount();
    	Pagination pagination = new Pagination(currentPage, cntPerPage, pageSize);
    	pagination.setTotalRecordCount(listCnt);
    	pagination.setUser_id(memberVO.getUser_id());
    	model.addAttribute("pagination", pagination);
    	model.addAttribute("Alllist", webSvc.boardList(pagination));
        return "list";
    }    
    
    /**
     * 수정하기 위해 글쓰기 페이지
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/board/write/{board_seq}")
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
    @GetMapping("/board/write")
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
     * @throws Exception 
     */
    @GetMapping("/board/view/{board_seq}")
    public String boardView(Model model, @PathVariable String board_seq, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
    	
    	Cookie[] cookies = request.getCookies();
    	String CookieName = "seq";
    	
    	//쿠키가 있는지 판단
    	Boolean isCookies = CommonCodes.setCookies(cookies, board_seq, CookieName, response);
    	
    	//해당 게시물에 쿠키가 없으면 조회수를 올린다.
    	if(isCookies) {
	    	webSvc.updateViews(board_seq);
    	}
    	
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
    @RequestMapping(value = "/board/{board_seq}", method = RequestMethod.DELETE)
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
     *뷰페이지 읽기
     * @param model
     * @param vo
     */
    @PostMapping("/board/comment/list")
    @ResponseBody
    public Map<String, Object> commentList(Model model, commentVo vo){
    	Map<String, Object>result = new HashMap<>();
    	String board_seq = vo.getBoard_seq();
    	List<Map<String,String>> selectComment = webSvc.selectComment(board_seq);
    	result.put("selectComment", selectComment);    	
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
    	webSvc.insertComment(vo);	
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
    

    @PostMapping("/board/likeMapp")
    @ResponseBody
    public Map<String, Object> likeBoardMapp(@RequestParam("board_seq") String board_seq, HttpServletRequest request) throws Exception{
    	Map<String, Object> result = new HashMap<>();   	
    	Map<String, String> params = new HashMap<>();
    	
    	//user_id
    	memberVo memberVO = (memberVo)request.getSession().getAttribute("member");
    	params.put("board_seq", board_seq);
    	params.put("user_id", memberVO.getUser_id());
    	
    	int likeCount = webSvc.likeCount(params);
    	
    	if(likeCount == 0) {
    		webSvc.insertLikeBoard(params);
    	}else {
    		webSvc.deleteLikeBoard(params);
    	}
    	return result;
    }
    
    /**
     * 마이페이지
     * @param model
     * @param vo
     * @return
     */
    @GetMapping("/user/mypage/{user_id}")
    public String settingMypage(@PathVariable String user_id) {
    	return "member/mypage";
    }    
    
}
