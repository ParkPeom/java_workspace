package com.codechobo.thread;

import java.util.Calendar;

public class SingleTonTest {
	
	private static SingleTonTest ton;
	
	private SingleTonTest() {
	}
	public static SingleTonTest getInstance() {
		ton = new SingleTonTest();
		return ton;
	}
	public static void main(String[] args) {
		SingleTonTest ton = SingleTonTest.getInstance();
		SingleTonTest ton2 = SingleTonTest.getInstance();
		if(ton.equals(ton2)) {
			System.out.println("true");
		} else {
			System.out.println("falseSS");
		}
		Calendar cal = Calendar.getInstance();
	}
}
