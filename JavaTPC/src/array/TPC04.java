package array;

public class TPC04 {
	
	public static void main(String[] args) {
		
		// 4. �����͸� �̵��϶� ! (���� vs �迭�� ����)
		int a , b , c , d , e, f, g, h, i;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
		e = 50;
		f = 60;
		// a+b+c=? �޼��� ó�� -> hap()
		
		// �ٸ� Ŭ������ �̵��Ϸ��� �ո������� ��� �ؾ��Ұ� ?
		hap(a,b,c); // �޼ҵ� ȣ�� 
		hap(a,b,c,d,e,f); // �޼ҵ� ȣ�� 
		
		// ���� �ٱ��ϰ� �ʿ� 
		int[] arr = arr = new int[3]; // 
		
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		
		System.out.println(arr.length); // �迭�� ���� 
	
		hap1(arr); // �ּҸ� �ѱ��. 
		
		
		int[][] arr2 = new int[3][4];
		System.out.println(arr2.length);
	}
	
	// ����� ���� �ڷ����� �Ѱ�����Ѵ�... ȿ������ ����� ������ ? 
	
	public static void hap(int a,int b,int c) {
		int sum = a + b + c;
		System.out.println(sum); // 60
		
	}
	public static void hap(int a,int b,int c,int d,int e,int f) {
		int sum = a + b + c;
		System.out.println(sum); // 60
	}
	
	// arr �迭�� �޾Ƽ� �����ü��ִ�.
	public static void hap1(int[] arr) {
		// �ݺ��� Ȱ�� - for , while�� 
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("�հ� : " + sum); // 60
	}
	// ���� �ִ� �޼ҵ�� ������ ���̰� , �Ʒ� �޼ҵ�� ������ ���δ�.
	// �迭�� ���� �̵���Ű�°� �迭�� �ñ����� �����̴� !! 
}
