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
		ServletContext application = request.getServletContext(); // 어플리케이션 저장소

		HttpSession session = request.getSession(); 	
		
		// 쿠기읽기
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0; // 값을 입력하지 않으면 
		
		// 빈문자열이 오지 않아야 함 
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		// 계산 
		if(op.equals("=")) {  // 계산하는 것   
			
			// 어플리케이션 값을 꺼내는 작업 
			// int x = (Integer)application.getAttribute("value");// 어플리케이션 앞에서 저장한 값
			// int x = (Integer)session.getAttribute("value");
		
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;//찾았으면 나옴 
				}
			}
			
			int y = v; // 지금 사용자가 저장한 value 값 
			// String operator = (String)application.getAttribute("op");
//			String operator = (String)session.getAttribute("op");
			int result = 0;
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;//찾았으면 나옴 
				}
			}
			
			if(operator.equals("+")) 
				result = x + y;
			
			else  
				result = x - y;
			
			// = 이후 결과가 출력됨  application 값을 꺼내서 
			response.getWriter().printf("result is %d\n", result);
		}
		
		// = 이 아닌 덧셈이나 뺄셈이면  값을 저장 
		else {
//		application.setAttribute("value", v); // 키 , 값을 넣는다. 
//		application.setAttribute("op", op);
			//session.setAttribute("value", v); // 키 , 값을 넣는다. 
			// session.setAttribute("op", op);
			Cookie valueCookie = new Cookie("value" ,String.valueOf(v));
			Cookie opCookie = new Cookie("op" ,op);
			// 쿠키값 설정 경로 
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(1000); // 만료날짜 1000초 브라우저닫혀도 정상적으로 쿠기값 저장
			opCookie.setPath("/calc2");
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");// 다른 페이지로 전환
		}
	}
}
