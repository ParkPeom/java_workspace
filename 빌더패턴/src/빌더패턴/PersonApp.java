package ��������;

/* ���� ���� : 
 * ������ �ϰ���, ��ü�Һ��� ���� ����
 * �ڵ� ������ ���� �ö󰣴�
 * ���� ) ������ ������ ���� �ڵ差�� �ʿ��� �Ӵ���,
	Builder��� ��ü�� �ϳ��� ����� ���̹Ƿ�, ���� ���� ������ ������ �� �ִ�.
	Class �����Ҷ�, �޾ƾ��� ���ڵ��� ���ų�, ������ ���ڵ��� ���ų� ����, �߰��� ���ڵ��� ���� ���
	�� Builder ������ ����Ѵٸ�, �� �� ���� ���踦 �� �� ���� ���̴�.
 * 
 * 
 */
import ��������.PersonInfo.Builder;

public class PersonApp {

	public static void main(String[] args) {
	// PersonInfo personInfo = new PersonInfo("Mommoo", 12, 119);
	// ��ü�� � ���ڰ� ������ �˱� ���ؼ� PersonInfoŬ������ �Ű����� �̸� �ּ� ����..
	// �ڹ� ����(beans) ������ ��������� ���´�.
	// PersonInfo personInfo = new PersonInfo();
	
	/*personInfo.setName("Mommoo");
	personInfo.setAge(12);
	personInfo.setPhoneNumber(119);*/
	// �ڹٺ��� ������ �ڵ差�� �þ�� ������ �����Ѵ�. 
	
	// ������ ���������ϰ� �ڹٺ��� ������ ������ �������� ���������̴�.
	
	// �������� �ڹ� ���� ����ó�� �޵�, ������ �ϰ����� ���� �������� �� �����Ŀ� ��ü������ ���ش�.
	
	// PersonInfo personInfo = new Builder("Mommoo").setAge(12).setPhonNumber(119).build( );
	PersonInfo personInfo2 = new Builder("Mommoo").setAge(12).setPhonNumber(119).build( );
	// Builder ��ü�� ���������ν�, �޼��� ü�̴� ����� �����ߴ�.
	// build() �޼ҵ�� ��ü �����Ѵ�.
	
	personInfo2.toString();
	
	}
}
