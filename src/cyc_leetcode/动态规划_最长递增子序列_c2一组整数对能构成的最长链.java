package cyc_leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class 动态规划_最长递增子序列_c2一组整数对能构成的最长链 {

	public int findLongestChain(int[][] pairs) {
		if (pairs == null) {
			return 0;
		}
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int len = pairs.length;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (pairs[j][1] < pairs[i][0]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
		int mxLen = 0;
		for (int num : dp) {
			if (num > mxLen) {
				mxLen = num;
			}
		}
		return mxLen;
	}
}
