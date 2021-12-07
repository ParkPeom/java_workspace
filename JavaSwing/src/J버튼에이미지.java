import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class J버튼에이미지 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J버튼에이미지 window = new J버튼에이미지();
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
	public J버튼에이미지() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 976, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 962, 638);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\button.PNG"));
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\button.PNG"));
		btnNewButton.setBounds(380, 279, 246, 83);
		btnNewButton.setPressedIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\button_clicked.PNG")); // 눌렀을때 이미지 
		panel.add(btnNewButton);
	}
}
