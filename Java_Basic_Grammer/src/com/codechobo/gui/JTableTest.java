package com.codechobo.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// 프레임안에 프레임을 못담음 그럼.. 프레임안에 넣으려면 패널로...바꾼다 

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

//public class JTableTest extends JFrame {
// JPanel 기본 레이아웃은 FlowLayout 이다.
// 그래서 setLayout(new BorderLayout()); BorderLayout으로 설정해줘야함

// implements MouseListener 마우스 이벤트 등록 
public class JTableTest extends JPanel implements MouseListener {
	JTable table;
	//타이틀로 사용할 배열 
	Object[] title = {"번호","이름","연락처"};
	Object[][] data = {{1,"홍길동1","010-1234-5678"},
					   {2,"홍길동2","010-1234-8888"},
					   {3,"홍길동3","010-1234-6666"},
					   {4,"홍길동4","010-1234-4444"},};
	
	//JTable에 셋팅할 제목과 데이터를 가지는 객체
	DefaultTableModel model;
	JScrollPane sp;
	Font fnt;
	JLabel lb1 = new JLabel("선택한 목록이 표시되는 곳");
	
	public JTableTest() {
		setLayout(new BorderLayout());
		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		
		// addMouseListener : 마우스 이벤트를 등록 
		
		add("South",lb1); 
		
//		setSize(500,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 이벤트 등록
		table.addMouseListener(this);
	}
	// 객체를 다른클래스에 넘겨주고 싶을때는?
	public JTableTest(Font fnt) {
		// 같은 클래스의 생성자메소드의 다른 생성자를 호출하기
		// 반드시 첫번째 실행문 이어야 한다. 
		
		this(); // JTableTest() 호출
		this.fnt = fnt;
		lb1.setFont(fnt);
	}
	
	//--------------------- implements MouseListener 오버라이딩
	@Override
	public void mouseClicked(MouseEvent e) { // 클릭하면 
	}

	@Override
	public void mousePressed(MouseEvent e) { // 누르면
	}

	@Override
	public void mouseReleased(MouseEvent e) { // 눌렀다 놓으면
		// 마우스를 누른 후 놓으면				// 들어오면 e에는 컴포넌트의 정보가 담겨있다.
		//마우스 ->1:왼쪽, 2:휠, 3:오른쪽 버튼
		if(e.getButton()==1) {
			//선택된 행의 index가져오기
			int rowIdx = table.getSelectedRow(); // 선택된 행번호
			System.out.println("선택된 행의 index ->" + rowIdx);
			
			// 반복문 칸수만큼 돌림
			String txt = "";
			for(int i = 0; i < table.getColumnCount();i++) {
				Object obj = table.getValueAt(rowIdx, i); // 행번호 열번호 
				txt += obj +", ";
			}
			// 반복이 끝나면 선택한 라벨에 정보를 출력 
			lb1.setText(txt);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {  
											 
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
//	public static void main(String[] args) {
//		new JTableTest();
//	}
}
