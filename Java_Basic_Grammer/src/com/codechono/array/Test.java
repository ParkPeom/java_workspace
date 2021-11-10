package com.codechono.array;

class ParentP {
	int x = 30;
} 
class Parent extends ParentP {
	int x = 20;
	
	public void setX(int x) {
		this.x = super.x;
	}
}
class Child extends Parent {
	
	public int getX() {
		return super.x;
	}
}
public class Test {
	
	public static void main(String[] args) {
		
		Child c =  new Child();
		System.out.println(c.getX());
	}
}
