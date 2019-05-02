package dp;

public class 最长单调连续子序列 {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 4, 9};
		System.out.println(getLength(num));
	}
	
	public static int getLength(int[] num) {
		int n;
		if(num == null || (n = num.length) == 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		int max = dp[1];
		for(int i = 2; i <= n; i++) {
			dp[i] = num[i - 1] > num[i - 2] ? dp[i - 1] + 1 : 1;
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
