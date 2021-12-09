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

//��¥�� �ð��� ����ϴ� GUI ���α׷�
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//��¥�� �ð��� ����ϱ� ���� ���۳�Ʈ
	private JLabel clockLabel;
	
	//�����带 �Ͻ� �����ϰų� �ٽ� �����ϱ� ���� ���۳�Ʈ
	private JButton startBtn, stopBtn;
	
	//��¥�� �ð��� �����ϴ� �������� ���� ���¸� �����ϱ� ���� �ʵ�
	// => false : ������ ���� ����, true : ������ ���� ����(�⺻)
	private boolean isRun;
	
	public DigitalClockApp(String title) {
		super(title);//JFrame �����ڸ� �̿��Ͽ� �������� ���� ����
		
		isRun=true;
		
		//clockLabel=new JLabel("2021�� 12�� 09�� 15�� 42�� 20��", JLabel.CENTER);
		clockLabel=new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("����",Font.BOLD,30));
		clockLabel.setForeground(Color.DARK_GRAY);
		
		startBtn=new JButton("�ٽ� ����");
		stopBtn=new JButton("�Ͻ� ����");
		
		JPanel panel=new JPanel();
		panel.add(startBtn);
		panel.add(stopBtn);
		startBtn.setFont(new Font("����",Font.BOLD,20));
		stopBtn.setFont(new Font("����",Font.BOLD,20));
		startBtn.setEnabled(false);
		
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);

		//���ο� �����带 �����Ͽ� run() �޼ҵ��� ��� ����
		// => �ý����� ���� ��¥�� �ð��� ���ϴ� ������ ���ڿ��� JLabel ���۳�Ʈ�� ���
		new ClockThread().start();
		
		//JButton ���۳�Ʈ�� ������ �߻��Ǵ� ActionEvent�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯
		//Ŭ������ �ν��Ͻ��� �����Ͽ� ��� - �̺�Ʈ �߻��� �̺�Ʈ ó�� �޼ҵ� �ڵ� ȣ��
		startBtn.addActionListener(new JButtonEventHandler());
		stopBtn.addActionListener(new JButtonEventHandler());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,600,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("DigitalClock");
	}
	
	//����Ŭ����(Inner Class) : Ŭ���� ���ο� ����� Ŭ����
	// => ����Ŭ���������� ���������ڿ� ��� ���� �ܺ�Ŭ������ �ʵ� �Ǵ� �޼ҵ� ��� ����
	// => ����Ŭ������ �ܺ�Ŭ������ �ƴ� �ٸ� Ŭ�������� �ν��Ͻ� ���� �Ұ���
	//�ý���(�ü�� : OS)�� ���� ��¥�� �ð��� ���� JLabel ���۳�Ʈ�� �����ϴ� ������ Ŭ����
	public class ClockThread extends Thread {
		@Override
		public void run() {
			//SimpleDateFormat : ��¥�� �ð��� ���ϴ� �������� ǥ���ϱ� ���� Ŭ����
			// => ���� : y(��), M(��), d(��), H(��-24), h(��-12), m(��), s(��), E(����), AM, PM ��
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
			
			while(true) {
				if(isRun) {
					//Date : ��¥�� �ð��� �����ϴ� Ŭ����
					// => Date Ŭ������ �⺻ �����ڷ� �ν��Ͻ��� �����ϸ� �ý����� ����  
					//    ��¥�� �ð��� Date �ν��Ͻ��� ���� 
					Date now=new Date();
					//SimpleDateFormat.format(Date date) : Date �ν��Ͻ��� ���޹޾� SimpleDateFormat
					//�ν��Ͻ��� ������ ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
					String clock=dateFormat.format(now);
					//JLabel ���۳�Ʈ�� �ؽ�Ʈ(Text)�� ���� ��¥�� �ð����� ����
					clockLabel.setText(clock);
				}
				//1�ʵ��� �������� �Ͻ� ����
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//JButton ���۳�Ʈ�� ���� ��� ���۵� �̺�Ʈ �ڵ鷯 Ŭ����
	public class JButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource==startBtn) {
				isRun=true;//������ �����尡 run() �޼ҵ��� ����� �����ϵ��� �ʵ尪 ����
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			} else if(eventSource==stopBtn) {
				isRun=false;//������ �����尡 run() �޼ҵ��� ����� �������� �ʵ��� �ʵ尪 ����
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
			}
		}
	}
}










