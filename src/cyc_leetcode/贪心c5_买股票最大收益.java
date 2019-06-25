package cyc_leetcode;

public class 贪心c5_买股票最大收益 {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		int max = 0;
		int min = prices[0];
		for(int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}
}
