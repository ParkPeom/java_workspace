import java.io.Serializable;

public class MemberDTO implements Serializable {

	private String name;
	private String email;
	private int age;
	
	public MemberDTO() {
	}

	public MemberDTO(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", email=" + email + ", age=" + age + "]";
	}

}
