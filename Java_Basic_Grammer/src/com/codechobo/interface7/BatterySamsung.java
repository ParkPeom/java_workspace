package com.codechobo.interface7;

public class BatterySamsung implements Battery {

	public BatterySamsung() {
		RechargeableBattery();
		square(garo,saro);
	}
	
	@Override
	public void RechargeableBattery() {
		System.out.println("�Ｚ���͸� ������...");
	}
	
	@Override
	public void square(int garo, int saro) {
		System.out.println(" ���� = " + garo
				+ " ���� = " + saro);
	}
	
	public static void main(String[] args) {
		Battery samsung = new BatterySamsung();
		samsung.RechargeableBattery();
		samsung.square(garo, saro);
	}
}
