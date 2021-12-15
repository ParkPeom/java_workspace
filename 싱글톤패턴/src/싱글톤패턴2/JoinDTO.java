package ΩÃ±€≈Ê∆–≈œ2;

public class JoinDTO {
	private String jumin;
	private String name;
	private int age;
	private String gender;
	private String phone;
	private String email;
	private String id;
	private String password;
	
	public JoinDTO() {}

	public JoinDTO(String jumin, String name, int age, String gender, String phone, String email, String id,
			String password) {
		super();
		this.jumin = jumin;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.id = id;
		this.password = password;
	}
	
	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Join [jumin=" + jumin + ", name=" + name + ", age=" + age + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", id=" + id + ", password=" + password + "]";
	}
}
