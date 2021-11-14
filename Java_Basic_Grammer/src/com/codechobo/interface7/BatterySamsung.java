package com.codechobo.interface7;

public class BatterySamsung implements Battery {

	public BatterySamsung() {
		RechargeableBattery();
		square(garo,saro);
	}
	
	@Override
	public void RechargeableBattery() {
		System.out.println("삼성베터리 충전중...");
	}
	
	@Override
	public void square(int garo, int saro) {
		System.out.println(" 가로 = " + garo
				+ " 세로 = " + saro);
	}
	
	public static void main(String[] args) {
		Battery samsung = new BatterySamsung();
		samsung.RechargeableBattery();
		samsung.square(garo, saro);
	}
}
