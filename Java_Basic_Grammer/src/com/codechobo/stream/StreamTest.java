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
		// st.sum 안되는 이유 Stream<T>는 숫자외에도 
		// 여러타입이 스트림이 가능해야하므로 숫자 스트림에만 사용할수있는
		// sum(),average()를 넣지 않은것이다. 
		
		int[] arr = {1,2,3,4,5};
		IntStream ist = Arrays.stream(arr); // 기본형스트림 
		
		System.out.println("sum : " + ist.sum());
		
	}
}
