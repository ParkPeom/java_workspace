package com.codechobo.guitest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class JTableTest extends JPanel implements MouseListener {
	
	JTable table;
	Object[] title = {"번호","이름","연락처"};
	Object [][] data = {{ 1, "홍길동1","010-1234-5678"},
						{ 2, "홍길동2","010-1234-5678"},
						{ 3, "홍길동3","010-1234-6666"},
						{ 4, "홍길동4","010-1234-5353"}
	};
	// JTable 에 셋팅할 제목과 데이터를 가지는 객체 
	DefaultTableModel model;
	JScrollPane sp;
	Font fnt;
	JLabel lb1 = new JLabel("선택한 목록이 표시 되는 곳");
	
	public JTableTest() {
		setLayout(new BorderLayout());
		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);

		add("South", lb1);
		
		table.addMouseListener(this);
	}
	
	public JTableTest(Font fnt) {
		this();
		this.fnt = fnt;
		lb1.setFont(fnt);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	
	// 마우스를 눌렀다 놓으면 
	
	@Override
	public void mouseReleased(MouseEvent e) { 
		if(e.getButton() == 1) {
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
