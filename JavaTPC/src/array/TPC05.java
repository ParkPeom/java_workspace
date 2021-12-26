package array;

public class TPC05 {
	
	public static void main(String[] args) {
		
		int[] a = new int[3]; // 3개 만듬 int 여러개인 구조
		
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		int sum = 0;
		
		// 반복문을 이용해서 값을 구할수 있다.
		for(int i = 0; i < a.length; i++) {
			sum+= a[i];
		}
		System.out.println(sum);
	
		// 총 9개의 정수형 변수를 만들어라 -> 2차원 구조
		// 행과열을 가지고 있다. 3행3열의 총 9개 원소를 가지고 있다.
		
		int[][] b = new int[3][3];
		
		// 1동 선택해서 3층 
		b[0][0] = 1;
		b[0][1] = 2;
		b[0][2] = 3;
		
		// 2동 선택해서 3층 
		b[1][0] = 1;
		b[1][1] = 2;
		b[1][2] = 3;
		
		// 2동 선택해서 3층 
		b[2][0] = 1;
		b[2][1] = 2;
		b[2][2] = 3;

		// 출력
		for(int i = 0; i < b.length; i++	) {
			for(int j = 0; j < b[i].length; j++ ) { // 각동의 길이만큼 돌리면 된다. 
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
		// 1	2	3	
		// 1	2	3	
		// 1	2	3
		
		// 가변 길이 배열 (길이가 다른 배열)
		// *
		// **
		// ***
		// **** 출력해보자
		int[][] arr = new int[4][];
		arr[0] = new int[1];
		arr[1] = new int[2];
		arr[2] = new int[3];
		arr[3] = new int[4];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = '*';
				System.out.print((char)arr[i][j]);
			}
			System.out.println();	
		}
	}
}
