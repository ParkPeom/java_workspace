package com.codechobo.itwill.collection;
import java.util.Stack;

public class StackTest {

	public StackTest() {
		
	}
	public void start() {
		// Stack : 입력순서를 유지한다.
		//         먼저입력된 객체가 제일 나중에 출력된다. (FILO)
		//         객체의 입출력이 한쪽방향에서 이루어진다.
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("김연아");
		stack.push("박태환");
		stack.push("김연경");
		stack.push("추신수");
		stack.push("모태범");
		
		int idx = stack.search("박태환");
		System.out.println(idx);
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
	public static void main(String[] args) {		
		new StackTest().start();
	}
}
