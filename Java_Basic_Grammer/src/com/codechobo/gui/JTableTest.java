package com.codechobo.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// �����Ӿȿ� �������� ������ �׷�.. �����Ӿȿ� �������� �гη�...�ٲ۴� 

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

//public class JTableTest extends JFrame {
// JPanel �⺻ ���̾ƿ��� FlowLayout �̴�.
// �׷��� setLayout(new BorderLayout()); BorderLayout���� �����������

// implements MouseListener ���콺 �̺�Ʈ ��� 
public class JTableTest extends JPanel implements MouseListener {
	JTable table;
	//Ÿ��Ʋ�� ����� �迭 
	Object[] title = {"��ȣ","�̸�","����ó"};
	Object[][] data = {{1,"ȫ�浿1","010-1234-5678"},
					   {2,"ȫ�浿2","010-1234-8888"},
					   {3,"ȫ�浿3","010-1234-6666"},
					   {4,"ȫ�浿4","010-1234-4444"},};
	
	//JTable�� ������ ����� �����͸� ������ ��ü
	DefaultTableModel model;
	JScrollPane sp;
	Font fnt;
	JLabel lb1 = new JLabel("������ ����� ǥ�õǴ� ��");
	
	public JTableTest() {
		setLayout(new BorderLayout());
		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		
		// addMouseListener : ���콺 �̺�Ʈ�� ��� 
		
		add("South",lb1); 
		
//		setSize(500,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// �̺�Ʈ ���
		table.addMouseListener(this);
	}
	// ��ü�� �ٸ�Ŭ������ �Ѱ��ְ� ��������?
	public JTableTest(Font fnt) {
		// ���� Ŭ������ �����ڸ޼ҵ��� �ٸ� �����ڸ� ȣ���ϱ�
		// �ݵ�� ù��° ���๮ �̾�� �Ѵ�. 
		
		this(); // JTableTest() ȣ��
		this.fnt = fnt;
		lb1.setFont(fnt);
	}
	
	//--------------------- implements MouseListener �������̵�
	@Override
	public void mouseClicked(MouseEvent e) { // Ŭ���ϸ� 
	}

	@Override
	public void mousePressed(MouseEvent e) { // ������
	}

	@Override
	public void mouseReleased(MouseEvent e) { // ������ ������
		// ���콺�� ���� �� ������				// ������ e���� ������Ʈ�� ������ ����ִ�.
		//���콺 ->1:����, 2:��, 3:������ ��ư
		if(e.getButton()==1) {
			//���õ� ���� index��������
			int rowIdx = table.getSelectedRow(); // ���õ� ���ȣ
			System.out.println("���õ� ���� index ->" + rowIdx);
			
			// �ݺ��� ĭ����ŭ ����
			String txt = "";
			for(int i = 0; i < table.getColumnCount();i++) {
				Object obj = table.getValueAt(rowIdx, i); // ���ȣ ����ȣ 
				txt += obj +", ";
			}
			// �ݺ��� ������ ������ �󺧿� ������ ��� 
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
