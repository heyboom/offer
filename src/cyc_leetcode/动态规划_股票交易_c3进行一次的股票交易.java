package cyc_leetcode;

public class 动态规划_股票交易_c3进行一次的股票交易 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int minbuy = Integer.MAX_VALUE;
		int maxSell = 0;
		for (int price : prices) {
			minbuy = Math.min(minbuy, price);
			maxSell = Math.max(maxSell, price - minbuy);
		}
		return maxSell;
	}
}
