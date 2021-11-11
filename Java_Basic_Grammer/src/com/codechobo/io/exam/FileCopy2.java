package com.codechobo.io.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {
	public FileCopy2() {}
	public void start() {
		try {
			File origin = new File("C://javaFile","duke.PNG");
			//1. ���� ���ϸ� �˾Ƴ�
			String fileName = origin.getName();
			//2. ���ο� ���Ͽ� 
			File target = new File("C://etc",fileName);
			
			//3.���ο������� �̹� �����ϸ� 
			if(target.exists()) {
				//4. .��ġ�� ���ϸ� , Ȯ���� ���� 
				int point = fileName.lastIndexOf(".");
				//5. ���ϸ�
				String file = fileName.substring(0,point);
				//6. Ȯ���ڸ�
				String ext = fileName.substring(point + 1);
				
				int cnt = 1;
				
				while(true) {
					// 7. ���ο����ϸ� (����) ī��Ʈ�� 
					String newName = file +"("+ cnt++ +")."+ext;
					target = new File("C://etc",newName);
					// 8. �������������� �������� 
					if(!target.exists()) {
						break;
					}
					
				}
			}
			// 9. ���ο������̸� �����ϱ�
			FileInputStream fis = new FileInputStream(origin);
			FileOutputStream fos = new FileOutputStream(target);
			
			while(true) {
				int num = fis.read();
				if(num == -1) break;
				fos.write(num);
			}
		}catch(IOException e) {
			System.out.println("���������������ʽ��ϴ�.");
		}
		
	}
	public static void main(String[] args) {
		new FileCopy2().start();
	}
}
