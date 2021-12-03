package 내부클래스싱글톤;

import java.io.Serializable;

public class InnerStaticSingleton implements Serializable{ // 직렬화 
	
	private InnerStaticSingleton() {
		
	}
	
	public static InnerStaticSingleton getInstance() {
		return InnerClass.instance;
	}

	private static class InnerClass {
		private static final InnerStaticSingleton instance = new InnerStaticSingleton();
	}
}

