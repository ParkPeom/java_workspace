package com.codechobo.studeygroup_태진;

public class InvenVO {
	private String product;
	private String brand;
	private String location;
	private String manager;
	private int price;
	private int amount;
	
	public InvenVO() {
	}

	public InvenVO(String product, String brand, int price, int amount, String location, String manager) {
		this.product = product;
		this.brand = brand;
		this.location = location;
		this.manager = manager;
		this.price = price;
		this.amount = amount;
	}

	public static void standOutput() {
		System.out.println("\n\t\t\t\t\t<재고관리>\n");
		System.out.println(" --------------------------------------------------------------------------------------");
		System.out.printf("  %3s\t%3s\t\t%3s\t\t%2s\t\t%3s\t\t%3s\t\t\n","상품명","브랜드","가격","수량","위치","관리자");
		System.out.println(" --------------------------------------------------------------------------------------");
	}
	
	public void invenOutput() {
		System.out.printf("  %3s\t%3s\t\t%6d\t\t%3d\t\t%5s\t\t%3s\t\t\n\n",product,brand,price,amount,location,manager);
	}
		
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
