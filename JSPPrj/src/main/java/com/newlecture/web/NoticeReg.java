package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 3.0 ���� ������̼��� �̿��� URL ���� web.xml ���� ���ʿ��� ���� ���ص��� 
@WebServlet("/notice-reg")

public class NoticeReg extends HttpServlet{
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
		//request.setCharacterEncoding("UTF-8"); // �Է°��� UTF-8�� �о����  -> ���Ϳ��� �����Ŵ 
	    
		PrintWriter out = response.getWriter();
		
		// html���� ������ ���� 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// ������ �����ش�
		out.println(title);
		out.println(content);
	}
}
