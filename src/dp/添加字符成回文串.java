package dp;

/*
 * https://blog.csdn.net/u013309870/article/details/75193592
 * 回文串是一个正读和反读都一样的字符串，比如level或者noon等等就是回文串。
 * 给你一个长度为n（ 3 <= N <= 5000. ）的字符串。问最少需要插入几个字符，能够使它变成回文串
 * 比如字符串 “Ab3bd”可以转换成(“dAb3bAd” or “Adb3bdA”). 但需要插入最少两个字符.
 * 动态规划求解；
 * 设ch[1]..ch[n]表示字符串1至n位；
 * i为左游标，j为右游标，则i从n递减，j从i开始递增。
 * min[i][j]表示i和j之间至少需要插入多少个字符才能对称，我们最终需要得到的值是min[1][n]。
 * 则递归关系和初始条件
 * 当ch[i]=ch[j]       min[i][j]=min[i+1][j-1];
 * 否则  min[i][j]=1+（min[i+1][j]和min[i][j-1]中的较小值）
 */
public class 添加字符成回文串 {

	public static void main(String[] args) {
		System.out.println(becomePalindrome(""));
	}
	
	public static int becomePalindrome(String s) {
		if(s == null || s.isEmpty())
			return 0;
		int len = s.length();
		int[][] dp = new int[len][len];
		for(int i = len - 1; i >= 0; i--)
			for(int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = (i + 1 >= len || j - 1 < 0) ? 0 : dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		return dp[0][len - 1];
	}
}
