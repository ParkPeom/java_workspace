package com.codechobo.gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameTest2 {
	JFrame frm = new JFrame();
	JTextField tf = new JTextField();
	public JFrameTest2() {
		frm.add(tf);
		frm.setSize(400,400);
		frm.setVisible(true);
		
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JFrameTest2();
	}
}
