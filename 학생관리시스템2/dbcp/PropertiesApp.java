package xyz.itwill.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties 파일 : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일 - 확장자 : XXX.properties
// => 프로그램을 변경하고 않고 Properties 파일의 내용을 변경하여 프로그램 실행 결과를 변경 가능
// => 프로그램의 유지보수 효율성 증가
// => Properties 파일에서는 값을 무조건 문자열로만 제공
// => Properties 파일에서는 영문자, 숫자, 일부 특수문자를 제외한 문자는 유니코드로 표현

//user.properties 파일에 의해 제공되는 값을 출력하는 프로그램
public class PropertiesApp {
	public static void main(String[] args) throws IOException {
		//Properties 파일을 읽기 위한 (파일 입력스트림) 생성
		
		//FileInputStream 클래스를 이용하여 파일 입력스트림 생성 - 파일 경로 관련 문제 발생
		//FileInputStream in=new FileInputStream("src/xyz/itwill/jdbc/user.properties");
		
		// 그래서 클래스로더를 이용하면
		
		// 메모리에 저장된 클래스를 Class 인스턴스(Clazz)로 제공받는 방법
		// 1.Class.forName(String className) : 문자열로 표현된 클래스를 메모리에 저장하고
		// 클래스의 위치를 통해 파일을 가져다 쓸수있다.
		
		// 저장된 클래스를 Class 인스턴스(Clazz)로 반환하는 메소드 호출
		//2.Object.getClass() : 현재 사용중인 클래스를 Class 인스턴스로 반환
		//3.클래스명.class: 메모리에 저장된 클래스를 직접 Class 인스턴스로 표현하여 사용
		
		//ClassLoader 프로그램울 이용한 입력스트림 생성 - 파일 경로 관련 문제 미발생
		//클래스명.class : 메모리에 저장된 클래스(Class 인스턴스 - Clazz)를 직접 표현하는 방법
		//Class.getClassLoader() : 클래스를 읽어 메모리에 저장하는 기능을 제공하는 
		//ClassLoader 인스턴스를 반환하는 메소드
		//ClassLoader.getResourceAsStream(String resource) : 리소스 파일을 전달받아 파일을
		//읽기 위한 입력스트림을 생성하여 반환하는 메소드
		// 직접 클래스이름을 읽어들임  자체가 클재즈가 됨 
		InputStream in = PropertiesApp.class.getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties"); // 자원의 경로를 읽어들일수있는 리소스를 통해 스트림을 만들어달라  
							// 리소스파일을 전달받아 인스턴스를 반환 클래스를 읽어 메모리에 저장 
		
		//Properties 클래스로 인스턴스 생성
		// => Properties 클래스는 Map 인터페이스를 상속받은 콜렉션 클래스
		// => Properties 인스턴스는 식별자(Key)과 값(Value)를 하나의 엔트리(Entry)로 처리하여 저장
		Properties properties=new Properties();
		
		//Properties.load(InputStream in) : Properties 파일에 저장된 모든 엔트리(Key와 Value 하나의 쌍)를
		//얻어와 Properties 인스턴스의 엔트리로 추가하는 메소드
		properties.load(in);
		
		//Properties 인스턴스에 저장된 엔트리 중 식별자(Key)를 사용하여 값(Value)을 반환받아 저장
		//Properties.get(String key) : Properties 인스턴스에 저장된 엔트리 중 식별자(Key)의 
		//값(Value)을 반환하는 메소드
		// => 반환값이 Object 타입으로 반환되므로 반드시 명시적 객체 형변환하여 저장
		
		// 키값을 통해 
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		
		// value 
		System.out.println("아이디 = "+id);
		System.out.println("비밀번호 = "+password);
		System.out.println("이름 = "+name);
	}
}

















