package ������ư;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* ������ư - �׷��� �̿��Ͽ� ���߿��� �ϳ��� ���� ����
 * üũ�ڽ� - ������ ���� ���� 
 */

public class RadioButtons {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JRadioButton korBtn = new JRadioButton("Korean");
		JRadioButton engBtn = new JRadioButton("English");
		JRadioButton chiBtn = new JRadioButton("Chinese");
		
		ButtonGroup group = new ButtonGroup();
		
		korBtn.setActionCommand("kor"); // korean ���������� ���� ���� kor�� 
		engBtn.setActionCommand("eng");
		chiBtn.setActionCommand("chi");
		
		// �׷쿡 ��ư �ϳ��� �߰�
		group.add(korBtn);
		group.add(engBtn);
		group.add(chiBtn);
		// ���� ũ�� ����
		Font font = new Font("Arial",Font.BOLD , 24);
		korBtn.setFont(font);
		engBtn.setFont(font);
		chiBtn.setFont(font);
		
		// �����ư�� �ڵ����� �߰��Ǿ��ִ� ���¸����
		engBtn.setSelected(true);
		
		// �ѱ� ��ư�� �������� 
		korBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand()); // ���õ� ���� ��ư���� ���� ������
				
			}
		});
		
		engBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand()); // ���õ� ���� ��ư���� ���� ������
				
			}
		});
		
		chiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand()); // ���õ� ���� ��ư���� ���� ������
				
			}
		});
		
		// �гο� �ϸ��� �߰��������
		panel.add(korBtn);
		panel.add(engBtn);
		panel.add(chiBtn);
		
		
		// �����ӿ� �߰����г��� �߰������ �Ѵ�.
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
