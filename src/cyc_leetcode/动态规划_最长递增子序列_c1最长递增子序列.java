package cyc_leetcode;

public class 动态规划_最长递增子序列_c1最长递增子序列 {

	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
		int mxLen = 0;
		for (int lis : dp) {
			if (lis > mxLen) {
				mxLen = lis;
			}
		}
		return mxLen;
	}
}
