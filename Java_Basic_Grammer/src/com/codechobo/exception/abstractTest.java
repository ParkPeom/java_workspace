package com.codechobo.exception;

public abstract class abstractTest {
	
	abstract void run();
	
	
	public static void main(String[] args) {
		
		abstractTest ab = new Abstract();
		ab.run();
	}
}

class Abstract extends abstractTest {
	public void run() {
		System.out.println("±¸Çö");
	}
}
