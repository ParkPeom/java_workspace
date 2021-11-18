package com.codechobo.studeygroup_ебаЬ;

public class InvenLogin {
	private String id="admin";
	private String pw="1234";
	
	public boolean InvenLogin(String inputid, String inputpw) {
		if(id.equals(inputid) && (pw.equals(inputpw))) {
			return true;
		} else {
			return false;
		}
		
	}

}
