package com.codechobo.guitest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class JFtameTest extends JFrame {
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("12345");
	JPanel pane = new JPanel(new GridLayout(2,2,2,10));
	
	JButton b1 = new JButton("AAAAA");
	JButton b2 = new JButton("BBBBB");
	JButton b3 = new JButton("cccccccccc");

	public JFtameTest() {
	
		// JFrame 컨테이너에 추가 
		add("West",btn1); 
		add("North",btn2);
		add(BorderLayout.EAST , new JButton("55555"));
		
		// JPanel : FlowLayout -> Grid
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		
		add(pane);
		
		setBounds(200,300,400,300);
		
		//JFrame 설정
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		JFtameTest ft = new JFtameTest();
	}
}
