package xyz.itwill.student;

//DTO(Data Transfer Object) : 데이터 값들을 전달하는 객체 
// : DAO클래스의 메서드에서 행정보를 전달받거나 반환하기
// 위한 목적으로 작성된 클래스 - VO(Value Object) 클래스 : 값을 표현하기 위한 객체  
// => 테이블의 컬럼과 1:1로 매칭되는 필드 선언 - Getter & Setter 
// => 필드명은 테이블의 컬럼명과 동일하게 작성하는 것을 권장 => 마이바티스 에서 규칙이됨

/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(30)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE 
*/

//STUDENT 테이블의 학생정보(행 : ROW)를 전달하여 전달(반환)하기 위한 

// [-----------순서-------------]
// 테이블 - DTO - DAO - 어플리케이션

public class StudentDTO {
	// 컬럼명과 필드명은 똑같이 작성 권장 - 나중에 마이바티스에서 규칙이됨 
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday; // java.sql.Date 써도되는데 String도 됨 Date 잘안씀
							 // 입출력할때 String이 편함
	
	// Ctrl + space >> Constructor 선택 
	public StudentDTO() {
	}
	
	// [Alt]+[Shift]+[S] >> 팝업메뉴 >> [O] >> 필드선택 >> Generate
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

	
	// 필드에 원하는 값을 반환받아 출력 
	@Override
	public String toString() {
		return "StudentDTO [no=" + no + ", name=" + name + ", phone=" + phone + ", address=" + address + ", birthday="
				+ birthday + "]";
	}
	
}
