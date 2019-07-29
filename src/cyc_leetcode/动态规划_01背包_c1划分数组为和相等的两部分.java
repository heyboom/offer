package cyc_leetcode;

public class 动态规划_01背包_c1划分数组为和相等的两部分 {

	public boolean canPartition(int[] nums) {
		int sum = caculate(nums);
		if ((sum & 1) == 1) {
			return false;
		}
		int W = sum / 2;
		boolean[] dp = new boolean[W + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = W; i >= num; i--) {
				dp[i] = dp[i] || dp[i - num];
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
