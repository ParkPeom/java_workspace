
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
		JPanel panel = new JPanel(); 
		JLabel label = new JLabel("Some text");// ���� ǥ��
		JButton btn1 = new JButton("Click me!!");
		JButton btn2 = new JButton("Exit"); // ��ư ���� 
		JTextArea textArea = new JTextArea();  // ���� �̻� ���� �۾�  <- ��õ 
		JTextField textField = new JTextField(200);  // ���� ���� �۾� ������ 200����  
		JPanel btnPanel = new JPanel();
		panel.setLayout(new BorderLayout()); // ���ϴ� ��Ĵ�� �гε��� ���ϴ� ��ġ�� ���δ� ��� BorderLayout:���� �Ʒ��� �߰� ������ �� ���������� 
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);

		// btn1�� ����� �߰� �ϰڴ�.
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // Ŭ�������� ���� �϶� ( ���� )
				// textArea.append("You are amazing\n");
				label.setText(textArea.getText());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		panel.add(label, BorderLayout.NORTH); // ���� ���ʿ� ��ġ ��Ų��. 
		panel.add(btnPanel,BorderLayout.WEST); // ��ư �г��� ���ʿ� �߰� 
		panel.add(textArea,BorderLayout.CENTER); 
		
		frame.add(panel); // �����ӿ� �г��� ���� �־���� �Ѵ�. 
		
		
		frame.setResizable(true); // �������� ������ �Ժη� ũ�⸦ �����Ҽ��ֳ�  false : ���� ���� 
		frame.setVisible(true); // ���̰� 
		frame.setPreferredSize(new Dimension(840 , 840 / 12 * 9)); // Dimension(���� ����)  
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null); // � ��ġ���� ���α׷��� �⿬��ų���ΰ� null = �ڵ����� ����� ��� 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����α׷� �ൿ ���α׷� ������ ��δ� ���� 
	}
}
