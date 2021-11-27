package dto;

import java.util.HashMap;

public class EmployDTO {

	private int empno;
	private String name;
	private String tel;
	private String job;
	private String gender;
	
	public EmployDTO() {}

	
	
	public EmployDTO(int empno, String name, String tel, String job, String gender) {
		super();
		this.empno = empno;
		this.name = name;
		this.tel = tel;
		this.job = job;
		this.gender = gender;
	}



	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
