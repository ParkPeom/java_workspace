package xyz.itwill.thread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//날짜와 시간을 출력하는 GUI 프로그램
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//날짜와 시간을 출력하기 위한 컴퍼넌트
	private JLabel clockLabel;
	
	//스레드를 일시 중지하거나 다시 실행하기 위한 컴퍼넌트
	private JButton startBtn, stopBtn;
	
	//날짜와 시간을 변경하는 스레드의 실행 상태를 저장하기 위한 필드
	// => false : 스레드 중지 상태, true : 스레드 동작 상태(기본)
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		super(title);//JFrame 생성자를 이용하여 프레임의 제목 설정
		
		isRun=true;
		
		//clockLabel=new JLabel("2021년 12월 09일 15시 42분 20초", JLabel.CENTER);
		clockLabel=new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("굴림",Font.BOLD,30));
		clockLabel.setForeground(Color.DARK_GRAY);
		
		startBtn=new JButton("다시 실행");
		stopBtn=new JButton("일시 중지");
		
		JPanel panel=new JPanel();
		panel.add(startBtn);
		panel.add(stopBtn);
		startBtn.setFont(new Font("굴림",Font.BOLD,20));
		stopBtn.setFont(new Font("굴림",Font.BOLD,20));
		startBtn.setEnabled(false);
		
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);

		//새로운 스레드를 생성하여 run() 메소드의 명령 실행
		// => 시스템의 현재 날짜와 시간이 원하는 형식의 문자열로 JLabel 컴퍼넌트로 출력
		new ClockThread().start();
		
		//JButton 컴퍼넌트를 누르면 발생되는 ActionEvent를 처리하기 위한 이벤트 핸들러
		//클래스를 인스턴스로 생성하여 등록 - 이벤트 발생시 이벤트 처리 메소드 자동 호출
		startBtn.addActionListener(new JButtonEventHandler());
		stopBtn.addActionListener(new JButtonEventHandler());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,600,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("DigitalClock");
	}
	
	//내부클래스(Inner Class) : 클래스 내부에 선언된 클래스
	// => 내부클래스에서는 접근지정자에 상관 없이 외부클래스의 필드 또는 메소드 사용 가능
	// => 내부클래스는 외부클래스가 아닌 다른 클래스에서 인스턴스 생성 불가능
	//시스템(운영체제 : OS)의 현재 날짜와 시간을 얻어와 JLabel 컴퍼넌트를 변경하는 스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			//SimpleDateFormat : 날짜와 시간을 원하는 패턴으로 표현하기 위한 클래스
			// => 패턴 : y(년), M(월), d(일), H(시-24), h(시-12), m(분), s(초), E(요일), AM, PM 등
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			
			while(true) {
				if(isRun) {
					//Date : 날짜와 시간을 저장하는 클래스
					// => Date 클래스의 기본 생성자로 인스턴스를 생성하면 시스템의 현재  
					//    날짜와 시간이 Date 인스턴스에 저장 
					Date now=new Date();
					//SimpleDateFormat.format(Date date) : Date 인스턴스를 전달받아 SimpleDateFormat
					//인스턴스의 패턴의 문자열로 변환하여 반환하는 메소드
					String clock=dateFormat.format(now);
					//JLabel 컴퍼넌트의 텍스트(Text)를 현재 날짜와 시간으로 변경
					clockLabel.setText(clock);
				}
				//1초동안 스레드을 일시 중지
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//JButton 컴퍼넌트를 누른 경우 동작될 이벤트 핸들러 클래스
	public class JButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource==startBtn) {
				isRun=true;//생성된 스레드가 run() 메소드의 명령을 실행하도록 필드값 변경
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			} else if(eventSource==stopBtn) {
				isRun=false;//생성된 스레드가 run() 메소드의 명령을 실행하지 않도록 필드값 변경
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
			}
		}
	}
}










