package offer;

public class 斐波那契数列 {

	public int Fibonacci(int n) {
		int[] result = {0, 1};
		if(n < 2) {
			return result[n];
		}
		int fibonacciFast = 1;
		int fibonacciSlow = 0;
		int fiboN = 0;
		for(int i = 2; i <= n; i++) {
			fiboN = fibonacciFast + fibonacciSlow;
			fibonacciSlow = fibonacciFast;
			fibonacciFast = fiboN;
		}
		return fiboN;
	}
}
