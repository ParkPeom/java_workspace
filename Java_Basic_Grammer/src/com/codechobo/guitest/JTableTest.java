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
	Object[] title = {"��ȣ","�̸�","����ó"};
	Object [][] data = {{ 1, "ȫ�浿1","010-1234-5678"},
						{ 2, "ȫ�浿2","010-1234-5678"},
						{ 3, "ȫ�浿3","010-1234-6666"},
						{ 4, "ȫ�浿4","010-1234-5353"}
	};
	// JTable �� ������ ����� �����͸� ������ ��ü 
	DefaultTableModel model;
	JScrollPane sp;
	Font fnt;
	JLabel lb1 = new JLabel("������ ����� ǥ�� �Ǵ� ��");
	
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

	
	// ���콺�� ������ ������ 
	
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
