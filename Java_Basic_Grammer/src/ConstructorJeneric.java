
public class ConstructorJeneric<T> {

	<X> ConstructorJeneric(X x) {
		
	}
	
//	String ConStructorJeneric(String num) {
//		return num;
//	}
	public static void main(String[] args) {
		ConstructorJeneric<Integer> gtj = new ConstructorJeneric<Integer>(1234);
		ConstructorJeneric<Integer> gtj2 = new ConstructorJeneric<Integer>("QWD");
	}
}
