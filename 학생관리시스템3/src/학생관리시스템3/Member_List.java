package 학생관리시스템3;

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
		super("회원가입 프로그램");
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList(); // 멤버 리스트 
		System.out.println("v = "+ v);
		cols = getColumn(); //JTable 의 컬럼 
		
		model = new DefaultTableModel(v,cols);
		
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);
		
		pbtn = new JPanel();
		btnInsert = new JButton("회원가입");
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.NORTH);
		
		// 리스너 등록
		jTable.addMouseListener(this);
		btnInsert.addActionListener(this);
		
		setSize(600,200); // 가로 세로
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//JTable 의 컬럼 
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("아이디");
		col.add("비밀번호");
		col.add("이름");
		col.add("전화");
		col.add("주소");
		col.add("생일");
		col.add("직업");
		col.add("성별");
		col.add("이메일");
		col.add("자기소개");
		return col;
	} // getColumn
	
	// JTable 내용 갱신 메소드
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
		//버튼을 클릭하면
		if(e.getSource() == btnInsert) {
			new MemberProc(this);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//mouseClicked 만 사용
		int r = jTable.getSelectedRow();
		String id = (String)jTable.getValueAt(r, 0);
		try {
			MemberProc mem = new MemberProc(id,this); // 아이디를 인자로 수정창 생성
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
