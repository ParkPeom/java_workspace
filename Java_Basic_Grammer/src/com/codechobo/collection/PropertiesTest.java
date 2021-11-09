package com.codechobo.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

	public PropertiesTest() {
		
	}
	public void start() {
		// Properties클래스는 key와 value를 가지고 있으며,
		//		key와 value는 String이다.
		// 		입력순서를 유지하지 않는다.
		//		제네릭 클래스가 아니다.
		Properties prop = new Properties();
		
		prop.setProperty("/", "index.jsp");
		prop.setProperty("/edit", "memberEdit.jsp");
		prop.setProperty("/list", "boardList.jsp");
		prop.setProperty("/login", "loginForm.jsp");
		prop.setProperty("/view", "boardView.jsp");
		
		//key를 이용한 value얻어오기
		String v = prop.getProperty("/login");
		System.out.println(v);
		
		//key 목록 구하기
		//열거형 propertyNames()
		Enumeration keyList = prop.propertyNames();
		while(keyList.hasMoreElements()) {
			String k = (String)keyList.nextElement(); // Object -> String
			String vv = prop.getProperty(k);
			System.out.println(k+"-->"+vv);
		}
		System.out.println("-------------------------");
		////////////////////////////////////////////
		// Set stringPropertyNames() - 순서없다.
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
