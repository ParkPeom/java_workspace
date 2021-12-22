package 테이블;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Example2 {
	public static void main(String[] args) {
		Dimension dim = new Dimension(400,300); // 폭과 높이를 캡슐화 해줌
		
		JFrame frame = new JFrame("Morph's House"); // 창
		frame.setLocation(200, 400); // 수학시간 좌표계 x좌표값 200 , y좌표값 400
		frame.setPreferredSize(dim); // JFrame 크기 조절  
		
		String header[] = {"학생이름","국어","영어","수학"}; // 컬럼명 
		String contents[][] = { // 데이터 
				{"박명수","94","82","91"} ,
				{"김영희","100","99","100"} ,
				{"김철수","30","25","11"} ,
		};
		DefaultTableModel model = new DefaultTableModel(contents,header); // 리모콘
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		
		// 프레임 안에 패널 
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		// 컴포넌트 텍스트 필드 생성 
		JTextField nameField = new JTextField(5);
		JTextField subject1 = new JTextField(3);
		JTextField subject2 = new JTextField(3);
		JTextField subject3 = new JTextField(3);
		
		// 추가한 컴포넌트를 패널에 추가
		panel.add(nameField);
		panel.add(subject1);
		panel.add(subject2);
		panel.add(subject3);
		
		// 추가 버튼 추가
		JButton addBtn = new JButton("추가");
		addBtn.addActionListener(new ActionListener() {
			// 추가 버튼울 눌렀을떄	
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[4];
				inputStr[0] = nameField.getText();
				inputStr[1] = subject1.getText();
				inputStr[2] = subject2.getText();
				inputStr[3] = subject3.getText();
				
				
				model.addRow(inputStr); // model 에 행 추가
				
				nameField.setText("");
				subject1.setText("");
				subject2.setText("");
				subject3.setText("");
			}
		});
		JButton cancelBtn = new JButton("삭제");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 삭제 하려는데 테이블의 행 값이 없으면 ?
				if(table.getSelectedRow() == -1) {
					return; 
				} else {
					// 구현된 메서드를 불러와서 쓴다.
					
					// 삭제시 
					// DefaultTableModel.removeRow(JTable.getSelectedRow());
					// JTable에서 선택한 셀의 row값을 int로 반환하는 메소드입니다.
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		panel.add(addBtn);
		panel.add(cancelBtn);
		frame.add(scrollpane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}
