package com.codechobo.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class JFrameTest extends JFrame {
	JButton btn = new JButton("Ŭ��");
	JButton btn2 = new JButton("12345");
	JPanel pane = new JPanel(new GridLayout(2,2,10,10));	
	// �г� pane �� ���� ������Ʈ ��ư��
	JButton b1 = new JButton("AAAAA");
	JButton b2 = new JButton("BBBBB");
	JButton b3 = new JButton("CCCCCCCCCCCCC");
	public JFrameTest() {
		
		//������Ʈ ��ư�� JFrame �����̳ʿ� ��ư�� �߰�
		add("West", btn); // ���ʿ� �߰� 
		//���۳�Ʈ�� �������� ���ʿ� �߰�
		add("North",btn2);
		add(BorderLayout.EAST, new JButton("5555"));
		//pane.setLayout(new BorderLayout());
		
		//JPanel : FlowLayout �̴�.
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		
		// ������Ʈ�� ���� �г��� JFrame�� �߰��Ѵ�. 
		add(pane);
		
		//âũ�� ���ϱ� : setSize(), setBounds(), pack()
		//pack();
		// setSize(500,500); // �� ���� ����:px
		setBounds(200,300,400,300); // x , y , w , h
									// ���� �P���� �����ʱ��� x
									// ������ �Ʒ� y
									// w �� 400 , h ���� 300 
		
		//JFrame ���̰� ���� 
		//JFrame ����Ŭ���� �޼ҵ常 ȣ���ϸ� �ȴ�.
		setVisible(true);
		
		//���α׷��� ����Ǹ� �ڿ��� �����ϵ��� ���� 
		// DISPOSE_ON_CLOSE : â�� ������ �ڿ��� ������ 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		JFrameTest ft = new JFrameTest();
		
	}
}
