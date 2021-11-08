package com.codechobo.collection;

import java.util.ArrayList;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = new int[10];
		
		
		System.arraycopy(a, 0, b, 0, a.length);
		
		
		for(int arr : b) {
			System.out.println(arr);
		}
		
		
		
	}

}
