package xyz.itwill.student;

//DTO(Data Transfer Object) : ������ ������ �����ϴ� ��ü 
// : DAOŬ������ �޼��忡�� �������� ���޹ްų� ��ȯ�ϱ�
// ���� �������� �ۼ��� Ŭ���� - VO(Value Object) Ŭ���� : ���� ǥ���ϱ� ���� ��ü  
// => ���̺��� �÷��� 1:1�� ��Ī�Ǵ� �ʵ� ���� - Getter & Setter 
// => �ʵ���� ���̺��� �÷���� �����ϰ� �ۼ��ϴ� ���� ���� => ���̹�Ƽ�� ���� ��Ģ�̵�

/*
�̸�       ��?       ����            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(30)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE 
*/

//STUDENT ���̺��� �л�����(�� : ROW)�� �����Ͽ� ����(��ȯ)�ϱ� ���� 

// [-----------����-------------]
// ���̺� - DTO - DAO - ���ø����̼�

public class StudentDTO {
	// �÷���� �ʵ���� �Ȱ��� �ۼ� ���� - ���߿� ���̹�Ƽ������ ��Ģ�̵� 
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday; // java.sql.Date �ᵵ�Ǵµ� String�� �� Date �߾Ⱦ�
							 // ������Ҷ� String�� ����
	
	// Ctrl + space >> Constructor ���� 
	public StudentDTO() {
	}
	
	// [Alt]+[Shift]+[S] >> �˾��޴� >> [O] >> �ʵ弱�� >> Generate
	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
	// �ʵ忡 ���ϴ� ���� ��ȯ�޾� ��� 
	@Override
	public String toString() {
		return "StudentDTO [no=" + no + ", name=" + name + ", phone=" + phone + ", address=" + address + ", birthday="
				+ birthday + "]";
	}
	
}
