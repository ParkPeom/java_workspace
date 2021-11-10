package com.codechobo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public StreamTest() {
	
	}
	
	public static void main(String[] args) {
		
		List<Integer> lit = Arrays.asList(1,2,2,3,4,5);
		Stream<Integer> st = lit.stream();
		// st.sum �ȵǴ� ���� Stream<T>�� ���ڿܿ��� 
		// ����Ÿ���� ��Ʈ���� �����ؾ��ϹǷ� ���� ��Ʈ������ ����Ҽ��ִ�
		// sum(),average()�� ���� �������̴�. 
		
		int[] arr = {1,2,3,4,5};
		IntStream ist = Arrays.stream(arr); // �⺻����Ʈ�� 
		
		System.out.println("sum : " + ist.sum());
		
	}
}
