package leetcode;

public class 爬楼梯_跳台阶_70 {

	//循环，动态规划
	public int climbStairs(int n) {
	    if(n < 1){
	        return 0;
	    }
	    int[] dp = new int[n];
	    dp[0] = 1;
	    if(n >= 2){
	        dp[1] = 2;
	        for(int i = 2; i < n; i++){
	            dp[i] = dp[i - 1] + dp[i - 2];  //dp的思想，想跳到n级,要么从n - 1级跳，要么从
	                                            //n- 2级跳.  斐波那契
	        }
	    }
	    return dp[n - 1];
	}
	
	//递归
	public int climbStairs2(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else {
			return climbStairs2(n - 1) + climbStairs2(n - 2);
		}
	}
}
