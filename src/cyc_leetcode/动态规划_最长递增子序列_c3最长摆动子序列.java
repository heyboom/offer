package cyc_leetcode;

public class 动态规划_最长递增子序列_c3最长摆动子序列 {

	public int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] up = new int[len];
		int[] down = new int[len];
		up[0] = 1;
		down[0] = 1;
		for (int i = 1; i < len; i++) {
			if (nums[i] > nums[i - 1]) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i] < nums[i - 1]) {
				down[i] = up[i - 1] + 1;
				up[i] = up[i - 1];
			} else {
				up[i] = up[i - 1];
				down[i] = down[i - 1];
			}
		}
		return Math.max(up[len - 1], down[len - 1]);
	}
}
