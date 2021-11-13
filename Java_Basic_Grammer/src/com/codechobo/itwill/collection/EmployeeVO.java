package com.codechobo.itwill.collection;

public class EmployeeVO extends Object{
	private int sabun;
	private String username;
	private String tel;
	private String position;
	private String email;
	
	public EmployeeVO() {
		
	}
	public EmployeeVO(int sabun, String username, String tel, 
			String position, String email) {
		this.sabun = sabun;
		this.username = username;
		this.tel = tel;
		this.position = position;
		this.email = email;				
	}
	//Object클래스의 toString()메소드를 오버라이딩한다.	
	public String toString() {
		return sabun+"\t"+username+"\t"+tel+"\t"+position+"\t"+email;
	}
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
