package 학생관리시스템2;

import java.util.List;

public interface StudentDAOAble {
	
	public int insertStudent(StudentDTO student);
	public int updateStudent(StudentDTO student);
	public int deleteStudent(int no);
	public StudentDTO selectNoStudent(int no);
	public List<StudentDTO> selectNameStudent(String name);
	
}
