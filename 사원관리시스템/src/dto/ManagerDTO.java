package dto;

import java.util.Scanner;

import exception.JoinException;

public class ManagerDTO {

	private String id;
	private String pwd;
	private String name;
	private String tel;
	Scanner sc = new Scanner(System.in);
	public ManagerDTO() {}
	public ManagerDTO(String id, String pwd, String name, String tel) {
	
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		// false �Ͻ� 
		while(true) {
				if(id.length() >= 5 && id.length() <= 10) {
				this.id = id;
				break;
			} else  {
				System.out.print("\t���̵� �ٽ� �Է��� �ּ��� > ");
				id = sc.nextLine();
			}
		}
	}
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {

		while(true) {
			if(pwd.length() >= 10 && id.length() <= 20) {
			this.pwd = pwd;
			break;
		} else  {
			System.out.print("\t��й�ȣ�� �ٽ� �Է��� �ּ��� > ");
			pwd = sc.nextLine();
			}
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		while(true) {
			if(name.length() >= 2 && name.length() <= 5) {
			this.name = name;
			break;
		} else  {
			System.out.print("\t�̸��� �ٽ� �Է��� �ּ��� > ");
			name = sc.nextLine();
			}
		}
	}
		
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
//		while(true) {
//			if(JoinException.isPhoneNum(tel)) {
//				this.tel = tel;
//				break;
//			} else {
//				System.out.print("\t��ȭ��ȣ�� �ٽ� ���Ŀ� �°� �Է��� �ּ��� (010-XXXX-XXXX) > ");
//				tel = sc.nextLine();
//				setTel(tel);
//			}
//		}
		while(true) {
			if(tel.substring(3,4).equals("-") && tel.substring(8,9).equals("-") && tel.length() == 13) {
				this.tel = tel;
				break;
		} else {
			System.out.print("\t ��ȭ��ȣ�� �ٽ� ���Ŀ� �°� �Է��� �ּ��� > ");
			tel = sc.nextLine();
			}
		}
	}
}