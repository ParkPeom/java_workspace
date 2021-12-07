package com.computer;

import java.util.Scanner;

public class ComputerApp {
	Scanner sc;
	public ComputerApp() {
		sc = new Scanner(System.in);
	}
	
	public void start() {
		String num = messageSet(" Ã¹Á¤¼ö");
		
	}
	
	public String messageSet(String msg) {
		System.out.print(msg + "=");
		String s = sc.nextLine();
		return s;
	}
	public static void main(String[] args) {
		new ComputerApp().start();
	}
}
