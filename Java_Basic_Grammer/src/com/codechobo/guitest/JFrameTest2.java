package com.codechobo.guitest;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameTest2 extends JFrame {
	
	JFrame frm = new JFrame();
	JTextField jtf = new JTextField();
	
	public JFrameTest2() {
	
		frm.add(jtf);
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		new JFrameTest2();
		
	}
}
