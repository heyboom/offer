package leetcode;

public class 买股票的最佳时机121 {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int max = 0;
		int minCur = prices[0];
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > minCur) {
				max = Math.max(max, prices[i] - minCur);
			}else {
				minCur = prices[i];
			}
		}
		return max;
	}
}
