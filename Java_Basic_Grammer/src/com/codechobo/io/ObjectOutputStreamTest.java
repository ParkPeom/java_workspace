package com.codechobo.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
/*
 ����ȭ : ���״�� ��ü�� ����ȭ�Ͽ� ���� ������ ���·� ����� ���� �ǹ��Ѵ�.
  ��ü���� �����͸� �������� �����ͷ� �����Ͽ� Stream�� ���� �����͸� �е��� ���ش�.
�̰��� �ַ� ��ü���� ��°�� ���Ϸ� �����ϰų� �����ϰ� ���� �� �ַ� ���ȴ�.

FileOutputStream : byte������ ������ ����ϴ� Ŭ���� �Դϴ�.
�ڹ� JVM�� ���忡�� ����Ʈ �迭�� ���Ϸ� �������� ������ �ϴ� Ŭ�����Դϴ�
������ �����ϸ� ���� �� �����Ǳ� ������ ������ ������ �������ϴ�.

���ο� ������ ������� true�� ����ϴ� ���� ������ ����ϴ� ��쵵 �ִ�.

InputStream�� ���� ��� �Ŀ��� �ݵ�� close( ) ����� ���Ͽ� ������ ���� �ֽ��ϴ�.
 ���ʹ� SQL ���� ���Ϸ� ����� �����ϴ�.
�����ϱ⵵ ���� DB���ٴ� ������ ���� ���� ���� �ֽ��ϴ�.

 */

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
	}
	public void start() {
		//��ü�� ���Ϸ� ����
		try {
			File f = new File("C://javaFile/ObjectData.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//���Ͽ� ������ ��ü
			DataVO vo = new DataVO();
			
			vo.setNum(99999);
			vo.setName("�����");
			vo.setTel("010-9898-7878");
			vo.setAddr("����� ������");
			vo.setNow(Calendar.getInstance()); // ��ü�� ��������� ������ �ð� 
			oos.writeObject(vo);
			oos.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest().start();
		System.out.println("��ü�� ���Ϸ� �����ϰ� ���α׷��� ����Ǿ����ϴ�.");
	}

}
