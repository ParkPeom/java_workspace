package com.codechobo.itwill.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareMain {

	public ObjectCompareMain() {
		
	}
	public void start() {
		//컬렉션 객체내의 객체에 포함된 데이터를 이용하여 정렬하기
		//기본 데이터 셋팅하기
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		
		empList.add(new EmployeeVO(13, "박태환", "010-1234-2678", "사원", "abc@nate.com"));
		empList.add(new EmployeeVO(5, "김연아","010-8956-9587","대리","zzz@naver.com"));
		empList.add(new EmployeeVO(50,"박지성","010-4322-4353","과장","xyz@hanmail.com"));
		empList.add(new EmployeeVO(120,"손흥민","010-2525-1242","대리","gggg@nate.com"));
		empList.add(new EmployeeVO(35,"추신수","010-2212-5243","부장","cucucu@naver.com"));
		empList.add(new EmployeeVO(90,"안정환","010-6598-9658","본부장","test@nate.com"));
		empList.add(new EmployeeVO(22,"이동국","010-5623-9564","주임","dong@hanmail.com"));
		
		System.out.println("=====정렬전=======");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		
		//이름을 오름차순으로 정렬하기
		Collections.sort(empList, new CompareNameAsc());
		System.out.println("=====이름을 오름차순으로 정렬");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		//이름을 내림차순으로 정렬하기
		Collections.sort(empList, new CompareNameDesc());
		System.out.println("=====이름을 내림차순으로 정렬");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		Collections.sort(empList, new CompareSabunAsc());
		System.out.println("====사원번호를 오름차순으로 정렬");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		//사원번호를 내림차순으로 정렬
		Collections.sort(empList, new CompareSabunDesc());
		System.out.println("=====사원번호를 내림차순으로 정렬");
		for(EmployeeVO vo :empList) {
			System.out.println(vo.toString());
		}
		//직급을 내림차순으로 정렬
		Collections.sort(empList, new ComparePositionDesc());
		System.out.println("====직급을 내림차순으로 정렬");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		//이메일을 오름차순으로 정렬
		Collections.sort(empList, new CompareEmailAsc());
		System.out.println("====이메일을 오름차순으로 정렬");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
	}
	// Comparator인터페이스를 상속받아 compare()메소드 오버라이딩한다.
	//이메일을 오름차순으로 정렬하는 내부 클래스
	class CompareEmailAsc implements Comparator<EmployeeVO>{
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			return o1.getEmail().compareTo(o2.getEmail());
		}		
	}
	
	//직급을 내림차순으로 정렬하는 내부 클래스
	class ComparePositionDesc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {			
			return o2.getPosition().compareTo(o1.getPosition());
		}		
	}
	//사원번호로 내림차순 정렬하는 내부 클래스
	class CompareSabunDesc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			return (o1.getSabun()<o2.getSabun())?1:
				(o1.getSabun()>o2.getSabun())?-1:0;
		}		
	}
	//사원번호로 오름차순 정렬하는 내부클래스
	class CompareSabunAsc implements Comparator<EmployeeVO>{
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			//양수일때 두개의 값을 교환한다.
			return (o1.getSabun()>o2.getSabun())?1:
				(o1.getSabun()<o2.getSabun())?-1 :0 ;
		}		
	}
	
	//==사원명(이름)을 기준으로 오름차순 정렬하는 내부클래스
	class CompareNameAsc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			// 왼쪽의 객체가 작을때는 -1, 같을때 0, 왼쪽 객체가 클때는 1
			return  o1.getUsername().compareTo(o2.getUsername());
		}		
	}
	//==사원명(이름)을 기준으로 내림차순 정렬하는 내부클래스
	class CompareNameDesc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO v1, EmployeeVO v2) {
			//     박                           김  +
			return v2.getUsername().compareTo(v1.getUsername());
		}		
	}
	public static void main(String[] args) {
		new ObjectCompareMain().start();
	}
}
