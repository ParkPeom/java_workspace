package ����ĳ����;

import ����.Weapon;

/* ���� �ɸ��� �����
 * ���⸦ ����� �ɸ��͸� ����
 * weapon�̶� �������� �����, setWeapon()�̶� ��ȯ ����
 * attack()�̶� �޼ҵ带 �����, 
 * ���� ������ weapon���� ����(deligate)�Ѵ�
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
