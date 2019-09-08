package 浦发银行;
/**
 *z输入 n 和 b , 找出 1 到 n 中被 b 整除的个数.
 *z 输入6， 3 输出2
 *
 */
public class 被整除的个数 {

	public int getDivNum(int n, int b) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (isDivExact(i, b)) sum++;
		}
		return sum;
	}
	
	private boolean isDivExact(int num, int b) {
		return num % b == 0;
	}
}
