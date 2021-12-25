
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
		JLabel label = new JLabel("Some text");// 글자 표시
		JButton btn1 = new JButton("Click me!!");
		JButton btn2 = new JButton("Exit"); // 버튼 종료 
		JTextArea textArea = new JTextArea();  // 한줄 이상 많은 글씨  <- 추천 
		JTextField textField = new JTextField(200);  // 한줄 정도 글씨 넣을떄 200글자  
		JPanel btnPanel = new JPanel();
		panel.setLayout(new BorderLayout()); // 원하는 방식대로 패널들을 원하는 위치에 놔두는 기능 BorderLayout:위쪽 아래쪽 중간 오른쪽 에 놓을수있음 
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);

		// btn1에 기능을 추가 하겠다.
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 클릭했을때 무언가 하라 ( 지시 )
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
		
		panel.add(label, BorderLayout.NORTH); // 라벨을 북쪽에 위치 시킨다. 
		panel.add(btnPanel,BorderLayout.WEST); // 버튼 패널을 서쪽에 추가 
		panel.add(textArea,BorderLayout.CENTER); 
		
		frame.add(panel); // 프레임에 패널을 직접 넣어줘야 한다. 
		
		
		frame.setResizable(true); // 프레임을 했을떄 함부로 크기를 조절할수있나  false : 조절 못함 
		frame.setVisible(true); // 보이게 
		frame.setPreferredSize(new Dimension(840 , 840 / 12 * 9)); // Dimension(가로 세로)  
		frame.setSize(840, 840/12*9);
		frame.setLocationRelativeTo(null); // 어떤 위치에서 프로그램을 출연시킬것인가 null = 자동으로 가운대 출력 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 껏을때 이프로그램 행동 프로그램 껏을때 모두다 종료 
	}
}
