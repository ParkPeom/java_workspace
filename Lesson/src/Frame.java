import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(); // �����Ӿȿ� �Ǵٸ� �������� ����������ְ���
		JPanel btnPanel = new JPanel();
		JLabel label = new JLabel("some text"); // ���� ǥ��
		JButton btn1 = new JButton("Click me"); // ��ư�� �� �۾�
		JButton btn2 = new JButton("Exit"); // ���α׷� ���� ��ư
		JTextArea txtArea = new JTextArea(); // �����̻� �����۾� ������
		JTextField txtField = new JTextField(200); // ���� �۾� ������ (����ũ�⸦ �־������)
		panel.setLayout(new BorderLayout());//�г� ��ü���� �ڱⰡ ���ϴ� ������� �гε��� ���̺� ���ϴ� ��ġ��
											// BorderLayout() : ���������߾� �ڱⰡ ���ϴ� ���⿡
		frame.add(panel); // �����Ӿȿ� �г��� ���� �־�����Ѵ�.	
		
		panel.add(new JLabel("Welcome this lecture"));
		panel.add(label, BorderLayout.NORTH); // new BorderLayout()���� �г��� ����������
		panel.add(btnPanel, BorderLayout.WEST); // ���ʿ� �߰� 
		btnPanel.add(btn1); // ��ư�гο� ��ư���۳�Ʈ �߰�
		btnPanel.add(btn2);
		
		btn1.addActionListener(new ActionListener(){ // ��ư�� �������� ����� �߰��ϰڴ�.

			@Override
			public void actionPerformed(ActionEvent e) { // �� ����� Ŭ���� �Ҷ� ���� �ض� ���� ��ư ��� �߰� ����
				// txtArea.append("You are amazing!"); // ��ưŬ���� txtArea�� �۾� �߰� 
				label.setText(txtArea.getText()); // ���ڸ� ���� �Է��Ѱ����� ���ǳ����� ������
			}		
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // ��ưŬ���� ���α׷� ���� 
			
			}
		});
		
		panel.add(txtArea, BorderLayout.CENTER); 
		
		
		frame.setResizable(false); // �������� ������ �Ժη� ũ�⸦ �����Ҽ��ֳ�. true : ���Կ�����
		frame.setVisible(true); // ȭ�鿡 ���̰� �Ѵ�.
		frame.setPreferredSize(new Dimension(840, 840/12*9)); // ���ϴ� ������� Dimension(����,����) , ����ȭ���̸� ����ȭ�鿡 �°� 
		frame.setSize(840, 840/12*9); 
		frame.setLocationRelativeTo(null); // ��ǻ�� ����뿡�� ��Ÿ���� �Ѵ�.
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); // ������ �츮�� ���ϴ� ��
															 // frame.EXIT_ON_CLOSE ���α׷� ������ ���� ����
		// JFrame �ϳ��� Ʋ  �г� : ���̰�, ���� �Ⱥ��̰� ���������� �������ִ�.
		
	}
}
