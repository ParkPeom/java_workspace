package exception;

import java.util.regex.Pattern;

public class JoinException  {

	public JoinException() {
	
	}
	// ��й�ȣ ��ȿ�� �˻�
	
	// �޴��� : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$
	public static boolean isPhoneNum(String str) {
		//�ڵ�����ȣ ��ȿ��
		if(Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$",str)) {
			return true;
		}
		return false;
	}

	public boolean isNumeric(String str) {
	    return Pattern.matches("^[0-9]*$", str);
	}
	 
	// ���� �˻��
	public boolean isAlpha(String str) {
	    return Pattern.matches("^[a-zA-Z]*$", str);
	}
	 
	// �ѱ��� Ȥ�� ���� �˻��
	public boolean isAlphaNumeric(String str) {
	    return Pattern.matches("[a-zA-Z0-9]*$", str);
	}
	 
	// �ѱ��� �˻��
	public boolean isKorean(String str) {
	    return Pattern.matches("[��-�R]*$", str);
	}
	 
	// �빮�� �˻��
	public boolean isUpper(String str) {
	    return Pattern.matches("^[A-Z]*$", str);
	}
	 
	// �ҹ��� �˻��
	public boolean isDowner(String str) {
	    return Pattern.matches("^[a-z]*$", str);
	}
	 
	// �̸��� �˻��
	public boolean isEmail(String str) {
	    return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", str);
	}
	 
	// URL �˻�� (Http, Https ����)
	public boolean isURL(String str) {
	    return Pattern.matches("^[^((http(s?))\\:\\/\\/)]([0-9a-zA-Z\\-]+\\.)+[a-zA-Z]{2,6}(\\:[0-9]+)?(\\/\\S*)?$",
	            str);
	}
	 
	// phone number checker
	// xxx-xxx-xxxx (���ĸ� ��)
	// - �� ����� ��.
	public boolean isMob(String str) {
	    return Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
	}
	 
	// �Ϲ� ��ȭ �˻��
	public boolean isPhone(String str) {
	    return Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
	}
	 
	// IP �˻��
	public boolean isIp(String str) {
	    return Pattern.matches("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})", str);
	}
	 
	// �����ȣ �˻��
	public boolean isPost(String str) {
	    return Pattern.matches("^\\d{3}\\d{2}$", str);
	}
	 
	// �ֹε�Ϲ�ȣ �˻��
	public boolean isPersonalID(String str) {
	    return Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", str);
	}

}
