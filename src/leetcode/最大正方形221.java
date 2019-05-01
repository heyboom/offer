package leetcode;

public class 最大正方形221 {

	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		int result = 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == '1') {
					dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
					result = dp[i + 1][j + 1] > result ? dp[i + 1][j + 1] : result;
				}
			}
		return result * result;
	}
}
