package cyc_leetcode;

public class 动态规划_分割整数_c1分割整数的最大乘积 {

	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
			}
		}
		return dp[n];
	}
}
