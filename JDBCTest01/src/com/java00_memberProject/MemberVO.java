package com.java00_memberProject;

public class MemberVO {
	private int num;
	private String username;	
	private String tel;
	private String email;
	private String addr;
	private String writedate;
	private int count;///
	
	public MemberVO() {}
	public MemberVO(int num, String username, String tel, String email, String addr) {
		this.num = num;
		this.username = username;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
	}
	public MemberVO(String username, String tel, String email, String addr) {
		this.username = username;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
	}
	public MemberVO(int num, String username, String tel, String email, String addr, String writedate) {
		this(num, username, tel, email, addr);
		this.writedate = writedate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
