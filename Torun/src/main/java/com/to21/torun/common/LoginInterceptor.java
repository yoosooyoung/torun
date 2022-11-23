package com.to21.torun.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	log.info("----------LoginInterceptor----------");
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("member"));
        if (session.getAttribute("member") == null) {
            response.sendRedirect("/signin");
            return false;
        }
        return true;
    }
}