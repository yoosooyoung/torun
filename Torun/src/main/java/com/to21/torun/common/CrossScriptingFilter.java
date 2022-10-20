package com.to21.torun.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CrossScriptingFilter implements Filter {
 
    private Object filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
        this.setFilterConfig(filterConfig);
    }
 
    public void destroy() {
        this.setFilterConfig(null);
    }
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
 
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
 
    }

	public Object getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(Object filterConfig) {
		this.filterConfig = filterConfig;
	}
 
}
