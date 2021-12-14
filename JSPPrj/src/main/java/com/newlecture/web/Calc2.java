package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Calc2")

public class Calc2 extends HttpServlet {

	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext(); // ���ø����̼� �����

		HttpSession session = request.getSession(); 	
		
		// ����б�
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0; // ���� �Է����� ������ 
		
		// ���ڿ��� ���� �ʾƾ� �� 
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// ��� 
		if(op.equals("=")) {  // ����ϴ� ��   
			
			// ���ø����̼� ���� ������ �۾� 
			// int x = (Integer)application.getAttribute("value");// ���ø����̼� �տ��� ������ ��
			// int x = (Integer)session.getAttribute("value");
		
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;//ã������ ���� 
				}
			}
			
			int y = v; // ���� ����ڰ� ������ value �� 
			// String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			int result = 0;
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;//ã������ ���� 
				}
			}
			
			if(operator.equals("+")) 
				result = x + y;
			
			else  
				result = x - y;
			
			// = ���� ����� ��µ�  application ���� ������ 
			response.getWriter().printf("result is %d\n", result);
		}
		
		// = �� �ƴ� �����̳� �����̸�  ���� ���� 
		else {
//		application.setAttribute("value", v); // Ű , ���� �ִ´�. 
//		application.setAttribute("op", op);
			//session.setAttribute("value", v); // Ű , ���� �ִ´�. 
			// session.setAttribute("op", op);
			Cookie valueCookie = new Cookie("value" ,String.valueOf(v));
			Cookie opCookie = new Cookie("op" ,op);
			// ��Ű�� ���� ��� 
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(1000); // ���ᳯ¥ 1000�� ������������ ���������� ��Ⱚ ����
			opCookie.setPath("/calc2");
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");// �ٸ� �������� ��ȯ
		}
	}
}
