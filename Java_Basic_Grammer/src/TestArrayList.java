import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	
	public static void main(String[] args) {
		
		ArrayList<Character> arr = new ArrayList();
		
		for(char i = 'a'; i <= 'z'; i++) {
			arr.add(i);
		}
		
		for(Character ch : arr) {
			System.out.println(ch);
		}
		
		if(arr.isEmpty()) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
