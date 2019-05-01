package leetcode;

public class 打家劫舍198 {

	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int pre1 = 0;
		int pre2 = 0;
		for(int num : nums) {
			int tmp = pre1;
			pre1 = Math.max(pre2 + num, pre1);
			pre2 = tmp;
		}
		return pre1;
	}
}
