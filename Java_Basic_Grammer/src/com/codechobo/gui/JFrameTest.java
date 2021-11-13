package com.codechobo.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class JFrameTest extends JFrame {
	JButton btn = new JButton("클릭");
	JButton btn2 = new JButton("12345");
	JPanel pane = new JPanel(new GridLayout(2,2,10,10));	
	// 패널 pane 에 담을 컴포넌트 버튼들
	JButton b1 = new JButton("AAAAA");
	JButton b2 = new JButton("BBBBB");
	JButton b3 = new JButton("CCCCCCCCCCCCC");
	public JFrameTest() {
		
		//컴포넌트 버튼을 JFrame 컨테이너에 버튼을 추가
		add("West", btn); // 서쪽에 추가 
		//컴퍼넌트를 프레임의 북쪽에 추가
		add("North",btn2);
		add(BorderLayout.EAST, new JButton("5555"));
		//pane.setLayout(new BorderLayout());
		
		//JPanel : FlowLayout 이다.
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		
		// 컴포넌트를 담은 패널을 JFrame에 추가한다. 
		add(pane);
		
		//창크기 정하기 : setSize(), setBounds(), pack()
		//pack();
		// setSize(500,500); // 폭 높이 단위:px
		setBounds(200,300,400,300); // x , y , w , h
									// 왼쪽 긑에서 오른쪽까지 x
									// 위에서 아래 y
									// w 폭 400 , h 높이 300 
		
		//JFrame 보이게 설정 
		//JFrame 상위클래스 메소드만 호출하면 된다.
		setVisible(true);
		
		//프로그램이 종료되면 자원을 해제하도록 설정 
		// DISPOSE_ON_CLOSE : 창을 닫으면 자원을 해제함 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		JFrameTest ft = new JFrameTest();
		
	}
}
