package com.codechobo.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRandom {

	public StreamRandom() {
	}
	public static void main(String[] args) {
//		IntStream intStream = new Random().ints(); // ���ѽ�Ʈ��
		IntStream intStream = new Random().ints(5,10); // 5~9������
		intStream.limit(10) // 10���� �ڸ���
		.forEach(System.out::println);
		
		// iterate(T seed, UnaryOperator f) ���� ������ 
		Stream<Integer> intStream2 = Stream.iterate(0, n -> n + 2);
		intStream2.limit(10) // �տ��� ���� 10�� �ڸ��� 
		.forEach(System.out::println);
		
		// generate(Supplier s) : �ֱ⸸ �ϴ°� �Է�x , ���O 
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(10) // �տ��� ���� 10�� �ڸ��� 
		.forEach(System.out::println);
	}
}
