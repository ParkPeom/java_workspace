package com.codechobo.exception;

import java.io.File;

class Ex8_10 {
	public static void main(String[] args) {
		try {
			File f = createFile("");
			System.out.println( f.getName()+"������ ���������� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage()+" �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
		}
	}	// main�޼����� ��

	static File createFile(String fileName) { // throws Exception {
	try {	
		if (fileName==null || fileName.equals(""))
			throw new Exception("�����̸��� ��ȿ���� �ʽ��ϴ�.");
		}
		catch(Exception e) {
			fileName = "�������";
	}
		File f = new File(fileName);		//  FileŬ������ ��ü�� �����.
     	
		// File��ü�� createNewFile�޼��带 �̿��ؼ� ���� ������ �����Ѵ�.
//		f.createNewFile(); // Ŭ���ϸ� Quick fix ����� �̿��ؼ� ��Ŭ������ �ڵ����� ���ܸ� ó�����ִ� �ڵ� ���� 
		return f;		// ������ ��ü�� ������ ��ȯ�Ѵ�.
	}	// createFile�޼����� ��
}	// Ŭ������ ��
