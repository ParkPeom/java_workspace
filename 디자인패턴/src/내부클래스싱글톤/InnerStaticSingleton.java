package ����Ŭ�����̱���;

import java.io.Serializable;

public class InnerStaticSingleton implements Serializable{ // ����ȭ 
	
	private InnerStaticSingleton() {
		
	}
	
	public static InnerStaticSingleton getInstance() {
		return InnerClass.instance;
	}

	private static class InnerClass {
		private static final InnerStaticSingleton instance = new InnerStaticSingleton();
	}
}

