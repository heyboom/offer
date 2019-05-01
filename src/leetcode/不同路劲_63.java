package leetcode;

public class 不同路劲_63 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		boolean hasBarrier = false;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++) {
			if(obstacleGrid[i][0] == 1) {
				hasBarrier = true;
			}
			dp[i][0] = hasBarrier ? 0 : 1;
		}
		hasBarrier = false;
		for(int j = 0; j < n; j++) {
			if(obstacleGrid[0][j] == 1) {
				hasBarrier = true;
			}
			dp[0][j] = hasBarrier ? 0 : 1;
		}
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
			}
		return dp[m - 1][n - 1];
	}
	
}
