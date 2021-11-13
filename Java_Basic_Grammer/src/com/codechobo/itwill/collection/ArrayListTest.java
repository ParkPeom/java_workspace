package com.codechobo.itwill.collection;
import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		
	}
	public void start() {
		VectorTest vt = new VectorTest();
		List<MemberVO> lst = vt.getArrayList();
		
		for(MemberVO vo : lst) {
			//vo.memberOutput();
			int n = vo.getNum();
			String userid = vo.getUserId();
			String tel = vo.getTel();
			System.out.printf("%d번\t %s님\t %s\n", n, userid, tel);
		}
		System.out.println("=============================");
		////////////////////////////////////////////
		//컬렉션의 객체를 모두 배열로 저장하기
		MemberVO arrVO[] = new MemberVO[lst.size()];
		lst.toArray(arrVO);
		
		for(MemberVO aVo : arrVO ) {
			aVo.memberOutput();
		}
		
	}
	public static void main(String[] args) {
		new ArrayListTest().start();
	}
}
