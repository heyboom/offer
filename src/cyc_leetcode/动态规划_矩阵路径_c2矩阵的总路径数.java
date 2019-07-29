package cyc_leetcode;

import java.util.Arrays;

public class 动态规划_矩阵路径_c2矩阵的总路径数 {

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		for(int j = 0; j < m; j++) {
			dp[0][j] = 1;
		}
		for(int i = 1; i < n; i++)
			for(int j = 1; j < m; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		return dp[n - 1][m - 1];
	}
	
	//改进
	//使用连个数组, pre, cur;
	public int uniquePaths1(int m, int n) {
		int[] pre = new int[n];
		int[] cur = new int[n];
		Arrays.fill(pre, 1);
		Arrays.fill(cur, 1);
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				cur[j] = cur[j - 1] + pre[j];
				pre[j] = cur[j];
			}
		}
		return cur[n - 1];
	}
	
	//再次改进，
	//pre[j] 就是 cur[j]未更新之前的数据
	public int uniquePaths2(int m, int n) {
		int[] cur = new int[n];
		Arrays.fill(cur, 1);
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++) {
				cur[j] = cur[j - 1] + cur[j];
			}
		return cur[n - 1];
	}
}
