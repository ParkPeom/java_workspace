package com.codechobo.itwill.collection;

public class GenericTestMain {

	public GenericTestMain() {
		
	}
	public void start() {
		GenericTest gt1 = new GenericTest();
		GenericTest gt2 = new GenericTest("¼ÕÈï¹Î");
		gt1.setData("¹ÚÁö¼º");
		
		System.out.println(gt1.getData()+", "+gt2.getData());
		
		//GenericTest gt3 = new GenericTest(1234);
		//gt1.setData(5678);
		
		GenericTest<Integer> gt4 = new GenericTest<Integer>();
		gt4.setData(1234);
		System.out.println(gt4.getData());
		
		MemberVO vo = new MemberVO();
		vo.setNum(150);
		vo.setUserid("goguma777");
		vo.setTel("010-1234-5678");
		
		GenericTest<MemberVO> gt5 = new GenericTest<MemberVO>();
		gt5.setData(vo);
		//////////////////////////////
		MemberVO gVo = gt5.getData();
		gVo.memberOutput();
	}
	public static void main(String[] args) {
		new GenericTestMain().start();
	}
}
