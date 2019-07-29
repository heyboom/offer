package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 动态规划_分割整数_c2按平方数来分割整数 {

	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		List<Integer> squareList = generateList(n);
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (Integer square : squareList) {
				if (square > i) {
					break;
				}
				min = Math.min(min, dp[i - square] + 1);
			}
			dp[i] = min;
		}
		return dp[n];
	}
	
	private List<Integer> generateList(int n){
		List<Integer> squareList = new ArrayList<>();
		int square = 1;
		int diff = 3;
		while (square <= n) {
			squareList.add(square);
			square += diff;
			diff += 2;
		}
		return squareList;
	}
}
