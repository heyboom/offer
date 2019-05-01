package leetcode;

public class 最大子序和53 {

	public boolean invalidInput = false;
	
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			invalidInput = true;
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}

}
