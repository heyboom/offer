package 浦发银行;

public class 判断素数 {

	public boolean isPrimeNumber(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
