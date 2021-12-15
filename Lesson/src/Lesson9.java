import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Lesson9 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson9 window = new Lesson9();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Lesson9() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 809, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 795, 442);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\\uC790\uBC14\\eclipse-workspace\\Lesson\\image\\button.jpg"));
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\6.PNG"));
		btnNewButton.setBounds(295, 177, 252, 76);
		btnNewButton.setPressedIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\자바\\eclipse-workspace\\Lesson\\image\\btnClicked.jpg")); // 버튼울 눌렀을때 아이콘 
		panel.add(btnNewButton);
	}

}
