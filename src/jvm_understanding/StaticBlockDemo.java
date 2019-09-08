package jvm_understanding;

public class StaticBlockDemo {

	static int a = 2;
	
	static {
		// 如果在准备阶段，则a = 0;
		// 如果在初始化阶段， a = 2;
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
	}
}
