package ä�����α׷�;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// ä�� Ŭ���̾�Ʈ ���α׷� - Swing
// => �������� ������ �޼����� ���޹޾� ���۳�Ʈ ��� - �ݺ� ó��
// => ���۳�Ʈ�� �޼����� �Է¹޾� ���� ���� - �̺�Ʈ �ڵ已 �޼ҵ�
public class ChatClientApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField field; // �Է� ���۳�Ʈ 
	private JTextArea area; // ��� ���۳�Ʈ 
	
	//������ ���ϰ� ����� Socket �ν��Ͻ��� �����ϱ� ���� �ʵ�
	private Socket socket;
	
	//�������� ������ �޼����� ���޹ޱ� ���� �Է½�Ʈ���� �����ϱ� ���� �ʵ� 
	private BufferedReader in; 
	
	//�������� �޼����� ������ ��½�Ʈ���� �����ϱ� ���� �ʵ�
	private PrintWriter out;
	
	//��ȭ���� �����ϱ� ���� �ʵ� 
	private String aliasName;
	
	public ChatClientApp(String title) {
		field = new JTextField();
		area = new JTextArea();
		
		JScrollPane pane = new JScrollPane(area);
		getContentPane().add(pane , BorderLayout.CENTER);
		getContentPane().add(field , BorderLayout.SOUTH);
		field.setFont(new Font("����ü",Font.BOLD, 20));
		area.setFont(new Font("����ü",Font.BOLD, 20));
		area.setFocusable(false); // ��Ŀ������ġ�����ʵ��� false
	
		// field.addActionListener( new EventHandler());
		
		// field.addActionListener( new ActionListener()); // �������̽��� �ν��Ͻ��� ���������.
		
		// �������̽��� �ν��Ͻ��� �������� ��ü�� ������ִ� ���
		// �͸��� ���� Ŭ������ �ν��Ͻ��� ����Ͽ� �̺�Ʈ �ڵ鷯 ���
		// �͸��� ���� Ŭ����(Anonymous Inner Class) : �߻�Ŭ���� �Ǵ� �������̽��� ��ӹ��� 
		// �̸��� ���� Ŭ������ �ν��Ͻ��� ���� �ϱ� ���� ���
		// �߻�޼ҵ带 ���� �������̵� �����Ͽ� �ν��Ͻ� �����Ҽ��ִ� 
		// => �ϳ��� �ν��Ͻ��� �����Ͽ� ���α׷��� �ۼ��� ��� ��� 
		field.addActionListener( new ActionListener() {
			// �̺�Ʈ �ڵ鷯 �޼ҵ� 
			// -> JTextField ���۳�Ʈ �Էµ� �޼����� ���� ������ �����ϴ� ��ɾ�
			public void actionPerformed(ActionEvent e) {
				//  JTextField ���۳�Ʈ���� �Էµ� �޼����� ��ȯ�޾� ���� 
				String message = field.getText();
				
				if(!message.equals("")) { // �Է� �޼����� ������ ���
					out.println(message); // ������ �޼����� ����
					field.setText(""); // JTextField ���۳�Ʈ �Է� �ʱ�ȭ 
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,400,500);
		setVisible(true);
		
		try {
			socket = new Socket("192.168.0.23",6000); // ���� ���� 
			
			//Socket �ν��Ͻ��� �Է½�Ʈ���� �����޾� ���ڿ��� ���޹����� �ִ� �Է� ��Ʈ������ 
			//Ȯ���Ͽ� �ʵ忡 ���� 
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
			
			// ��� �ڷ����� ���� ���ڿ��� ��ȯ�Ͽ� �����ϵ� boolean �Ű������� true�� 
			// �����ϸ� ��� ���۸� ������� �ʰ� ������ ����Ÿ�� �����ϴ� �ν��Ͻ��� 
			// �����ϴ� ������ 
			out = new PrintWriter(socket.getOutputStream() , true);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "������ ������ �� �����ϴ�.",
					"���ӿ���",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// ��ȭ���� �Է¹޾� �ʵ忡 ���� - �������� ��ȭ���� �Էµǵ���  �ݺ�ó�� 
		while(true) {
			// �Է� ���̾�α� ����Ͽ� ��ȭ���� �Է¹޾� ���� 
			aliasName = JOptionPane.showInputDialog(this,"��ȭ���� �Է��� �ּ���"
					,"��ȭ�� �Է�",JOptionPane.QUESTION_MESSAGE);
			//�������� ��ȭ���� �Էµ� ��� �ݺ����� ���� 
			if(aliasName != null && !aliasName.equals(""))break;
			
			aliasName = JOptionPane.showInputDialog(this,"��ȭ�����ݵ�� �Է����ּ���"
					,"�Է¿���",JOptionPane.ERROR_MESSAGE);
		}
		// �Է¹��� ��ȭ���� ������ ����
		out.println(aliasName);
		
		// �������� ������ �޼����� ���޹޾� JTextArea ���۳�Ʈ�� �߰��Ͽ� ��� - �ݺ� ó��
		while(true) {
			try {
				area.append(in.readLine() + "\n");
				
				//JTextArea ���۳�Ʈ�� ��ũ���� �� �Ʒ��� �̵�
				// JTextArea ���۳�Ʈ�� ��ũ�� ��ġ�� �����ϴ� �޼��� 
				area.setCaretPosition(area.getText().length()); // ���ϼ��� ��ũ�� ��ġ�� ������ 
				
			} catch(IOException e) {
				aliasName = JOptionPane.showInputDialog(this,"�������� ������ ���������ϴ�."
						,"���ӿ���",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClientApp("ä�����α׷�");
	}

	public class EventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
	}
}
