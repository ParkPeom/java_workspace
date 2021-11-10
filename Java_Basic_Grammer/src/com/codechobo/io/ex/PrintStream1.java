package com.codechobo.io.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintStream1 {

	public PrintStream1() {
	}
	
	public static void main(String[] args) {
		File f = new File("C:\\javaFile","love.txt");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(f));
			// �Է� 
			pw.print("Morph");
			pw.print(" House ");
			pw.print("");
			pw.print("Welcome!!");
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("������ ã���� �����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
