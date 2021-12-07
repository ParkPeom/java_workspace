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
		
		// �̸�
		add(jlName = new JLabel("�̸�",JLabel.CENTER));
		jlName.setFont(new Font("���� ���", Font.BOLD , 20));
		jlName.setBounds(10,10,120,50);
		
		add(jtName = new JTextField());
		jtName.setFont(new Font("���� ���", Font.BOLD , 20));
		jtName.setHorizontalAlignment(JTextField.CENTER);
		jtName.setBounds(140,10,120,50);
		
		// ����
		add(jlKor = new JLabel("���� ����", JLabel.CENTER));
		jlKor.setFont(new Font("���� ���",Font.BOLD,20));
		jlKor.setBorder(BorderFactory.createBevelBorder(0));
		jlKor.setBounds(10,70,120,50);
		
	    // ����
	    add(jlEng = new JLabel("���� ����", JLabel.CENTER));
	    jlEng.setFont(new Font("���� ���", Font.BOLD, 20));
	    jlEng.setBorder(BorderFactory.createBevelBorder(0));
	    jlEng.setBounds(10, 130, 120, 50);
	    add(jtEng = new JTextField());
	    jtEng.setFont(new Font("���� ���", Font.BOLD, 20));
	    jtEng.setHorizontalAlignment(JTextField.CENTER);
	    jtEng.setBounds(140, 130, 120, 50);
	     
	    // ����
	    add(jlMat = new JLabel("���� ����", JLabel.CENTER));
	    jlMat.setFont(new Font("���� ���", Font.BOLD, 20));
	    jlMat.setBorder(BorderFactory.createBevelBorder(0));
	    jlMat.setBounds(10, 190, 120, 50);
	    add(jtMat = new JTextField());
	    jtMat.setFont(new Font("���� ���", Font.BOLD, 20));
	    jtMat.setHorizontalAlignment(JTextField.CENTER);
	    jtMat.setBounds(140, 190, 120, 50);
	     
	    // ��ư
	    add(jbAdd = new JButton("�߰�"));
	    jbAdd.setFont(new Font("���� ���", Font.BOLD, 20));
	    jbAdd.setBounds(270, 10, 120, 50);
	    jbAdd.addActionListener(this);
	    add(jbDel = new JButton("����"));
	    jbDel.setFont(new Font("���� ���", Font.BOLD, 20));
	    jbDel.setBounds(270, 70, 120, 50);
	    jbDel.addActionListener(this);
	    add(jbChange = new JButton("����"));
	    jbChange.setFont(new Font("���� ���", Font.BOLD, 20));
	    jbChange.setBounds(270, 130, 120, 50);
	    jbChange.addActionListener(this);
	
	    
	    // �÷� ����
	    col = new Vector();
	    col.add("�̸�");
	    col.add("��������");
	    col.add("���� ����");
	    col.add("���� ����");
	    col.add("����");
	    col.add("���");
	    
	    // ���̺� ���� ���ϰ� DefaultTableModel ���
	    
	    
	    DefaultTableModel model = new DefaultTableModel(scoreDAO.getScore(), col) {
	        public boolean isCellEditable(int row, int column) {
	          return false;
	        }
	      };
	      
	    // ����Ʈ���̺��� ���̺� ���ؼ� ��ũ���гο� ���Ѵ�
	      table = new JTable(model);
	      table.addMouseListener(this);
	      JScrollPane scroll = new JScrollPane(table);
	      
	      
	}
	
}
