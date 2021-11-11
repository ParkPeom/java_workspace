package com.codechobo.io;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
	}
	
	public void start() {
		//RandomAccessFile객체는 읽기전용("r"), 쓰기전용("w", 읽기 쓰기("rw") 가능 설정이 가능하다. 
		//원하는 위치로 이동하여 읽기 쓰기가 가능하다.
		
		try {
			File f = new File("c://javaFile","randomAccess.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String txt = "012345678901234567890\n";
			String txt2 = "java programing random access test";
			//문자를 쓰기
			raf.writeBytes(txt);
			raf.writeBytes(txt2);
			
			//point이동
			raf.seek(5); 
			raf.writeBytes("ABCD"); // 01234ABCD901234567890
			
			raf.seek(12);
			raf.write("자바".getBytes());  // 한글일시 Char로 했는데 2,3,4,5 4바이트잡음.. ??로뜸...
			
			////////////////////////////////
			byte[] b = new byte[4]; // 4자리씩 읽어서
			raf.seek(12);
			int cnt = raf.read(b, 0, b.length);// 몇글자가 읽혀졌는지 리턴

//			int cnt = raf.read(b,0,b.length);// 사이즈를 정해줘서 읽어오기 
			System.out.println(cnt + "-->" + new String(b));
			
			raf.seek(24);
			raf.writeInt(123);
			
			raf.seek(24);
			System.out.println(raf.readInt());
			
			System.out.println("실행완료");
		} catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new RandomAccessFileTest().start();
	}
}
