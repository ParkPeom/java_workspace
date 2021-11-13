package com.codechobo.itwill.collection;
/*
K:key
V:value
E:element

짧고 간략하게
*/
public class GenericTest<E> {
	private E data;
	public GenericTest() {		
	}
	public GenericTest(E data) {
		this.data = data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public E getData(){
		return data;
	}	
}
