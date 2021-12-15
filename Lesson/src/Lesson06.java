import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson06 {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson06 window = new Lesson06();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Lesson06() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson06");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false); // 사이즈를 변경 할수 없도록 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(0, 0, 786, 573);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton btnBefore = new JButton("GO TO LAST");
	
		btnBefore.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
		btnBefore.setBounds(450, 137, 243, 306);
		endPage.add(btnBefore);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(0, 10, 786, 563);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);
		
		JButton btnNext = new JButton("GO TO NEXT");
		
		endPage.setVisible(false); // 처음시작할때 startPage만 보여줄수있도록
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
			}
		});
		btnNext.setBounds(60, 128, 257, 308);
		
		startPage.add(btnNext);
		
		btnBefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(false);
				startPage.setVisible(true);
			}
		});
	
	}
}
