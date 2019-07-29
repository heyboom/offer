package cyc_leetcode;

public class 动态规划_数组区间_c2数组中等差递增子区间的个数 {

	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] dp = new int[A.length];
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			}
		}
		int sum = 0;
		for (int cnt : dp) {
			sum += cnt;
		}
		return sum;
	}
}
