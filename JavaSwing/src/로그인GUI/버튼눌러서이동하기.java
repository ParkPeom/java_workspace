package �α���GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ��ư�������̵��ϱ� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					��ư�������̵��ϱ� window = new ��ư�������̵��ϱ�();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ��ư�������̵��ϱ�() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson06");
		frame.setBounds(100, 100, 1022, 734);
		frame.setLocationRelativeTo(null); // �߾ӿ��� ��Ÿ���� 
		frame.setResizable(false); // ������ �����Ҽ� ����  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 1008, 687);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton btnBefore = new JButton("GO TO LAST");
		btnBefore.setFont(new Font("����", Font.PLAIN, 26));
		btnBefore.setBounds(26, 21, 442, 629);
		endPage.add(btnBefore);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 0, 1008, 687);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton btnNext = new JButton("GO TO NEXT");
		btnNext.setFont(new Font("����", Font.PLAIN, 26));
		btnNext.setBounds(527, 27, 449, 624);
		startPage.add(btnNext);
		
		endPage.setVisible(false); // ù�������� ���������� �Ⱥ��̱� 
		
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		
		btnBefore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(false);
				startPage.setVisible(true);
			}
		});
		
	}
}
