package com.codechobo.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		
	}
	public void start() {
		try { 
			//기본데이터형 값을 각 데이터형의 크기만큼 공간으로 확보하여 값1개를 저장하는 방법
			// DataOutputStream 객체
			File f = new File("c://javaFile/DataObject.txt");
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
		
			boolean boo = true;
			int numInt = -5628758;
			double db1 = 5235.2654;
			char c = '홍';
			
			dos.writeBoolean(boo);
			dos.writeInt(numInt);
			dos.writeDouble(db1);
			dos.writeChar(c);
			dos.close();
			
			//데이터형 크기마큼 파일에서 정보 읽어오기
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			
			boolean inBoo = dis.readBoolean();
			int inNum = dis.readInt();
			double inDb1 = dis.readDouble();
			char inChar = dis.readChar();
			
			System.out.println(inBoo);
			System.out.println(inNum);
			System.out.println(inDb1);
			System.out.println(inChar);
			
		} catch(Exception e)	{
			e.printStackTrace();
		}
		System.out.println("프로그램종료...");
	}
	public static void main(String[] args) {
		new DataInputOutputStreamTest().start();
		int a = 'a';
		System.out.println(a);
	}

}
