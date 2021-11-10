package com.codechobo.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


enum enumArray { YELLOW , RED , BLUE };

class Student {
	private String name;
	private int age;

	public Student() {
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
public class Exam2 {
	
	public static void main(String[] args) {
		
		ArrayList<Student> std = new ArrayList<Student>();
		
		Student student1 = new Student("�ڹ�",28);
		
		std.add(student1); 
		student1 = null;
		
		student1 = new Student("��ö��",25);
		std.add(student1);
		
		student1 = null;
		student1 = new Student("������",21);
		std.add(student1);
		
		for(Student s : std) {
			System.out.println(s + " ");
		}
		
		
	}
}
