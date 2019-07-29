package cyc_leetcode;

//W 为背包总体积
//N 为物品数量
//weights 数组存储 N 个物品的重量
//values 数组存储 N 个物品的价值

public class 动态规划_01背包_c0 {

	public int knapsack(int W, int N, int[] weights, int[] values) {
		int[][] dp = new int[N + 1][W + 1];
		for (int i = 1; i <= N; i++) {
			int w = weights[i], v = values[i];
			for (int j = 1; j <= W; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= w) {
					dp[i][j] = Math.max(dp[i -1][j], dp[i - 1][j - w] + v);
				}
			}
		}
		return dp[N][W];
	}
	
	public int knapsack2(int W, int N, int[] weights, int[] values) {
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int w = weights[i], v = values[i];
			for (int j = W; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		return dp[N];
	}
}
