package cyc_leetcode;

public class 动态规划_斐波那契数列_c2强盗打劫 {

	public int rob(int[] nums) {
		int preLast = 0, preFast = 0;
		for(int i = 0; i < nums.length; i++) {
			int tmp = preFast;
			preFast = Math.max(preLast + nums[i], preFast);
			preLast = tmp;
		}
		return preFast;
	}
}
