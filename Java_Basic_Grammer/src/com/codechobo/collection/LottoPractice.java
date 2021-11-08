package com.codechobo.collection;

import java.util.ArrayList;
import java.util.Collections;

public class LottoPractice {

	public LottoPractice() {
	}

	public void start() {
		getNum();
	}

	public void getNum() {
		ArrayList<Integer> arr = new ArrayList<Integer>(6);

		for (int i = 0; i < 6; i++) {
			
			while (true) {
				int num = (int) (Math.random() * 45) + 1;
				Integer n = num;

				arr.add(n);
				boolean run = false;

				for (int j = 0; j < i; j++) {

					if (arr.get(i) == arr.get(j)) {
						run = true;
						break;
					}

				}
				if (!run) {
					break;
				}

			}

		}
		Collections.sort(arr);
		for (int k : arr) {
			System.out.print(k + " ");
		}
		
	}

	
	public static void main(String[] args) {

		LottoPractice lt = new LottoPractice();
		lt.start();

	}

}