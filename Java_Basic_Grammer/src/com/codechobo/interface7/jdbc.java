package com.codechobo.interface7;


// 학생 관리 클래스가 반드시 상속 받아야 되는 인터페이스
// => 상속 받은 자식 클래스에서 메서드 작성 규칙을 제공
public interface jdbc {

	void insert();

	void update();

	void delete();

	void select();

}