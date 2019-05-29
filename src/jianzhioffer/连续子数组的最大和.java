package jianzhioffer;


public class 连续子数组的最大和 {

	public static void main(String[] args) {
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
	public static int FindGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0)
			return 0;
		int[] dp = new int[array.length];
		dp[0] = array[0];
		int sumMax = dp[0];
		for(int i = 1; i < array.length; i++) {
			dp[i] = Math.max(array[i], array[i] + dp[i -1]);
			if(dp[i] > sumMax)
				sumMax = dp[i];
		}
		return sumMax;
	}
}
