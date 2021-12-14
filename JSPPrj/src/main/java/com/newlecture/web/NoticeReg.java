package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 3.0 부터 어노테이션을 이용한 URL 매핑 web.xml 가서 불필요한 설정 안해도됨 
@WebServlet("/notice-reg")

public class NoticeReg extends HttpServlet{
	// 서비스함수 오버라이딩
	// edge : html로 해석
	// chrom : text로 해석 
	// 한글이 꺠지는 이유 
	// 클라이언트 보내는 단위 ISO-8859 인코딩 방식 1바이트로 쪼개서 보내서 ?로 나옴
	// 2바이트씩 묶어서 보내려면 인코딩 방식 UTF-8 로 보내서 EUC-KR 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); // 2바이트씩 묶어서 보내려면 인코딩 방식 UTF-8 로 보낸다.
	    response.setContentType("text/html; charset=UTF-8"); // html문서를 브라우저는 UTF-8로 읽어라 - 개발자 도구 네트워크 - 응답해더에 
		//request.setCharacterEncoding("UTF-8"); // 입력값을 UTF-8로 읽어들임  -> 필터에서 적용시킴 
	    
		PrintWriter out = response.getWriter();
		
		// html에서 보낸걸 응답 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 받은걸 돌려준다
		out.println(title);
		out.println(content);
	}
}
