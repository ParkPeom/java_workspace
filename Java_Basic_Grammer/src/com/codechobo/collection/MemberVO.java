package com.codechobo.collection;

public class MemberVO {
	private int num;// ��ȣ
	private String userid;// �̸�
	private String tel;// ����ó
	public MemberVO() {
		
	}
	///////
	MemberVO(int num,String userid,String tel){
		this.num = num;
		this.userid = userid;
		this.tel = tel;
	}
	/////////////////////
	//ȸ�������� �ֿܼ� ����ϴ� �޼ҵ�
	public void memberOutput() {
		System.out.printf("%d\t %s\t %s \n",num,userid,tel);
	}
	/////////////////////
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		//1~200������ ���� ���� �����ȣ�϶� 
		if(num>=1 && num<=200) {
			this.num = num;
		} else {
			System.out.println("�����ȣ�� �߸��Է��Ͽ����ϴ�.");			
		}
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTel() {
		// �α��� ����
		// ����
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
