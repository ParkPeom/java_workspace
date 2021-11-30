package xyz.itwill.jdbc;

public class StaticBlockApp {

	public static void main(String[] args) {
		/*
		// ClassLoader 프로그램에 의해 클래스(Class 파일)을 읽어 메모리에 저장 - 자동(1번)
		// 가비지컬렉터 - 힙메모리에 쓰잘대기없는걸 제거함
		// new 연산자가 메모리에 저장된 클래스(Clazz)-스태틱메모리 의 생성자를 호출하여 인스턴스를 생성한다.
		// => 생성된 인스턴스를 참조변수에 저장 
		StaticBlock sb = new StaticBlock();
		
		// 참조변수에 저장된 인스턴스의 메서드 호출 - 기능 구현 
		sb.display();
		*/
		
		/*
		try {
			//Class : 클래스 정보(Clazz)를 저장하기 위한 클래스 
			// 이 위치를 읽어들어서 클래즈로(메모리에 로딩시켜주는 역할)
			// Class.forName(String ClassName) : 문자열로 표현된 패키지를 포함한 클래스를 전달받아
			// ClassLoader 프로그램을 이용하여 클래스를 읽어 메모리에 저장하는 메서드
			// => 메모리에 저장된 클래스 정보(Class 인스턴스 - Clazz) 반환
			// => ClassNotFoundException 발생 - 반드시 예외처리
			// => Class.Instance() : 메모리에 저장된 클래스(Clazz)를 이용하여 인스턴스를 생성하는 메서드
			// => Object 타입의 인스턴스 반환 - 명시적 객체 형변환 
			// JVM이 해주는걸 Class.forName() 으로 해준다. 
			// InstantiationException | ClassNotFoundException 발생 - 예외 처리
			// Object 타입의 인스턴스 반환 - 명시적 객체 형변환
			
			// JDK10 이상에서는 Class.getDeclaredConstructor() 메서드로 생성자를 반환받아
			// newInstance() 메서드를 호출하여 인스턴스 생성 ( jvm에 만들어달라고 하는게 아니라 내가 직접 만듬
			// newInstance() 메서드를 인스턴스를 직접 생성하는 
			// 리플렉션 : 인스턴스를 직접 생성하는 사용하는 기술
			// => 접즌 지정자에 상관없이 클래스 요소 접근 가능 
			StaticBlock sb = (StaticBlock)Class.forName("xyz.itwill.jdbc.StaticBlock").getDeclaredConstructor().newInstance(); // 클래스를 읽어줘서 클래즈로 메모리에 만들어달라는 메서드
			sb.display();
		} catch ( InstantiationException | ClassNotFoundException e) {
			System.out.println("[에러]클래스를 찾을 수 없습니다.");
		} catch(Exception e) {
			System.out.println("[에러]실행 프로그램에 문제가 발생 하였습니다.");
		}	
		*/
		try {
			Class.forName("xyz.itwill.jdbc.StaticBlock"); // 패키지명.클래스명 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
