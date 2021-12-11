package MainApp;

// 게임캐릭터 
import 게임캐릭터.Character;

// 무기들 
import 무기.Ax;
import 무기.Gun;
import 무기.Knife;
import 무기.Weapon;

/* 구현한 Strategy 를 사용하여 게임 케릭터 구현
 *  검사(swordMan)와 사수(shooter)를 만든다.
	setWeapon() 을 이용하여 '검사'에게 '검' '사수'에게 '총'을 무기로 쥐어 준다
	attack() 메소드로 공격 
	
 * 더 나아가 게임에 도끼(Ax)란 무기가 업데이트되어 검사가 사용할 수 있게 되었다면
 * 
 */


public class Main {
	
	public static void main(String[] args) {
		final Character swordMan = new Character();
		final Character shooter = new Character();
		
		final Weapon knife = new Knife();
		final Weapon gun = new Gun();
		
		swordMan.attack();
		shooter.attack();
		
		// 새로운 무기 '도끼'로 공격 한다.
		final Weapon ax = new Ax();
		
		// 전략 패턴(Strategy Pattern)으로 행위(Behavior)를 유연하게 변경할 수 있음.

		// 스트래티지 패턴 [MemoStack]
		
		swordMan.setWeapon(ax); // 무기 장착 
		swordMan.attack();// 무기를 장착하고 공격 
		
	}
}
