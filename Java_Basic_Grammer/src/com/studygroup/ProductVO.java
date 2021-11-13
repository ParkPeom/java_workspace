package com.studygroup;

public class ProductVO {

	private String brandName;
	private int price;
	private int mount;
	private String position;
	private String management;
	
	public ProductVO(String brandName, int price, int mount, String position, String management) {
		this.brandName = brandName;
		this.price = price;
		this.mount = mount;
		this.position = position;
		this.management = management;
	}

	public ProductVO() {
		
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMount() {
		return mount;
	}

	public void setMount(int mount) {
		this.mount = mount;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

	@Override
	public String toString() {
		return "브랜드 이름 = " + brandName + ", 가격 = " + price + ", 수량 =" + mount + ", 위치 =" + position
				+ ", 관리 =" + management + "]";
	}
	
}
