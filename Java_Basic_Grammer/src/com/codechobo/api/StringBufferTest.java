package com.codechobo.api;

public class StringBufferTest {

	public StringBufferTest() {
		
	}
	public void start() {
		//String 고정사이즈의 문자열을 처리하므로 문자열의 값이 변경되면
		// 새로운 주소 이동한다.
		//StringBuffer와 StringBuilder 문자열을 가변으로 관리할 수 있는 클래스로 
		// 문자열이 변경 되더라도 주소를 이동하지 않고 데이터 처리한다.
		
		StringBuffer sb = new StringBuffer();
		System.out.println("확보된 메모리 사이즈->"+ sb.capacity());
		
		String name = "홍";
		name = name.concat("길동");
		System.out.println("name->"+ name);
		
		sb.append("나는");//문자를 기존 데이터의 마지막에 추가한다.
		System.out.println("sb->"+sb.toString());
		
		char[] txt = {'J','A','V','A','를', '좋','아','한','다'};
		sb.append(txt);
		System.out.println("sb->"+ sb);
		//             시작index, 갯수
		sb.append(txt, 5,        4);
		System.out.println("sb->"+ sb);
		
		sb.insert(6, "(자바)");
		System.out.println("sb->"+ sb);
		
		System.out.println("글자수->"+ sb.length());
		System.out.println("공간크기->"+ sb.capacity());
		
		//특정위치의 문자 지우기
		sb.delete(2, 5);
		System.out.println("sb->del->"+ sb);
		//            01234567890123
		String tel = "010-1234-5678";
		String localTel = tel.substring(4, 8);
		String userTel = tel.substring(4);
		System.out.println(localTel+", "+ userTel);
		
		sb.reverse();
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer("자바");
		StringBuffer sb3 = new StringBuffer("자바");
		if(sb2==sb3) {
			System.out.println("같다");
		}else {
			System.out.println("같지않다.");////
		}
		
		StringBuffer sb4 = sb3;
		if(sb3==sb4) {
			System.out.println("같다");/////
		}else {
			System.out.println("같지않다.");
		}
		
		//sb4의 값을 변경하면 같은 주소를 가지고 있는 sb3의 값이 변한다.
		//sb4.append("진짜바뀌나??");
		System.out.println("sb3->"+ sb3);
		
		
		//객체 주소의 데이터를 가지고 같은지 확인하는 메소드를 이용해야 한다.
		//equals() : Object클래스의 메소드를 상속받아 사용하고 있으면
		//           객체내의 값이 아닌 객체자체가 같은지 다른지 판단한다.
		if(sb2.equals(sb3)) {
			System.out.println("equals=>같다");
		}else {
			System.out.println("equals=>다르다");
		}
		
		String s1 = new String("Java");
		String s2 = new String("JAVA");
		//같은지 다른지
		if(s1.equals(s2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		//String s1 = new String("Java");
		//String s2 = new String("JAVA");
		//문자열의 크기비교
		// 양수가 나오면 왼쪽 객체가 크다
		// 음수가 나오면 왼쪽 객체가 작다
		// 0이면 두 객체의 값은 같다.
		int result = s2.compareTo(s1);
		System.out.println("result->"+ result);
		//            01234567890123456789
		String str = "Java Programing Test..";
		//특정위치의 문자1개을 얻어온다.
		System.out.println("charAt(index)->"+ str.charAt(5));
		
		//문자열을 byte의 배열로 구한다.
		byte[] strByte = str.getBytes();
		for(byte s : strByte) {
			System.out.println(s +"->"+(char)s);
		}
		System.out.println(str.indexOf("g")+", "+ str.lastIndexOf("g"));
		
		str = str.replaceAll("Test", "테스트");
		System.out.println("str->"+ str);
		
		String splitResult[] = str.split("g");
		for(String s:splitResult) {
			System.out.println(s);
		}
		System.out.println("대문자로->" + str.toUpperCase());
		System.out.println("소문자로->" +  str.toLowerCase());
		
		//문자열에 포함된 양쪽에 있는 공백문자를 제거하는 것 : trim()
		String userid = "       Gu    Gu    Ma      ";
		System.out.println("="+userid+"=");
		System.out.println("="+userid.trim().replaceAll(" ", "")+"=");
	}
	public static void main(String[] args) {
		new StringBufferTest().start();
	}
}
