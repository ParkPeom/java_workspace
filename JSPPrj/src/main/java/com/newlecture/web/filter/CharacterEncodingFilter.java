package com.newlecture.web.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // ���� ������̼����� �ѹ��� �ذ� ���� 

public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request,
		ServletResponse response,
		FilterChain chain)
		throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");// ��û�� ���� ����� 
		
		chain.doFilter(request, response); // ��û�� ���� �帧�� �Ѱܼ� ���� ���� ���ͽ���(���������� ����)  
		// ����  ���� ���� ����ǰ� ���� ����� 
	}
}
