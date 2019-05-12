package jianzhioffer;

public class 斐波那契数列 {

	public int Fibonacci(int n) {
		if(n < 0)
			throw new RuntimeException("Argument Error");
		int a = 0, b = 1;
		while(n-- > 0) {
			int tmp = b;
			b = a + b;
			a = tmp;
		}
		return a;
	}
}
