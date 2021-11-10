package com.codechobo.stringbuffer;

public class StringBufferTest {
	
	public StringBufferTest() {

	}
	public void start() {
		// String 고정사이즈 문자열을 처리하므로 문자열의 값이 변경되면
		// 새로운 주소 이동한다.
		// StringBuffer 와 StringBuilder 문자열을 가변으로 관리할수 있는 클래스로
		// 문자열의 변경 되더라도 주소를 이동하지 않고 데이터 처리한다.
		StringBuffer sb = new StringBuffer();
		System.out.println(" 확보된 메모리 사이즈 -> " + sb.capacity());
		
		String name ="홍";
		name = name.concat("길동"); // 변수에 대입을 시켜줘야 변수값이 변한다. 
		System.out.println(name);
		
		// StringBuffer
		sb.append("나는"); // append  문자를 기존 데이터의 마지막에 추가한다. 
		System.out.println("sb->"+sb.toString());
		char[] txt = {'J','A','V','A','를','좋','아','한','다'};
		sb.append(txt);
		System.out.println(sb.toString());
		// 시작 index 0 부터
		sb.append(txt,5,4);
		sb.insert(6, "(자바)"); // insert 6번째 인덱스에 추가 
		System.out.println("sb  = " + sb);
		
		
		// 최대 19글자 
		System.out.println("글자 수 = " + sb.length()); 
		System.out.println("공간크기 = " + sb.capacity()); // 34글자 확보
								// 글자를 더넣으면 2배이상인 공간을 확보한다.
		
		// 특정위치의 문자 지우기
		sb.delete(2, 5);
		System.out.println("sb->del->"+ sb);
		
		String tel = "010-1234-5678";
		String localTel = tel.substring(4, 8);
		String userTel = tel.substring(4);
		System.out.println(localTel + ", " + userTel);
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer("자바");
		StringBuffer sb3 = new StringBuffer("자바");
		
		System.out.println("===");
		if(sb2.equals(sb3)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		// 차이 - 객체냐 아니냐의 차이 변수 관리하는게 힙 
		
		if(sb2 == sb3) {
		// 같지않음 
			System.out.println("같음");
		} else {
			System.out.println("같지않다");
		}
		// 같음 
		StringBuffer sb4 = sb3;
		if(sb3 == sb4) {
			System.out.println("같음");
		} else {
			System.out.println("같지않다");
		}
		
		// sb4의 값을 변경하면 같은 주소를 가지고 있는 sb3 도 값이 변경 
		sb4.append("진짜바뀌나??");
		System.out.println("sb3->"+sb3);
		
		// 객체 주소의 데이터를 가지고 같은지 확인하는 메서드
		
		// 객체주소의 데이터를 가지고 같은지 확인하는 메서드를 이용해야 한다.
		// equals() : Object 클래스의 메서드를 상속받아 사용하고 있으면
		//			객체내의 값이 아닌 객체 자체가 같은지 다른지 판단한다.
		String s1 = new String("Java");
		String s2 = new String("Java");
		
		if(s1 == s2) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		if(s1.equals(s2)) {
			System.err.println("같다");
		} else {
			System.out.println("같지않다");
		}
		
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		// 우선순위 빼기 
		// 문자열의 크기 비교
		// 양수가 나오면 왼쪽 객체가 크다
		// 음수가 나오면 왼쪽 객체가 작다
		// 0 이면 두 객체 의 값은 같다 
		String s3 = new String("Jbxcb");
		String s4 = new String("JAVA");
		
		System.out.println(s3.compareTo(s4));
		
		// 특정 위치의 문자1개를 얻어온다.
		String str = "Java Programing Test.. ";
		// 특정위치의 문자 1개를 얻어온다.
		
		char c = str.charAt(5);
		System.out.println(c);
		
		// 문자열을 byte 의 배열로 구한다. 
		byte[] strByte = str.getBytes();
		for(byte s : strByte) {
			System.out.println(s);
		}
		System.out.println(str.indexOf("g") + ", " + str.lastIndexOf("g"));
					// 8 + 14
		str = str.replaceAll("Test", "테스트");
		System.out.println("str->" + str);
		
		String str4 = "sldlas s dokd  wqo";
		System.out.println(str4.replaceAll(" ", ""));
		
		String[] splitResult = str.split("g"); // g 로 짜름 
		for(String s : splitResult) {
			System.out.println(s);
		}
		System.out.println("대문자로 -> " + str.toUpperCase());
		System.out.println("소문자로 -> " + str.toLowerCase());
	
		// 문자열에 포함된 양쪽에 있는 공백문자를 제거하는 것 : trim();
		String userid = "        g";
		System.out.println(" 공백제거 : " + userid.trim().replaceAll(" ", ""));
		
		System.out.println("="+userid+"=");
	}
	
	public static void main(String[] args) {
		new StringBufferTest().start();
	}
}
