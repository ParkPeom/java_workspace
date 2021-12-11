package 게임캐릭터;

import 무기.Weapon;

/* 게임 케릭터 만들기
 * 무기를 사용할 케릭터를 구현
 * weapon이란 접근점을 만들고, setWeapon()이란 교환 가능
 * attack()이란 메소드를 만들고, 
 * 구현 내용은 weapon에게 위임(deligate)한다
 */
public class Character {
	
	
	private Weapon weapon;
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void attack() {
		weapon.attack();
	}
}
