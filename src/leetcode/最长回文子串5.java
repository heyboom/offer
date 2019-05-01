package leetcode;

public class 最长回文子串5 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aba"));
	}
	//默认 a单个字符是回文字串
	public static String longestPalindrome(String s) {
		if(s == null || s.isEmpty())
			return "";
		int n = s.length();
		String res = null;
		boolean[][] dp = new boolean[n][n];
		for(int i = n - 1; i >= 0; i--)
			for(int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
				if(dp[i][j] && (res == null || j - i + 1 > res.length()))
					res = s.substring(i, j + 1);
			}
		return res;
	}
}
