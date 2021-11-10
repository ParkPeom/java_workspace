package com.codechobo.reallization;

public class BoatCarReal implements BoatCar {

	@Override
	public void run() {
		System.out.println("땅 위를 달리는 능력");
	}

	@Override
	public void navigate() {
		System.out.println("물 위를 향해하는 능력");
		
	}

	@Override
	public void floating() {
		System.out.println("공중에 떠오르는 능력");
		
	}
	
}
