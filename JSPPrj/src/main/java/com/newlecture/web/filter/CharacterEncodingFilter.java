package com.newlecture.web.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // 필터 어노테이션으로 한번에 해결 가능 

public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request,
		ServletResponse response,
		FilterChain chain)
		throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");// 요청이 오면 실행됨 
		
		chain.doFilter(request, response); // 요청이 오면 흐름을 넘겨서 다음 서블릿 필터실행(다음실행을 관할)  
		// 그후  다음 서블릿 실행되고 나서 실행됨 
	}
}
