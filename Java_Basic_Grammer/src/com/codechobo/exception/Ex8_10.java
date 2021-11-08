package com.codechobo.exception;

import java.io.File;

class Ex8_10 {
	public static void main(String[] args) {
		try {
			File f = createFile("");
			System.out.println( f.getName()+"파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage()+" 다시 입력해 주시기 바랍니다.");
		}
	}	// main메서드의 끝

	static File createFile(String fileName) { // throws Exception {
	try {	
		if (fileName==null || fileName.equals(""))
			throw new Exception("파일이름이 유효하지 않습니다.");
		}
		catch(Exception e) {
			fileName = "제목없음";
	}
		File f = new File(fileName);		//  File클래스의 객체를 만든다.
     	
		// File객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
//		f.createNewFile(); // 클릭하면 Quick fix 기능을 이용해서 이클립스가 자동으로 예외를 처리해주는 코드 삽입 
		return f;		// 생성된 객체의 참조를 반환한다.
	}	// createFile메서드의 끝
}	// 클래스의 끝
