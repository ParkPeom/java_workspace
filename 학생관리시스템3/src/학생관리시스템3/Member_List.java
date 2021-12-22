package �л������ý���3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Member_List extends JFrame implements MouseListener,ActionListener {

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn;
	JButton btnInsert;
	
	public Member_List() {
		super("ȸ������ ���α׷�");
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList(); // ��� ����Ʈ 
		System.out.println("v = "+ v);
		cols = getColumn(); //JTable �� �÷� 
		
		model = new DefaultTableModel(v,cols);
		
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);
		
		pbtn = new JPanel();
		btnInsert = new JButton("ȸ������");
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.NORTH);
		
		// ������ ���
		jTable.addMouseListener(this);
		btnInsert.addActionListener(this);
		
		setSize(600,200); // ���� ����
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//JTable �� �÷� 
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("���̵�");
		col.add("��й�ȣ");
		col.add("�̸�");
		col.add("��ȭ");
		col.add("�ּ�");
		col.add("����");
		col.add("����");
		col.add("����");
		col.add("�̸���");
		col.add("�ڱ�Ұ�");
		return col;
	} // getColumn
	
	// JTable ���� ���� �޼ҵ�
	public void jTableRefresh() {
		MemberDAO dao = new MemberDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(),getColumn());
		jTable.setModel(model);
	}

	public static void main(String[] args) {
		new Member_List();
	}//main
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//��ư�� Ŭ���ϸ�
		if(e.getSource() == btnInsert) {
			new MemberProc(this);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//mouseClicked �� ���
		int r = jTable.getSelectedRow();
		String id = (String)jTable.getValueAt(r, 0);
		try {
			MemberProc mem = new MemberProc(id,this); // ���̵� ���ڷ� ����â ����
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
