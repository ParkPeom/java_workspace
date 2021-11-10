package com.codechobo.interface7;

// 학생 관리 기능을 제공하는 클래스 - oracle
public class JdbcOracle implements jdbc {
	
	public void add() {
		System.out.println("학생 정보 저장");
	}
	
	public void modify() {
		System.out.println("학생 정보 변경");
	}
	
	public void remove() {
		System.out.println("학생 정보 삭제");
		
	}
	
	public void search() {
		System.out.println("학생 정보 검색");
	}

	// 인터페이스를 상속받으면 오버라이드 다 해줘야 한다.
	
	@Override
	public void insert() {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void delete() {
		
	}

	@Override
	public void select() {
		
	}
}
