package mainApp;

import java.util.ArrayList;
import java.util.List;
import choice.Choice;
import dto.JoinDTO;
import print.Print;
public class StartApp {
	public StartApp() {
	while(true) {	
		Print.firstprintmenu();
		int choice = Print.setIntMessage("선택 하세요");
		Choice.joinchoicemenu(choice);
		}
	}
	public static void main(String[] args) {
		new StartApp();
	}
}
