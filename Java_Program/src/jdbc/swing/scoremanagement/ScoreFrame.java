package jdbc.swing.scoremanagement;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreFrame extends JFrame implements ActionListener , MouseListener  {

	ScoreDAO scoreDAO;
	ScoreDTO scoreDTO;
	
	JLabel jlName , jlKor , jlEng , jlMat;
	JTextField jtName , jtKor , jtEng , jtMat;
	JButton jbAdd , jbDel , jbChange;
	JTable table;
	Vector data , col;
	
	ScoreFrame() {
		setLayout(null);
		scoreDAO = new ScoreDAO();
		
		// 이름
		add(jlName = new JLabel("이름",JLabel.CENTER));
		jlName.setFont(new Font("맑은 고딕", Font.BOLD , 20));
		jlName.setBounds(10,10,120,50);
		
		add(jtName = new JTextField());
		jtName.setFont(new Font("맑은 고딕", Font.BOLD , 20));
		jtName.setHorizontalAlignment(JTextField.CENTER);
		jtName.setBounds(140,10,120,50);
		
		// 국어
		add(jlKor = new JLabel("국어 점수", JLabel.CENTER));
		jlKor.setFont(new Font("맑은 고딕",Font.BOLD,20));
		jlKor.setBorder(BorderFactory.createBevelBorder(0));
		jlKor.setBounds(10,70,120,50);
		
	    // 영어
	    add(jlEng = new JLabel("영어 점수", JLabel.CENTER));
	    jlEng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    jlEng.setBorder(BorderFactory.createBevelBorder(0));
	    jlEng.setBounds(10, 130, 120, 50);
	    add(jtEng = new JTextField());
	    jtEng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    jtEng.setHorizontalAlignment(JTextField.CENTER);
	    jtEng.setBounds(140, 130, 120, 50);
	     
	    // 수학
	    add(jlMat = new JLabel("수학 점수", JLabel.CENTER));
	    jlMat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    jlMat.setBorder(BorderFactory.createBevelBorder(0));
	    jlMat.setBounds(10, 190, 120, 50);
	    add(jtMat = new JTextField());
	    jtMat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    jtMat.setHorizontalAlignment(JTextField.CENTER);
	    jtMat.setBounds(140, 190, 120, 50);
	     
	    // 버튼
	    add(jbAdd = new JButton("추가"));
	    jbAdd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    jbAdd.setBounds(270, 10, 120, 50);
	    jbAdd.addActionListener(this);
	    add(jbDel = new JButton("제거"));
	    jbDel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    jbDel.setBounds(270, 70, 120, 50);
	    jbDel.addActionListener(this);
	    add(jbChange = new JButton("수정"));
	    jbChange.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	    jbChange.setBounds(270, 130, 120, 50);
	    jbChange.addActionListener(this);
	
	    
	    // 컬럼 백터
	    col = new Vector();
	    col.add("이름");
	    col.add("국어점수");
	    col.add("영어 점수");
	    col.add("수학 점수");
	    col.add("총점");
	    col.add("평균");
	    
	    // 테이블 수정 못하게 DefaultTableModel 사용
	    
	    
	    DefaultTableModel model = new DefaultTableModel(scoreDAO.getScore(), col) {
	        public boolean isCellEditable(int row, int column) {
	          return false;
	        }
	      };
	      
	    // 디폴트테이블을 테이블에 더해서 스크롤패널에 더한다
	      table = new JTable(model);
	      table.addMouseListener(this);
	      JScrollPane scroll = new JScrollPane(table);
	      
	      
	}
	
}
