package array;

public class TPC04 {
	
	public static void main(String[] args) {
		
		// 4. 데이터를 이동하라 ! (변수 vs 배열의 관계)
		int a , b , c , d , e, f, g, h, i;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
		e = 50;
		f = 60;
		// a+b+c=? 메서드 처리 -> hap()
		
		// 다른 클래스로 이동하려면 합리적으로 어떻게 해야할가 ?
		hap(a,b,c); // 메소드 호출 
		hap(a,b,c,d,e,f); // 메소드 호출 
		
		// 담을 바구니가 필요 
		int[] arr = arr = new int[3]; // 
		
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		
		System.out.println(arr.length); // 배열의 길이 
	
		hap1(arr); // 주소를 넘긴다. 
		
		
		int[][] arr2 = new int[3][4];
		System.out.println(arr2.length);
	}
	
	// 상당히 많은 자료형을 넘겨줘야한다... 효율적인 방법이 없을까 ? 
	
	public static void hap(int a,int b,int c) {
		int sum = a + b + c;
		System.out.println(sum); // 60
		
	}
	public static void hap(int a,int b,int c,int d,int e,int f) {
		int sum = a + b + c;
		System.out.println(sum); // 60
	}
	
	// arr 배열을 받아서 가져올수있다.
	public static void hap1(int[] arr) {
		// 반복문 활용 - for , while문 
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("합계 : " + sum); // 60
	}
	// 위에 있는 메소드는 복잡해 보이고 , 아래 메소드는 간결해 보인다.
	// 배열을 만들어서 이동시키는게 배열의 궁국적인 장점이다 !! 
}
