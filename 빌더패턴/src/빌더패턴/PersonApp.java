package 빌더패턴;

/* 빌더 패턴 : 
 * 데이터 일관성, 객체불변성 등을 만족
 * 코드 가독성 역시 올라간다
 * 단점 ) 패턴의 단점은 많은 코드량이 필요할 뿐더러,
	Builder라는 객체를 하나더 만드는 것이므로, 때에 따라선 성능이 낮아질 수 있다.
	Class 설계할때, 받아야할 인자들이 많거나, 선택적 인자들이 많거나 또한, 추가될 인자들이 많은 경우
	에 Builder 패턴을 고려한다면, 좀 더 나은 설계를 할 수 있을 것이다.
 * 
 * 
 */
import 빌더패턴.PersonInfo.Builder;

public class PersonApp {

	public static void main(String[] args) {
	// PersonInfo personInfo = new PersonInfo("Mommoo", 12, 119);
	// 객체가 어떤 인자가 들어갔는지 알기 위해선 PersonInfo클래스의 매개변수 이름 주석 참고..
	// 자바 빈즈(beans) 패턴이 대안점으로 나온다.
	// PersonInfo personInfo = new PersonInfo();
	
	/*personInfo.setName("Mommoo");
	personInfo.setAge(12);
	personInfo.setPhoneNumber(119);*/
	// 자바빈즈 패턴은 코드량이 늘어나는 단점이 존재한다. 
	
	// 점층적 생성자패턴과 자바빈즈 패턴의 장점을 섞은것이 빌더패턴이다.
	
	// 정보들은 자바 빈즈 패턴처럼 받되, 데이터 일관성을 위해 정보들을 다 받은후에 객체생성을 해준다.
	
	// PersonInfo personInfo = new Builder("Mommoo").setAge(12).setPhonNumber(119).build( );
	PersonInfo personInfo2 = new Builder("Mommoo").setAge(12).setPhonNumber(119).build( );
	// Builder 객체를 지정함으로써, 메서드 체이닝 기법을 적용했다.
	// build() 메소드로 객체 생성한다.
	
	personInfo2.toString();
	
	}
}
