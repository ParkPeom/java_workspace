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

// action�̺�Ʈ�� �߻��ϸ� ������ ���๮�� ����ϱ� ���ؼ�
public class SourceView extends JFrame implements ActionListener{
	//frame - north
	JPanel pane = new JPanel(new BorderLayout());
	JLabel lbl = new JLabel("URL : ");
	JTextField tf = new JTextField();
	JButton btn = new JButton("�ҽ�����");
	
	//frame - center
	JTextArea ta = new JTextArea();
	JButton endBtn = new JButton("����");
	
	//�۲� , ���� , ����ũ��(px) 
	Font fnt = new Font("�ü�ü",Font.ITALIC,30);
	public SourceView() {
		tf.setFont(fnt);
		tf.setForeground(Color.RED); // ���ڻ�
		tf.setBackground(Color.YELLOW); // ����
		tf.setBackground(new Color(100,200,150)); // RGB
		//north
		pane.add("West",lbl);
		pane.add("Center",tf);
		pane.add("East",btn);
		
		add("North",pane);
		
		//center
		JScrollPane sp = new JScrollPane(ta); // JTextArea �� ��ũ�ѹ� �߰�
		add("Center",sp);
		
		add("South",endBtn);
		add("East",new JTableTest(fnt)); // JTableTest �г��� �߰���Ų��.
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// JVM���� �̺�Ʈ�� �ִٰ� �˷��� - ���
		// this : �̺�Ʈ�� �߻��� �ڹٰ���ӽ��� ȣ���Ͽ� ������ �޼ҵ尡 ���� Ŭ������ �ִٴ� ��
		// �ٸ�Ŭ������ ������ ��ü�� ���� �˷���� ��
		btn.addActionListener(this);
		endBtn.addActionListener(this);
		// Ű������ enter�� ���ؼ� �̺�Ʈ�� �߻��Ѵ�.
		tf.addActionListener(this);
	}
	
	// JVM���� ����ϰ� ���� actionPerformed �� ����ִ��� �˷���� �Ѵ�. (�ٸ�Ŭ������ ��������������)
	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ�� �߻��� ������Ʈ �˾Ƴ���
		//1. ��ư�� ���� ���Ͽ� �����ϱ�
		//String event = e.getActionCommand();
		//System.out.println(event);
		//2. �̺�Ʈ�� �߻��� ��ü�� ���ؿ´�
		Object obj = e.getSource(); // �̺�Ʈ�� �߻��� ��ü���� ��
		
		/*if(obj == btn) {
			System.out.println("�ҽ�����");
		} else if(obj == endBtn) {
			System.out.println("����");
		} else if(obj == tf) {
			System.out.println("tf");
		}*/
		// ��ư���� ������� �ؽ�Ʈ�ʵ�� ������� Ȯ���۾� 
		// ��ü	instanceof  Ŭ������ 
		/*if(obj instanceof JButton) {
			System.out.println("JButton");
		} else if(obj instanceof JTextField) {
			System.out.println("JTextField");
		}*/
		if(obj == btn || obj == tf) { // �ҽ��� ��������
			try {
			//tf�� ���ھ�����
			String txt = tf.getText(); // https://www.nate.com
			URL url = new URL(txt);
			
			//������������ Header����������
			URLConnection conn = url.openConnection();
			//���ä��Ȯ��
			conn.connect();//���ä��Ȯ��
			
			String type = conn.getContentType();
			System.out.println("type->"+type);
			
			// charset=utf-8 ���� = �� ã�Ƽ� 
			String code = type.substring(type.lastIndexOf("=") + 1);
			System.out.println("type->"+type+",code"+code);
			
			//InputStream �����͸� �ѹ���Ʈ�� ����
			InputStream is = url.openStream(); 
			
			// �ѱ��� ������ InputStreamReader 
			//  code = utf-8
			// InputStreamReader(InputStream in, String charsetName)
			InputStreamReader isr = new InputStreamReader(is,code); // ���ڵ�����
			BufferedReader br = new BufferedReader(isr);
//			ta.setText(""); // ta�� ���� ������ �ʱ�ȭ �Ѵ�.
			
			while(true) {
				String src = br.readLine(); // ������ �д´�. ���Ͱ� ������
				if(src==null) break;
				ta.append(src+"\n");
				}
			} catch(Exception ee) {
				ee.printStackTrace();
		}
			
		}else if(obj == endBtn) {
			dispose();//�ڿ�����
			System.exit(0);//���α׷� ���� 
		}
	}
	
	public static void main(String[] args) {
		new SourceView();
	}

}
