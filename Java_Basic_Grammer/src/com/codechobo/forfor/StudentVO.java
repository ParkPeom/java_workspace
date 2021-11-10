package com.codechobo.forfor;

public class StudentVO {	
	private String name;
	private int age;

	StudentVO(){}
	
	public StudentVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(!(name.length() > 0 || name.length() < 4)) {
			System.out.println("이름 설정 불가");
		}	
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(!(age < 0 && age > 100)) {
			System.out.println("이름 설정 불가 ");
		}
		this.age = age;
	}

	@Override
	public String toString() {
		return "name : " + this.name + "age : " + age;
	}
	
	
}
