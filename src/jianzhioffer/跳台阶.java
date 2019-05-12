package jianzhioffer;

public class 跳台阶 {

	public int JumpFloor(int target) {
		if(target <= 0)
			throw new RuntimeException("Argument Error");
		int a = 1, b = 1;
		for(int i = 2; i <= target; i++) {
			int tmp = b;
			b = a + b;
			a = tmp;
		}
		return b;
	}
	
	public int JumpFloor2(int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= target; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[target];
	}
}
