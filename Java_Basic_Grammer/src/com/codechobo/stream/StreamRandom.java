package com.codechobo.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRandom {

	public StreamRandom() {
	}
	public static void main(String[] args) {
//		IntStream intStream = new Random().ints(); // 무한스트림
		IntStream intStream = new Random().ints(5,10); // 5~9까지만
		intStream.limit(10) // 10개만 자르기
		.forEach(System.out::println);
		
		// iterate(T seed, UnaryOperator f) 단항 연산자 
		Stream<Integer> intStream2 = Stream.iterate(0, n -> n + 2);
		intStream2.limit(10) // 앞에서 부터 10개 자르기 
		.forEach(System.out::println);
		
		// generate(Supplier s) : 주기만 하는것 입력x , 출력O 
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(10) // 앞에서 부터 10개 자르기 
		.forEach(System.out::println);
	}
}
