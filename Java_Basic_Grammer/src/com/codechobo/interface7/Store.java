package com.codechobo.interface7;

import java.util.Scanner;

class People {
	static int money;
	static int bonuspoint;
	public People(int money , int bonuspoint) {
		this.money = money;
		this.bonuspoint = bonuspoint;
	}
	public void balance() {
		System.out.println("남은 잔액은 = " + money +" 보너스 포인트는 = " + bonuspoint);
	}
}
class Product {
	int price;
	public Product() {}
	public Product(int price){
		this.price = price;
	}
	public void purchase(Product product) {
		People.money -= price;
		People.bonuspoint += (int)(price * 0.1);
		System.out.println("구입 완료");
	}
}
class Tv extends Product{
	public Tv(int price) {
		super(500);
	}
}
class Radio extends Product{
	public Radio(int price) {
		super(1000);
	}
}
public class Store {
	Product product; Tv tv; Radio radio;
	public Store() {
		People people = new People(1000,0);
		product = new Product();
	}
	public void start() {
		while(true) {
			System.out.print("1. Tv 구매");
			System.out.print("2. 라디오 구매");
			switch(choice()) {
			case 1 :
				product.purchase(tv);
				break;
			case 2 :
				product.purchase(radio);
				break;
			}
		}
	}
	public int choice() {
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	public static void main(String[] args) {
		new Store().start();
	}
}
