package dp;

import java.util.Arrays;

/*
 * 在一个夜黑风高的晚上，有n（n <= 50）个小朋友在桥的这边，现在他们需要过桥，但是由于桥很窄，
 * 每次只允许不大于两人通过，他们只有一个手电筒，所以每次过桥的两个人需要把手电筒带回来，
 * i号小朋友过桥的时间为T[i]，两个人过桥的总时间为二者中时间长者。问所有小朋友过桥的总时间最短是多少。
 * 详见  https://blog.csdn.net/u013309870/article/details/75193592
 * opt[i] = min{opt[i-1] + a[1] + a[i] , opt[i-2] + a[1] + a[i] + 2 * a[2]}
 */

public class 小朋友过河 {

	public static void main(String[] args) {
		int[] T = {1, 2, 3, 4, 5};
		System.out.println(getMinTotalTime(T));
	}
	
	public static int getMinTotalTime(int[] T) {
		if(T == null || T.length == 0)
			return 0;
		Arrays.sort(T);
		if(T.length < 3)
			return T[T.length - 1];
		int[] dp = new int[T.length + 1];
		dp[0] = 0;
		dp[1] = T[0];
		dp[2] = T[1];
		for(int i = 3; i <= T.length; i++)
			dp[i] = Math.min(dp[i - 1] + T[0] + T[i - 1], dp[i - 2] + T[0] + T[i - 1] + 2 * T[1]);
		return dp[T.length];
	}
}
