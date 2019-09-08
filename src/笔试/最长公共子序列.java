package 笔试;

public class 最长公共子序列 {

	public static void main(String[] args) {
		System.out.println(LCS("ABCEEEED", "bBCXSSD"));
	}
	
	public static int LCS(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return 0;
		}
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++)
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		return dp[len1][len2];
	}
}
