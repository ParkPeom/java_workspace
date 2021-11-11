package com.codechobo.io;

import java.io.Serializable;
import java.util.Calendar;

// 직렬화를 한 클래스는 객체를 생성하여 파일로 저장할수 있다. 현재 클래스를 일렬로 줄세우는 
public class DataVO implements Serializable {
	private int num;
	private String name;
	private String addr;
	private String tel;
	
	private Calendar now;
	
	public DataVO() {

	}
	
	public Calendar getNow() {
		return now;
	}

	public void setNow(Calendar now) {
		this.now = now;
	}

	public void print() {
		System.out.printf("%d\t%s\t%s\t%s\n",num,name,tel,addr);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
