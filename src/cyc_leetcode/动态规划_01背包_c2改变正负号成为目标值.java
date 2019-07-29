package cyc_leetcode;

public class 动态规划_01背包_c2改变正负号成为目标值 {

	public int findTargetSumWays(int[] nums, int S) {
		int sum = caculate(nums);
		if (sum < S || ((sum + S) & 1) == 1) {
			return 0;
		}
		int W = ((sum + S) >> 1);
		int[] dp = new int[W + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int i = W; i >= num; i--) {
				dp[i] = dp[i] + dp[i - num];
			}
		}
		return dp[W];
	}
	
	private int caculate(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}
}

