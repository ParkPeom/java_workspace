package com.codechobo.interface7;

// 학생 관리 프로그램 
public class JdbcApp {
	
	public static void main(String[] args) {
		
		/*
		JdbcMysql mysql = new JdbcMysql();
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		*/
		
		// 시스템 교체에 의한 클래스 변경시 프로그램을 대부분을 변경 처리
		// => 클래스 간의 결합도 높아 유지보수의 효율성 감소 
		
		JdbcOracle oracle = new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.remove();
		oracle.search();
		
		// 인터페이스를 이용하여 클래스를 작성할 경우 시스템 교체에 의한 클래스 변경시
		// 프로그램을 일부분만 변경 처리 가능 
		// => 클래스 간의 결합도 낮춰 유지보수의 효율성 증가
		
		jdbc jdbc = new JdbcMysql();
		
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
		
		jdbc jdbc2 = new JdbcOracle();
		
		
	}
}
