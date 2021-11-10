package com.codechobo.reallization;

// 이클립스를 이용하여 클래스로 인터페이스를 추출하여 생성하는 방법
// 클래스 >> Refactor >> Extract Interface >> 생성창 >> 인터페이스명 입력 및 메서드 선택 >> OK

// 학생관리 기능을 제공하는 클래스 - mysql
public class JdbcMysql implements jdbc {

	public void insert() {
		System.out.println("[Mysql] 학생 정보를 저장 하였습니다.");
	}
	
	public void update() {
		System.out.println("[Mysql] 학생정보를 변경 하였습니다.");
	}
	
	public void delete() {
		System.out.println("[Mysql] 학생정보를 삭제 하였습니다.");
	}
	
	public void select() {
		System.out.println("[Mysql] 학생 정보를 검색하였습니다.");
	}
}
