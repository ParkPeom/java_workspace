package com.codechobo.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

	public PropertiesTest() {
		
	}
	public void start() {
		// PropertiesŬ������ key�� value�� ������ ������,
		//		key�� value�� String�̴�.
		// 		�Է¼����� �������� �ʴ´�.
		//		���׸� Ŭ������ �ƴϴ�.
		Properties prop = new Properties();
		
		prop.setProperty("/", "index.jsp");
		prop.setProperty("/edit", "memberEdit.jsp");
		prop.setProperty("/list", "boardList.jsp");
		prop.setProperty("/login", "loginForm.jsp");
		prop.setProperty("/view", "boardView.jsp");
		
		//key�� �̿��� value������
		String v = prop.getProperty("/login");
		System.out.println(v);
		
		//key ��� ���ϱ�
		//������ propertyNames()
		Enumeration keyList = prop.propertyNames();
		while(keyList.hasMoreElements()) {
			String k = (String)keyList.nextElement(); // Object -> String
			String vv = prop.getProperty(k);
			System.out.println(k+"-->"+vv);
		}
		System.out.println("-------------------------");
		////////////////////////////////////////////
		// Set stringPropertyNames() - ��������.
		Set<String> keySet = prop.stringPropertyNames();
		Iterator<String> ii = keySet.iterator();
		
		while(ii.hasNext()) {
			String kk = ii.next();
			String vvv = prop.getProperty(kk);
			System.out.println(kk+"====>"+vvv);
		}
	}

	public static void main(String[] args) {
		new PropertiesTest().start();
	}

}
