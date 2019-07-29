package cyc_leetcode;

public class 动态规划_数组区间_c1数组区间和 {

	class NumArray{
		
		int[] sums;
		
		public NumArray(int[] nums) {
			sums = new int[nums.length + 1];
			for(int i = 1; i <= nums.length; i++) {
				sums[i] = sums[i - 1] + nums[i - 1];
			}
		}
		
		public int sumRange(int i, int j) {
			return sums[j + 1] - sums[i];
		}
	}
}
