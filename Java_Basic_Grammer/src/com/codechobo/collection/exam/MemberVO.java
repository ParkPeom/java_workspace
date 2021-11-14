package com.codechobo.collection.exam;

public class MemberVO {
	
	private String name;
	private int num;
	
	private MemberVO() {
		
	}
	public static MemberVO getInstance() {
		return new MemberVO();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", num=" + num + "]";
	}
	
}
