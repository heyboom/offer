package cyc_leetcode;

public class 动态规划_斐波那契数列_c1爬楼梯 {

	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int dplast = 1;
		int dpfirst = 1;
		for(int i = 2; i <= n; i++) {
			int tmp = dpfirst;
			dpfirst = dpfirst + dplast;
			dplast = tmp;
		}
		return dpfirst;
	}
}
