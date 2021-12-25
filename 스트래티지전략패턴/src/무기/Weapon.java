package 무기;

// 스트래티지 패턴
// 전략을 쉽게 바꿀수 있도록 디자인 패턴
// 행위(Behavior)들을 캡슐화 하여 동적으로 자유롭게 바꿀수 있는 패턴
public interface Weapon { // 무기 인터페이스를 이용하여 전략(Strategy)를 구현
						  // 총 , 검 , 도끼 들을 캡슐화 하고 
						  // setWeapon()으로 전략을 쉽게 변경 가능 
	void attack();
}
