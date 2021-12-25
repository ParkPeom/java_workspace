package dto;

public class CustomerDTO {
	private String id;
	private int money;
	private int bonuspoint;
	
	public CustomerDTO() {}
	
	public CustomerDTO(String id, int money, int bonuspoint) {
		super();
		this.id = id;
		this.money = money;
		this.bonuspoint = bonuspoint;
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


	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", money=" + money + ", bonuspoint=" + bonuspoint  + "]";
	}
	
}
