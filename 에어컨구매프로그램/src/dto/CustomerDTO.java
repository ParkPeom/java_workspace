package dto;

public class CustomerDTO {
	private String id;
	private int money;
	private int bonuspoint;
	private String jumin2;
	
	public CustomerDTO() {}
	
	public CustomerDTO(String id, int money, int bonuspoint, String jumin2) {
		super();
		this.id = id;
		this.money = money;
		this.bonuspoint = bonuspoint;
		this.jumin2 = jumin2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBonuspoint() {
		return bonuspoint;
	}
	public void setBonuspoint(int bonuspoint) {
		this.bonuspoint = bonuspoint;
	}
	public String getJumin2() {
		return jumin2;
	}
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", money=" + money + ", bonuspoint=" + bonuspoint + ", jumin2=" + jumin2 + "]";
	}
	
}
