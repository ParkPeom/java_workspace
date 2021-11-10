package com.codechobo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {

	}
	public void start() {
		//File��ü�� ���Ͽ� �Է� �Ǵ� ����� �Ҽ� ������,
		//	����, ������ ���� ������ �� �ִ�.
		//	���ϰ�ü ������ ����̺��, ���, ���ϸ��� �����ο��� �Ѵ�.
		//  ����� : �� ���� ��ġ�� ����
		//  ������ : ������ ������� ��ġ�� �ִ�
		File f1 = new File("C://javaFile"); // ����̺�� 
		File f2 = new File("C://javaFile/test.txt"); // ��θ�
		File f3 = new File(f1,"ggm.txt");
		File f4 = new File("C://javaFile","sample.txt"); // ����̺�� , ��θ� 
		//�������� Ȯ���Ͽ� �����̸� true, �ƴϸ� false�� �����Ѵ�.
		boolean isDir = f1.isDirectory();
		System.out.println("isDir->"+ isDir);
		File f5 = new File("C://aaa/bbb");
		
		//��������
		if(!f5.exists()) {// ������ǻ�Ϳ� ������ ������ true, ������ false�� �����ش�.
			// mkdir() -> ���������� �����Ҷ� �����ȴ�.
			// mkdirs() -> ���������� ������ ���������� �������ش�.
			//��������
			if(f5.mkdirs()) {
				System.out.println("������ �����Ǿ����ϴ�.");
			} else {
				System.out.println("�������� �����Ͽ����ϴ�."); // �ߺ��ɰ�� 
			}
		}
		//���ϻ���
		if(!f2.exists()) {
			try {
				if(f2.createNewFile() ) {
					System.out.println("������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("���ϻ��� �����Ͽ����ϴ�.");
				}
			} catch(IOException e) {
				System.out.println("���ϻ�������....");
			}
		}
		//������ ������ �˾Ƴ���
		File f6 = new File(f1,"Diamond2.java"); // ��� , ���ϸ� 
		long lastDate = f6.lastModified();
		System.out.println(lastDate);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(lastDate);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
		String lastDateTxt = fmt.format(cal.getTime());
		System.out.println("������ ������ --> " + lastDateTxt);
		
		System.out.println("exe ->" + f6.canExecute());
		System.out.println("canRead ->" + f6.canRead());
		System.out.println("canRWrite -> " + f6.canWrite());
		//
		System.out.println("����̺�,���,����->" + f6.getPath());
		System.out.println("����̺�,���,����->" + f6.getAbsolutePath());
		System.out.println("����->" + f6.getName());
		System.out.println("����̺� ���->" + f6.getParent());
		
		//������ ���ϸ�� ���ؿ���
		File f7 = new File("c://");
		File[] list = f7.listFiles();
		
		for(File f : list) {
			if(f.isDirectory()) {
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[��������]");
				}
				System.out.println(f.getPath()+"[����]");
			} else if(f.isFile()) {
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[��������]");
				} else  {
					System.out.println(f.getPath()+"[����]");					
				}
			}
		}
		// ����ý����� ����̺� ��� ���ϱ�
		File root[] = File.listRoots();
		for(File f : root) {
			System.out.println(f.getPath());
		}
		//������ byte�� ���ϱ�
		long filesize = f6.length();
		System.out.println("���� ũ�� " + filesize);
		
		//���ϻ����ϱ�
		f2.delete();
	}
	public static void main(String[] args) {
		new FileTest().start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
}
