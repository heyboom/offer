package cyc_leetcode;

public class 贪心c10_子数组最大和 {

	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int max = nums[0];
		int curSum = nums[0];
		for(int i = 1; i < nums.length; i++) {
			curSum = curSum > 0 ? nums[i] + curSum : nums[i];
			max = Math.max(curSum, max);
		}
		return max;
	}
}
