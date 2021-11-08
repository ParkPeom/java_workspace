package com.codechobo.collection;

public class MemberVO {
	private int num;// 번호
	private String userid;// 이름
	private String tel;// 연락처
	public MemberVO() {
		
	}
	///////
	MemberVO(int num,String userid,String tel){
		this.num = num;
		this.userid = userid;
		this.tel = tel;
	}
	/////////////////////
	//회원정보를 콘솔에 출력하는 메소드
	public void memberOutput() {
		System.out.printf("%d\t %s\t %s \n",num,userid,tel);
	}
	/////////////////////
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		//1~200사이의 값만 정상 사원번호일때 
		if(num>=1 && num<=200) {
			this.num = num;
		} else {
			System.out.println("사원번호를 잘못입력하였습니다.");			
		}
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTel() {
		// 로그인 여부
		// 실행
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
