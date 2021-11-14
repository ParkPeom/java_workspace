package com.codechobo.interface7;

interface Battery {

	final static int garo = 100;
	final static int saro = 200;
	
	default void getBattery() {
		System.out.println("1");
	}
	public abstract void RechargeableBattery();
	public abstract void square(int gero,int saro);
}
