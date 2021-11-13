package com.codechobo.gui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;								
import java.awt.Color;

// action이벤트가 발생하면 실행할 실행문을 기술하기 위해서
public class SourceView extends JFrame implements ActionListener{
	//frame - north
	JPanel pane = new JPanel(new BorderLayout());
	JLabel lbl = new JLabel("URL : ");
	JTextField tf = new JTextField();
	JButton btn = new JButton("소스보기");
	
	//frame - center
	JTextArea ta = new JTextArea();
	JButton endBtn = new JButton("종료");
	
	//글꼴 , 유형 , 글자크기(px) 
	Font fnt = new Font("궁서체",Font.ITALIC,30);
	public SourceView() {
		tf.setFont(fnt);
		tf.setForeground(Color.RED); // 글자색
		tf.setBackground(Color.YELLOW); // 배경색
		tf.setBackground(new Color(100,200,150)); // RGB
		//north
		pane.add("West",lbl);
		pane.add("Center",tf);
		pane.add("East",btn);
		
		add("North",pane);
		
		//center
		JScrollPane sp = new JScrollPane(ta); // JTextArea 에 스크롤바 추가
		add("Center",sp);
		
		add("South",endBtn);
		add("East",new JTableTest(fnt)); // JTableTest 패널을 추가시킨다.
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// JVM한테 이벤트가 있다고 알려줌 - 등록
		// this : 이벤트가 발생시 자바가상머신이 호출하여 실행할 메소드가 현재 클래스에 있다는 뜻
		// 다른클래스에 있으면 객체로 만들어서 알려줘야 함
		btn.addActionListener(this);
		endBtn.addActionListener(this);
		// 키보드의 enter에 의해서 이벤트가 발생한다.
		tf.addActionListener(this);
	}
	
	// JVM한테 등록하고 나서 actionPerformed 이 어디있는지 알려줘야 한다. (다른클래스에 있을수도있으니)
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생한 컴포넌트 알아내기
		//1. 버튼의 라벨을 구하여 구별하기
		//String event = e.getActionCommand();
		//System.out.println(event);
		//2. 이벤트가 발생한 객체를 구해온다
		Object obj = e.getSource(); // 이벤트가 발생한 객체들이 들어감
		
		/*if(obj == btn) {
			System.out.println("소스보기");
		} else if(obj == endBtn) {
			System.out.println("종료");
		} else if(obj == tf) {
			System.out.println("tf");
		}*/
		// 버튼으로 만든건지 텍스트필드로 만든건지 확인작업 
		// 객체	instanceof  클래스명 
		/*if(obj instanceof JButton) {
			System.out.println("JButton");
		} else if(obj instanceof JTextField) {
			System.out.println("JTextField");
		}*/
		if(obj == btn || obj == tf) { // 소스를 가져오기
			try {
			//tf의 문자얻어오기
			String txt = tf.getText(); // https://www.nate.com
			URL url = new URL(txt);
			
			//현재페이지의 Header정보얻어오기
			URLConnection conn = url.openConnection();
			//통신채널확보
			conn.connect();//통신채널확보
			
			String type = conn.getContentType();
			System.out.println("type->"+type);
			
			// charset=utf-8 에서 = 를 찾아서 
			String code = type.substring(type.lastIndexOf("=") + 1);
			System.out.println("type->"+type+",code"+code);
			
			//InputStream 데이터를 한바이트씩 읽음
			InputStream is = url.openStream(); 
			
			// 한글이 있으면 InputStreamReader 
			//  code = utf-8
			// InputStreamReader(InputStream in, String charsetName)
			InputStreamReader isr = new InputStreamReader(is,code); // 문자들읽음
			BufferedReader br = new BufferedReader(isr);
//			ta.setText(""); // ta에 값이 있으면 초기화 한다.
			
			while(true) {
				String src = br.readLine(); // 한줄을 읽는다. 엔터가 제외한
				if(src==null) break;
				ta.append(src+"\n");
				}
			} catch(Exception ee) {
				ee.printStackTrace();
		}
			
		}else if(obj == endBtn) {
			dispose();//자원해제
			System.exit(0);//프로그램 종료 
		}
	}
	
	public static void main(String[] args) {
		new SourceView();
	}

}
