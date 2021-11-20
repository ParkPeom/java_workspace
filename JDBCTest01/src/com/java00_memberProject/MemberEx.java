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
//			JButton appendBtn = new JButton("추가");
//			JButton editBtn = new JButton("수정");
//			JButton delBtn = new JButton("삭제");
//			JButton clearBtn = new JButton("지우기");
//			JButton endBtn = new JButton("종료");
//			JButton excelWriteBtn = new JButton("엑셀로저장");
//			JButton excelReadBtn = new JButton("엑셀불러오기");
//		JTable table;
//			DefaultTableModel model;
//			JScrollPane sp;
//			String title[] = {"번호","이름","전화번호","이메일","주소","등록일"};
//	//Frame - SOUTH - 검색
//	JPanel searchPane = new JPanel();
//		JTextField searchWord = new JTextField(20);
//		JButton searchBtn = new JButton("Search");
//	//선택한 행 index
//	int row = -1;		
//	public MemberEx() {
//		//JFrame - North
//		add(nPane, BorderLayout.NORTH);
//			nPane.add(leftLblPane, BorderLayout.WEST);
//				leftLblPane.add(new JLabel("번호"));
//				leftLblPane.add(new JLabel("이름"));
//				leftLblPane.add(new JLabel("전화번호"));
//				leftLblPane.add(new JLabel("이메일"));
//				leftLblPane.add(new JLabel("주소"));
//				leftLblPane.add(new JLabel("등록일"));
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
//			setAllRecord();//DB레코드 읽기
//			
//			table = new JTable(model);
//			sp = new JScrollPane(table);
//			cPane.add(sp, BorderLayout.CENTER);
//			
//		//Frame - Sourth - 검색
//		searchPane.add(searchWord); searchPane.add(searchBtn);
//		add(searchPane, BorderLayout.SOUTH);
//			
//		setSize(800,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		//이벤트 등록
//		appendBtn.addActionListener(this);
//		editBtn.addActionListener(this);
//		delBtn.addActionListener(this);
//		clearBtn.addActionListener(this);
//		endBtn.addActionListener(this);
//		excelWriteBtn.addActionListener(this);
//		excelReadBtn.addActionListener(this);
//		searchBtn.addActionListener(this);//검색
//		
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseReleased(MouseEvent me) {
//				//행의 index를 구하고 행의 값을 tf에 치환한다.
//				row = table.getSelectedRow();//선택한 행
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
////		if(obj == appendBtn) {//추가
////			setAppendRecord();
////		}else if( obj == editBtn) {//수정
////			setEditRecord();
////		}else if(obj == delBtn) {//삭제
////			setDeleteRecord();
////		}else if(obj == clearBtn) {
////			setFormClear();
////			row = -1;
////		}else if(obj == endBtn) {
////			System.exit(0);
////		}else if(obj == excelWriteBtn) {//엑셀로 저장
////			setSaveExcel();
////		}else if(obj == excelReadBtn) {//엑셀에서 읽기
////			setLoadExcel();
////		}else if(obj == searchBtn) {//레코드 검색
////			getSearch();
////		}
////	}
//	//이름으로 레코드 검색
//	public void getSearch() {
//		if(searchWord.getText().equals("")) {//검색어가 없을때
//			JOptionPane.showMessageDialog(this, "검색어를 입력하세요..");
//		}else {//검색어가 있을때
//			MemberDAO dao = new MemberDAO();
//			List<MemberVO> list = dao.getSearchRecord(searchWord.getText().trim());
//			if(list.size()<=0) {//검색레코드가 없을때
//				JOptionPane.showMessageDialog(this, "검색결과가 없습니다...");
//			}else {//검색레코드가 있을때
//				model.setNumRows(0);//jtable에 있는 레코드 지우기
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
////	//엑셀에서 불러오기
////	public void setLoadExcel() {
////		JFileChooser fc = new JFileChooser();
////		File file = new File("D://fileFolder/*.xls");
////		FileFilter ff = new FileNameExtensionFilter("*.xls", "xls");
////		
////		fc.setSelectedFile(file);
////		fc.setFileFilter(ff);
////		
////		//열기 : 0, 취소 :1
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
////				//table의 데이터 삭제
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
////	//엑셀로 저장하기
////	public void setSaveExcel() {		
////		//JTable의 행수를 구하여 레코드가 있을때 저장
////		int recordCount = model.getRowCount();
////		if(recordCount>0) {//레코드가 있을때	
////			JFileChooser fc = new JFileChooser();
////			File file = new File("D://fileFolder/*.xls");//기본폴더
////			fc.setSelectedFile(file);
////			//필터
////			FileFilter ff = new FileNameExtensionFilter("*.xls", "xls", "XLS", "Xls");
////			fc.setFileFilter(ff);
////			//저장:0, 취소:1
////			int result = fc.showSaveDialog(this);			
////			if(result == 0) {
////				//엑셀로 쓰기
////				File saveFile = fc.getSelectedFile();
////				HSSFWorkbook workbook = new HSSFWorkbook();
////				HSSFSheet sheet = workbook.createSheet("회원리스트");
////				//제목
////				HSSFRow row = sheet.createRow(0);
////				row.createCell(0).setCellValue("번호");
////				row.createCell(1).setCellValue("이름");
////				row.createCell(2).setCellValue("연락처");
////				row.createCell(3).setCellValue("이메일");
////				row.createCell(4).setCellValue("주소");
////				row.createCell(5).setCellValue("등록일");
////				
////				int columnCount = model.getColumnCount();//칸수
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
////				JOptionPane.showMessageDialog(this, "엑셀로 저장되었습니다.");
//// 			}
////		}else {//저장할 레코드가 없음
////			JOptionPane.showMessageDialog(this, "저장할 데이타가 없습니다...");
////		}	
////	}
//	//수정선택시
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
//			JOptionPane.showMessageDialog(this, "회원정보수정 실패하였습니다.");
//		}
//	}
//	//추가선택시
//	public void setAppendRecord() {
//		//TextField에 값이 없을경우 추가하지 않는다.
////		if(numTf.getText().equals("")) {
////			JOptionPane.showMessageDialog(this, "번호를 입력하세요...");
////		}else 
//		if(nameTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "이름을 입력하세요....");
//		}else if(telTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "연락처를 입력하세요...");
//		}else if(emailTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "이메일를 입력하세요....");
//		}else if(addrTf.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "주소를 입력하세요....");
//		}else {
//			MemberDAO dao = new MemberDAO();
//			MemberVO vo = new MemberVO(nameTf.getText(), telTf.getText(), emailTf.getText(), addrTf.getText());
//			dao.setInsert(vo);
//			if(vo.getCount()>0) {//레코드 추가 성공시 실행
//				////////
//				setAllRecord();//DB의 모든 레코드 가져오기
//				setFormClear();//폼의 값 지우기
//				////////
//			}else {
//				JOptionPane.showMessageDialog(this, "레코드추가 실패 하였습니다...");
//			}
//		}		
//	}
//	public void setDeleteRecord() {
//		MemberDAO dao = new MemberDAO();
//		int c=dao.setDelete(Integer.parseInt(numTf.getText()));
//			///////////////////
//		if(c>0) {//삭제
//			setAllRecord();
//			setFormClear();
//			row = -1;
//		}else {//삭제실패
//			JOptionPane.showMessageDialog(this, "회원정보가 삭제되지 않았습니다.");
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
