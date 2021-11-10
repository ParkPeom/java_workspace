package com.codechobo.opensrc.EmpInfor;

public class EmpVO {
	private String empNo;//�����ȣ
	private String empName;//�����
	private String tel;//����ó
	private int sal;//�޿�
	private String hiredate;//�Ի���

	public EmpVO() {
		
	}
	public EmpVO(String empNo, String empName, String tel, int sal, String hiredate) {
		this.empNo = empNo;
		this.empName = empName;
		this.tel = tel;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	//  ���1�� ���==========================================
	public void empPrint() {
		System.out.printf("%-10s\t%-10s\t%-20s\t%-10d\t%-15s\n", empNo, empName, tel, sal, hiredate);
	}
	// Ÿ�̺� ���
	public static void titlePrint() {
		System.out.printf("%-10s\t%-10s\t%-20s\t%-10s\t%-15s\n","�����ȣ", "�����", "����ó", "�޿�", "�Ի���");
		System.out.println("---------------------------------------------------------------------------------");
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}	
}
