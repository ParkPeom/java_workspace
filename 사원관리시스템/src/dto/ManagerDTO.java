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
		// false 일시 
		while(true) {
				if(id.length() >= 5 && id.length() <= 10) {
				this.id = id;
				break;
			} else  {
				System.out.print("\t아이디를 다시 입력해 주세요 > ");
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
			System.out.print("\t비밀번호를 다시 입력해 주세요 > ");
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
			System.out.print("\t이름을 다시 입력해 주세요 > ");
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
//				System.out.print("\t전화번호를 다시 형식에 맞게 입력해 주세요 (010-XXXX-XXXX) > ");
//				tel = sc.nextLine();
//				setTel(tel);
//			}
//		}
		while(true) {
			if(tel.substring(3,4).equals("-") && tel.substring(8,9).equals("-") && tel.length() == 13) {
				this.tel = tel;
				break;
		} else {
			System.out.print("\t 전화번호를 다시 형식에 맞게 입력해 주세요 > ");
			tel = sc.nextLine();
			}
		}
	}
}