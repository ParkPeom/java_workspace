package com.codechobo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public FileCopy() {
	}
	public void start() {
		try {
			//c://javaFile/natural.jfif -> c://etc/natural.jfif ����
			//���ϸ��� ������ ���ϸ��� rename �Ѵ�. c://etc/natrual(1).jfif		
			//��������
			File orgFile = new File("c://javaFile/duke.PNG");
			if(orgFile.exists()) { // ������ ������ ������ �����ϰ� 
				//���ο� ���ϰ�ü
				String filename = orgFile.getName();
				File tarFile = new File("c://etc",filename); 
				
				//������ ���� tarFile�� �����ϴ��� Ȯ���� ������ �����ϰ�
				//������ ���� �ٲ۴�.
				
				// �����ϸ� 
				if(tarFile.exists()) {
					//���ϸ��� ����
					int point = filename.lastIndexOf("."); //���ڿ����� ������ .�� ��ġ index
					String fName = filename.substring(0,point);
					//���ϸ�(Ȯ��������)
					String ext = filename.substring(point + 1);
					
					int cnt = 1;
					
					while(true) {
						String newName = fName+"("+cnt++ +")."+ext; // duke(1).PNG
						tarFile = new File("c://etc",newName);
						if(!tarFile.exists()) {
							break;
						}
					}
				}
					// �������������� �����ϱ� 
					FileInputStream fis = new FileInputStream(orgFile); //�а�
					FileOutputStream fos = new FileOutputStream(tarFile); //����
//					while(true) {
//						int data = fis.read(); // �����͸� ���� 
//						if(data == -1) break; 
//						// �����Ͱ� ������ ����.
//						fos.write(data);
//					}
					// �ݺ����� �Ⱦ��� ���غ���
					// ����Ʈ������ �а� ���� 
					byte[] inData = new byte[(int)orgFile.length()];
					fis.read(inData, 0, inData.length); // �о����
					fos.write(inData, 0 , inData.length); // ���� 
					
				} else {
					System.out.println("������ �������� �ʽ��ϴ�.");
				}
			System.out.println("���Ϻ���ó���� �Ϸ�Ǿ����ϴ�.");
		}catch(Exception e) {
			System.out.println("���� �߻�.... -> " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		new FileCopy().start();
	}
}
