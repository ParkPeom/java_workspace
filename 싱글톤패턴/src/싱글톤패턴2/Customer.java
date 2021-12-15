package ΩÃ±€≈Ê∆–≈œ2;

// º’¥‘
public class Customer {
	private int age;
	private int money;
	private int bonustPoint;
	private String gender;
	
	public Customer() {
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getBonustPoint() {
		return bonustPoint;
	}

	public void setBonustPoint(int bonustPoint) {
		this.bonustPoint = bonustPoint;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [age=" + age + ", money=" + money + ", bonustPoint=" + bonustPoint + ", gender=" + gender
				+ "]";
	}
}
