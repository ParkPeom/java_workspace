package array;

public class TPC05 {
	
	public static void main(String[] args) {
		
		int[] a = new int[3]; // 3�� ���� int �������� ����
		
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		int sum = 0;
		
		// �ݺ����� �̿��ؼ� ���� ���Ҽ� �ִ�.
		for(int i = 0; i < a.length; i++) {
			sum+= a[i];
		}
		System.out.println(sum);
	
		// �� 9���� ������ ������ ������ -> 2���� ����
		// ������� ������ �ִ�. 3��3���� �� 9�� ���Ҹ� ������ �ִ�.
		
		int[][] b = new int[3][3];
		
		// 1�� �����ؼ� 3�� 
		b[0][0] = 1;
		b[0][1] = 2;
		b[0][2] = 3;
		
		// 2�� �����ؼ� 3�� 
		b[1][0] = 1;
		b[1][1] = 2;
		b[1][2] = 3;
		
		// 2�� �����ؼ� 3�� 
		b[2][0] = 1;
		b[2][1] = 2;
		b[2][2] = 3;

		// ���
		for(int i = 0; i < b.length; i++	) {
			for(int j = 0; j < b[i].length; j++ ) { // ������ ���̸�ŭ ������ �ȴ�. 
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
		// 1	2	3	
		// 1	2	3	
		// 1	2	3
		
		// ���� ���� �迭 (���̰� �ٸ� �迭)
		// *
		// **
		// ***
		// **** ����غ���
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
