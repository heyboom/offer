package cyc_leetcode;

public class 动态规划_斐波那契数列_c3强盗在环形街区打劫 {

	public int rob(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1){
			return nums[0];
		}
		return Math.max(robHelper(nums, 0, nums.length - 1), robHelper(nums, 1, nums.length));
	}
	
	private int robHelper(int[] nums, int start, int end) {
		int preSlow = 0, preFast = 0;
		for (int i = start; i < end; i++) {
			int tmp = preFast;
			preFast = Math.max(preSlow + nums[i], preFast);
			preSlow = tmp;
		}
		return preFast;
	}
}
