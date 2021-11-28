package exception;

import java.util.regex.Pattern;

public class JoinException  {

	public JoinException() {
	
	}
	// ºñ¹Ð¹øÈ£ À¯È¿¼º °Ë»ç
	
	// ÈÞ´ëÆù : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$
	public static boolean isPhoneNum(String str) {
		//ÇÚµåÆù¹øÈ£ À¯È¿¼º
		if(Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$",str)) {
			return true;
		}
		return false;
	}

	public boolean isNumeric(String str) {
	    return Pattern.matches("^[0-9]*$", str);
	}
	 
	// ¿µ¾î °Ë»ç±â
	public boolean isAlpha(String str) {
	    return Pattern.matches("^[a-zA-Z]*$", str);
	}
	 
	// ÇÑ±¹¾î È¤Àº ¿µ¾î °Ë»ç±â
	public boolean isAlphaNumeric(String str) {
	    return Pattern.matches("[a-zA-Z0-9]*$", str);
	}
	 
	// ÇÑ±¹¾î °Ë»ç±â
	public boolean isKorean(String str) {
	    return Pattern.matches("[°¡-ÆR]*$", str);
	}
	 
	// ´ë¹®ÀÚ °Ë»ç±â
	public boolean isUpper(String str) {
	    return Pattern.matches("^[A-Z]*$", str);
	}
	 
	// ¼Ò¹®ÀÚ °Ë»ç±â
	public boolean isDowner(String str) {
	    return Pattern.matches("^[a-z]*$", str);
	}
	 
	// ÀÌ¸ÞÀÏ °Ë»ç±â
	public boolean isEmail(String str) {
	    return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", str);
	}
	 
	// URL °Ë»ç±â (Http, Https Á¦¿Ü)
	public boolean isURL(String str) {
	    return Pattern.matches("^[^((http(s?))\\:\\/\\/)]([0-9a-zA-Z\\-]+\\.)+[a-zA-Z]{2,6}(\\:[0-9]+)?(\\/\\S*)?$",
	            str);
	}
	 
	// phone number checker
	// xxx-xxx-xxxx (Çü½Ä¸¸ ºñ±³)
	// - Àº ¾ø¾î¾ß ÇÔ.
	public boolean isMob(String str) {
	    return Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
	}
	 
	// ÀÏ¹Ý ÀüÈ­ °Ë»ç±â
	public boolean isPhone(String str) {
	    return Pattern.matches("^\\d{2,3}\\d{3,4}\\d{4}$", str);
	}
	 
	// IP °Ë»ç±â
	public boolean isIp(String str) {
	    return Pattern.matches("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})", str);
	}
	 
	// ¿ìÆí¹øÈ£ °Ë»ç±â
	public boolean isPost(String str) {
	    return Pattern.matches("^\\d{3}\\d{2}$", str);
	}
	 
	// ÁÖ¹Îµî·Ï¹øÈ£ °Ë»ç±â
	public boolean isPersonalID(String str) {
	    return Pattern.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$", str);
	}

}
