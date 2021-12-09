package xyz.itwill.student.revenge;

public class StudentDTO {
	
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	
	public StudentDTO() {
	
	}

	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "StudentDTO [no=" + no + ", name=" + name + ", phone=" + phone + ", address=" + address + ", birthday="
				+ birthday + "]";
	}
	
}
