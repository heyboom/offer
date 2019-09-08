package 笔试;

public class 最长公共子串 {

	public static void main(String[] args) {
		String str1 = "abcdAAAAf";
		String str2 = "mssAAAcAeabcd";
		System.out.println(longestString(str1, str2));
	}
	
	public static int longestString(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int maxLen = 0;
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; i++)
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0; 
				}
				maxLen = Math.max(maxLen, dp[i][j]);
			}
		return maxLen;
	}
}
