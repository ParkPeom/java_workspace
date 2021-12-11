package MainApp;

// ����ĳ���� 
import ����ĳ����.Character;

// ����� 
import ����.Ax;
import ����.Gun;
import ����.Knife;
import ����.Weapon;

/* ������ Strategy �� ����Ͽ� ���� �ɸ��� ����
 *  �˻�(swordMan)�� ���(shooter)�� �����.
	setWeapon() �� �̿��Ͽ� '�˻�'���� '��' '���'���� '��'�� ����� ��� �ش�
	attack() �޼ҵ�� ���� 
	
 * �� ���ư� ���ӿ� ����(Ax)�� ���Ⱑ ������Ʈ�Ǿ� �˻簡 ����� �� �ְ� �Ǿ��ٸ�
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
		
		// ���ο� ���� '����'�� ���� �Ѵ�.
		final Weapon ax = new Ax();
		
		// ���� ����(Strategy Pattern)���� ����(Behavior)�� �����ϰ� ������ �� ����.

		// ��Ʈ��Ƽ�� ���� [MemoStack]
		
		swordMan.setWeapon(ax); // ���� ���� 
		swordMan.attack();// ���⸦ �����ϰ� ���� 
		
	}
}
