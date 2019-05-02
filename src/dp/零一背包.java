package dp;
/*
 * https://www.cnblogs.com/Christal-R/p/Dynamic_programming.html
 */

public class 零一背包 {

	public static void main(String[] args) {
		int[] C = {2, 3, 4, 5};
		int[] W = {3, 4, 5, 6};
		int V = 8;
		System.out.println(getMaxBenefit(C, W, V));
	}
	
	public static int getMaxBenefit(int[] C, int[] W, int V) {
		int n = C.length;
		int[][] dp = new int[n + 1][V + 1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= V; j++) {
				if(C[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - C[i - 1]] + W[i - 1]);
				}
			}
		return dp[n][V];
	}
}
