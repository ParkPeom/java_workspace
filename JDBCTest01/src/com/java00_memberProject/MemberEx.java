package com.java00_memberProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;

//public class MemberEx extends JFrame implements ActionListener{
//	//JFrame - North
//	JPanel nPane = new JPanel(new BorderLayout());
//		JPanel leftLblPane = new JPanel(new GridLayout(6,1));
//		JPanel tfPane = new JPanel(new GridLayout(6,1));
//			JTextField numTf = new JTextField(3); 
//			JPanel numPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//			
//			JTextField nameTf = new JTextField(10);
//			JPanel namePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//			JTextField telTf = new JTextField(20);		
//			JPanel telPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//			JTextField emailTf = new JTextField(20);		
//			JPanel emailPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//			JTextField addrTf = new JTextField(40);
//			JPanel addrPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//			JTextField writedateTf = new JTextField(40);
//			JPanel writedatePane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//			
//	//JFrame - Center
//	JPanel cPane = new JPanel(new BorderLayout());
//		JPanel btnPane = new JPanel(new GridLayout(1, 0));
//			JButton appendBtn = new JButton("�߰�");
//			JButton editBtn = new JButton("����");
//			JButton delBtn = new JButton("����");
//			JButton clearBtn = new JButton("�����");
//			JButton endBtn = new JButton("����");
//			JButton excelWriteBtn = new JButton("����������");
//			JButton excelReadBtn = new JButton("�����ҷ�����");
//		JTable table;
//			DefaultTableModel model;
//			JScrollPane sp;
//			String title[] = {"��ȣ","�̸�","��ȭ��ȣ","�̸���","�ּ�","�����"};
//	//Frame - SOUTH - �˻�
//	JPanel searchPane = new JPanel();
//		JTextField searchWord = new JTextField(20);
//		JButton searchBtn = new JButton("Search");
//	//������ �� index
//	int row = -1;		
//	public MemberEx() {
//		//JFrame - North
//		add(nPane, BorderLayout.NORTH);
//			nPane.add(leftLblPane, BorderLayout.WEST);
//				leftLblPane.add(new JLabel("��ȣ"));
//				leftLblPane.add(new JLabel("�̸�"));
//				leftLblPane.add(new JLabel("��ȭ��ȣ"));
//				leftLblPane.add(new JLabel("�̸���"));
//				leftLblPane.add(new JLabel("�ּ�"));
//				leftLblPane.add(new JLabel("�����"));
//
//			nPane.add(tfPane, BorderLayout.CENTER);
//			    numPane.add(numTf);
//				tfPane.add(numPane);
//				
//				namePane.add(nameTf);
//				tfPane.add(namePane);
//				
//				telPane.add(telTf);
//				tfPane.add(telPane);
//				
//				emailPane.add(emailTf);
//				tfPane.add(emailPane);
//				
//				addrPane.add(addrTf);
//				tfPane.add(addrPane);
//				
//				writedatePane.add(writedateTf);
//				tfPane.add(writedatePane);
//
//		//JFrame - Center///////////////////////////
//		add(cPane, BorderLayout.CENTER);
//			cPane.add(btnPane, BorderLayout.NORTH);
//				btnPane.add(appendBtn);
//				btnPane.add(editBtn);
//				btnPane.add(delBtn);
//				btnPane.add(clearBtn);
//				btnPane.add(endBtn);
//				btnPane.add(excelWriteBtn);
//				btnPane.add(excelReadBtn);
//		    ///JTable///////////////
//			model = new DefaultTableModel(title,0);
//			
//			setAllRecord();//DB���ڵ� �б�
//			
//			table = new JTable(model);
//			sp = new JScrollPane(table);
//			cPane.add(sp, BorderLayout.CENTER);
//			
//		//Frame - Sourth - �˻�
//		searchPane.add(searchWord); searchPane.add(searchBtn);
//		add(searchPane, BorderLayout.SOUTH);
//			
//		setSize(800,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		//�̺�Ʈ ���
//		appendBtn.addActionListener(this);
//		editBtn.addActionListener(this);
//		delBtn.addActionListener(this);
//		clearBtn.addActionListener(this);
//		endBtn.addActionListener(this);
//		excelWriteBtn.addActionListener(this);
//		excelReadBtn.addActionListener(this);
//		searchBtn.addActionListener(this);//�˻�
//		
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseReleased(MouseEvent me) {
//				//���� index�� ���ϰ� ���� ���� tf�� ġȯ�Ѵ�.
//				row = table.getSelectedRow();//������ ��
//				numTf.setText(String.valueOf(model.getValueAt(row, 0)));
//				nameTf.setText((String)model.getValueAt(row, 1));
//				telTf.setText((String)model.getValueAt(row, 2));
//				emailTf.setText((String)model.getValueAt(row, 3));
//				addrTf.setText((String)model.getValueAt(row, 4));	
//				writedateTf.setText((String)model.getValueAt(row, 5));
//			}			
//		});
//	}
////	public void actionPerformed(ActionEvent ae) {
////		Object obj = ae.getSource();
////		if(obj == appendBtn) {//�߰�
////			setAppendRecord();
////		}else if( obj == editBtn) {//����
////			setEditRecord();
////		}else if(obj == delBtn) {//����
////			setDeleteRecord();
////		}else if(obj == clearBtn) {
////			setFormClear();
////			row = -1;
////		}else if(obj == endBtn) {
////			System.exit(0);
////		}else if(obj == excelWriteBtn) {//������ ����
////			setSaveExcel();
////		}else if(obj == excelReadBtn) {//�������� �б�
////			setLoadExcel();
////		}else if(obj == searchBtn) {//���ڵ� �˻�
////			getSearch();
////		}
////	}
//	//�̸����� ���ڵ� �˻�
//	public void getSearch() {
//		if(searchWord.getText().equals("")) {//�˻�� ������
//			JOptionPane.showMessageDialog(this, "�˻�� �Է��ϼ���..");
//		}else {//�˻�� ������
//			MemberDAO dao = new MemberDAO();
//			List<MemberVO> list = dao.getSearchRecord(searchWord.getText().trim());
//			if(list.size()<=0) {//�˻����ڵ尡 ������
//				JOptionPane.showMessageDialog(this, "�˻������ �����ϴ�...");
//			}else {//�˻����ڵ尡 ������
//				model.setNumRows(0);//jtable�� �ִ� ���ڵ� �����
//				for(MemberVO vo: list) {
//					Object data[] = {
//							vo.getNum(), vo.getUsername(), vo.getAddr(),
//							vo.getTel()
//					};
//					model.addRow(data);
//				}
//			}
//		}		
//	}
////	//�������� �ҷ�����
////	public void setLoadExcel() {
////		JFileChooser fc = new JFileChooser();
////		File file = new File("D://fileFolder/*.xls");
////		FileFilter ff = new FileNameExtensionFilter("*.xls", "xls");
////		
////		fc.setSelectedFile(file);
////		fc.setFileFilter(ff);
////		
////		//���� : 0, ��� :1
////		int result = fc.showOpenDialog(this);
////		if(result ==0) {
////			try {
////				file = fc.getSelectedFile();
////				FileInputStream fis = new FileInputStream(file);//InputStream
////				POIFSFileSystem poi = new POIFSFileSystem(fis);//FileSystem
////				
////				HSSFWorkbook book = new HSSFWorkbook(poi);
////				HSSFSheet sheet = book.getSheetAt(0);
////				
////				//table�� ������ ����
////				model.setRowCount(0);
////				
////				int row = sheet.getPhysicalNumberOfRows();
////				System.out.println("row="+row);
////				for(int r=1; r<row; r++) {
////					
////					HSSFRow rowExcel = sheet.getRow(r); 
////					int columCount = rowExcel.getPhysicalNumberOfCells();
////					Object dataRow[] = new Object[columCount];	
////					System.out.println("columCount="+columCount);
////					for(int c = 0; c<columCount ; c++) {
////						HSSFCell cell = rowExcel.getCell(c);
////						if(c==0) {
////							dataRow[c] = (int)cell.getNumericCellValue();
////						}else {	
////							dataRow[c] = cell.getStringCellValue();
////						}	 
////					}
////					model.addRow(dataRow);
////				}
////				book.close();
////			}catch(Exception e) {e.printStackTrace();}
////		}
////	}
////	//������ �����ϱ�
////	public void setSaveExcel() {		
////		//JTable�� ����� ���Ͽ� ���ڵ尡 ������ ����
////		int recordCount = model.getRowCount();
////		if(recordCount>0) {//���ڵ尡 ������	
////			JFileChooser fc = new JFileChooser();
////			File file = new File("D://fileFolder/*.xls");//�⺻����
////			fc.setSelectedFile(file);
////			//����
////			FileFilter ff = new FileNameExtensionFilter("*.xls", "xls", "XLS", "Xls");
////			fc.setFileFilter(ff);
////			//����:0, ���:1
////			int result = fc.showSaveDialog(this);			
////			if(result == 0) {
////				//������ ����
////				File saveFile = fc.getSelectedFile();
////				HSSFWorkbook workbook = new HSSFWorkbook();
////				HSSFSheet sheet = workbook.createSheet("ȸ������Ʈ");
////				//����
////				HSSFRow row = sheet.createRow(0);
////				row.createCell(0).setCellValue("��ȣ");
////				row.createCell(1).setCellValue("�̸�");
////				row.createCell(2).setCellValue("����ó");
////				row.createCell(3).setCellValue("�̸���");
////				row.createCell(4).setCellValue("�ּ�");
////				row.createCell(5).setCellValue("�����");
////				
////				int columnCount = model.getColumnCount();//ĭ��
////				
////				for(int r=0; r<recordCount; r++) {
////					HSSFRow rowInsert = sheet.createRow(r+1); 
////					for(int c=0; c<columnCount; c++) {
////						HSSFCell cell = rowInsert.createCell(c);
////						if(c==0) {
////							cell.setCellValue((Integer)model.getValueAt(r,c));
////						}
////						else {
////							cell.setCellValue((String)model.getValueAt(r,c));
////						}
////						
////					}
////				}
////				//
////				System.out.println(saveFile);
////				try {
////					FileOutputStream fos = new FileOutputStream(saveFile);
////					workbook.write(fos);
////					if(fos !=null) fos.close();
////				}catch(Exception e) {
////					e.printStackTrace();
////				}finally {
////					try {
////						if(workbook !=null) workbook.close();						
////					}catch(Exception e) {}
////				}				
////				JOptionPane.showMessageDialog(this, "������ ����Ǿ����ϴ�.");
//// 			}
////		}else {//������ ���ڵ尡 ����
////			JOptionPane.showMessageDialog(this, "������ ����Ÿ�� �����ϴ�...");
////		}	
////	}
//	//�������ý�
//	public void setEditRecord() {
//		MemberDAO dao = new MemberDAO();
//		MemberVO vo = new MemberVO(Integer.parseInt(numTf.getText()),
//				nameTf.getText(), telTf.getText(), emailTf.getText(), addrTf.getText());
//		dao.setUpdate(vo);
//		
//		if(vo.getCount()>0) {
//			//JTable
//			setAllRecord();	
//		}else {
//			JOptionPane.showMessageDialog(this, "ȸ���������� �����Ͽ����ϴ�.");
//		}
//	}
//	//�߰����ý�
//	public void setAppendRecord() {
//		//TextField�� ���� ������� �߰����� �ʴ´�.
////		if(numTf.getText().equals("")) {
////			JOptionPane.showMessageDialog(this, "��ȣ�� �Է��ϼ���...");
////		}else 
//		if(nameTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���....");
//		}else if(telTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "����ó�� �Է��ϼ���...");
//		}else if(emailTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "�̸��ϸ� �Է��ϼ���....");
//		}else if(addrTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "�ּҸ� �Է��ϼ���....");
//		}else {
//			MemberDAO dao = new MemberDAO();
//			MemberVO vo = new MemberVO(nameTf.getText(), telTf.getText(), emailTf.getText(), addrTf.getText());
//			dao.setInsert(vo);
//			if(vo.getCount()>0) {//���ڵ� �߰� ������ ����
//				////////
//				setAllRecord();//DB�� ��� ���ڵ� ��������
//				setFormClear();//���� �� �����
//				////////
//			}else {
//				JOptionPane.showMessageDialog(this, "���ڵ��߰� ���� �Ͽ����ϴ�...");
//			}
//		}		
//	}
//	public void setDeleteRecord() {
//		MemberDAO dao = new MemberDAO();
//		int c=dao.setDelete(Integer.parseInt(numTf.getText()));
//			///////////////////
//		if(c>0) {//����
//			setAllRecord();
//			setFormClear();
//			row = -1;
//		}else {//��������
//			JOptionPane.showMessageDialog(this, "ȸ�������� �������� �ʾҽ��ϴ�.");
//		}
//	}
//	public void setFormClear() {
//		numTf.setText("");
//		nameTf.setText("");
//		telTf.setText("");
//		emailTf.setText("");
//		addrTf.setText("");	
//		writedateTf.setText("");
//	}
//	//////////////////////
//	public void setAllRecord() {
//		model.setRowCount(0);
//		MemberDAO dao = new MemberDAO();
//		List<MemberVO> list = dao.getAllSelect();
//		for(MemberVO vo : list) {
//			Object[] data = { vo.getNum(), vo.getUsername(),
//					vo.getTel(), vo.getEmail(), vo.getAddr(), vo.getWritedate()};
//			model.addRow(data);
//		}
//	}
//	public static void main(String[] args) {
//		new MemberEx();
//	}
//}
