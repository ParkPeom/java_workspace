package com.codechobo.io;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
	}
	
	public void start() {
		//RandomAccessFile��ü�� �б�����("r"), ��������("w", �б� ����("rw") ���� ������ �����ϴ�. 
		//���ϴ� ��ġ�� �̵��Ͽ� �б� ���Ⱑ �����ϴ�.
		
		try {
			File f = new File("c://javaFile","randomAccess.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String txt = "012345678901234567890\n";
			String txt2 = "java programing random access test";
			//���ڸ� ����
			raf.writeBytes(txt);
			raf.writeBytes(txt2);
			
			//point�̵�
			raf.seek(5); 
			raf.writeBytes("ABCD"); // 01234ABCD901234567890
			
			raf.seek(12);
			raf.write("�ڹ�".getBytes());  // �ѱ��Ͻ� Char�� �ߴµ� 2,3,4,5 4����Ʈ����.. ??�ζ�...
			
			////////////////////////////////
			byte[] b = new byte[4]; // 4�ڸ��� �о
			raf.seek(12);
			int cnt = raf.read(b, 0, b.length);// ����ڰ� ���������� ����

//			int cnt = raf.read(b,0,b.length);// ����� �����༭ �о���� 
			System.out.println(cnt + "-->" + new String(b));
			
			raf.seek(24);
			raf.writeInt(123);
			
			raf.seek(24);
			System.out.println(raf.readInt());
			
			System.out.println("����Ϸ�");
		} catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new RandomAccessFileTest().start();
	}
}
