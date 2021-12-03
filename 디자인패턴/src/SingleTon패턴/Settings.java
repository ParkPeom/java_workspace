package SingleTon∆–≈œ;

public class Settings {
	private boolean darkMode = false;
	private int fontSize = 13;
	
	private Settings() {};
	
	private static Settings settings = null;
	
	public static Settings getSettings() {
		if(settings == null) {
			settings = new Settings();
		}
		return settings;
	}
		
	public boolean getDarkMode() {
		return darkMode;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setDarkMode(boolean _darkMode) {
		darkMode = _darkMode;
	}
	
	public void setFontSize(int _fontSize) {
		fontSize = _fontSize;
	}
}
