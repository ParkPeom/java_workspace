package com.codechobo.itwill.collection;
/*
K:key
V:value
E:element

ª�� �����ϰ�
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
