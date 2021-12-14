package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 3.0 ���� ������̼��� �̿��� URL ���� web.xml ���� ���ʿ��� ���� ���ص��� 
@WebServlet("/hi")

public class Nana extends HttpServlet{
	// �����Լ� �������̵�
	// edge : html�� �ؼ�
	// chrom : text�� �ؼ� 
	// �ѱ��� ������ ���� 
	// Ŭ���̾�Ʈ ������ ���� ISO-8859 ���ڵ� ��� 1����Ʈ�� �ɰ��� ������ ?�� ����
	// 2����Ʈ�� ��� �������� ���ڵ� ��� UTF-8 �� ������ EUC-KR 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); // 2����Ʈ�� ��� �������� ���ڵ� ��� UTF-8 �� ������.
		response.setContentType("text/html; charset=UTF-8"); // html������ �������� UTF-8�� �о�� - ������ ���� ��Ʈ��ũ - �����ش��� 
		PrintWriter out = response.getWriter();
		
		// ��ȯ�� �������� �ӽú���
		String cnt_ = request.getParameter("cnt");
		int cnt = 100;
		if(cnt_ != null && !cnt_.equals("")) 
			cnt = Integer.parseInt(cnt_); // cnt ���� �о ���ڿ� �� ���� 
				// ����ڰ� ������ ī��Ʈ����ŭ �����Ѵ�.
		for(int i = 0; i < cnt; i++ ) {
			out.println((i+1) + " : �ȳ� Servlet!!  ~~~ adsf <br> ");
		}
	}
}
