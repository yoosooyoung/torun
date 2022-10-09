package com.to21.torun.common;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonCodes {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	//쿠키를 세팅한다.
	public static Boolean setCookies(Cookie[] cookies, 
			                         String seq, 
			                         String cookieName, 
			                         HttpServletResponse response) throws Exception {
    	
		Boolean isCookie = false;
		int visitor = 0;
		
    	for(Cookie cookie : cookies) {
    		if(cookie.getName().equals(cookieName)) {
    			visitor = 1;
    			//쿠키이름에 글번호가 있다면 패스
    			if(cookie.getValue().contains(seq)) {
    			
    			//쿠키이름에 글번호가 없다면 글번호를 추가함
    			}else {
    				cookie.setValue(cookie.getValue()+"_"+seq);
    				setCookieOption(cookie);
    				response.addCookie(cookie);
    				isCookie = true;
    			}
    		}
    	}
    	
    	//쿠키가없다면 넣어준다.
    	if(visitor == 0) {
    		Cookie cookie1 = new Cookie(cookieName, seq);
    		setCookieOption(cookie1);
			response.addCookie(cookie1);
			isCookie = true;
    	}
    	
    	return isCookie;
    	
    }

	//쿠키설정
	private static void setCookieOption(Cookie cookie) {
		cookie.setMaxAge(60*60*24);
	}
}









