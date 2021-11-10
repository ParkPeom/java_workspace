
class Student<T> {
	
	private T num;
	
	<T> Student(T x) {
		
	}
	
	public T getNum() {
		return num;
	}
	
	public void setNum(T num) {
		this.num = num;
	}
}
public class JenericVO {

	public JenericVO() {
	
	}
	
	public static void main(String[] args) {
		Student<Integer> std = new Student<Integer>("");
		Student<Integer> std2 = new Student<Integer>(1234);
	}
}
