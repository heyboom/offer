package 浦发银行;

/**
 * 如，1548， 4+8=12
 *
 */
public class 找出正整数中偶数并相加 {

	public static void main(String[] args) {
		System.out.println(getSum(154218));
	}
	
	public static Long getSum(int num) {
		Long sum = 0L;
		while (num != 0) {
			int n = num % 10;
			if (isEven(n)) {
				sum += n;
			}
			num = num / 10;
		}
		return sum;
	}
	
	private static boolean isEven(int num) {
		if ((num & 1) == 0)
			return true;
		return false;
	}
}
