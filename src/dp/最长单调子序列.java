package dp;

/*
 * https://blog.csdn.net/love_phoebe/article/details/74279763
 */

public class 最长单调子序列 {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 2, 4, 0, 5, 3};
		System.out.println(getLength(num));
	}
	
	public static int getLength(int[] num) {
		int len;
		if(num == null || (len = num.length) == 0)
			return 0;
		int[] dp = new int[len + 1];
		for(int i = 1; i <= len; i++)
			dp[i] = 1;
		int max = dp[0];
		for(int i = 1; i <= len; i++)
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], num[i - 1] > num[j - 1] ? dp[j] + 1 : 1);
				max = Math.max(max, dp[i]);
			}
		return max;
	}
}
