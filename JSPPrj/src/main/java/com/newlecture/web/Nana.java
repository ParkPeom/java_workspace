package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 3.0 부터 어노테이션을 이용한 URL 매핑 web.xml 가서 불필요한 설정 안해도됨 
@WebServlet("/hi")

public class Nana extends HttpServlet{
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
		PrintWriter out = response.getWriter();
		
		// 변환이 가능한지 임시변수
		String cnt_ = request.getParameter("cnt");
		int cnt = 100;
		if(cnt_ != null && !cnt_.equals("")) 
			cnt = Integer.parseInt(cnt_); // cnt 값을 읽어서 문자열 로 전달 
				// 사용자가 전달한 카운트수만큼 전달한다.
		for(int i = 0; i < cnt; i++ ) {
			out.println((i+1) + " : 안녕 Servlet!!  ~~~ adsf <br> ");
		}
	}
}
