package cyc_leetcode;

public class 动态规划_股票交易_c2需要交易费用的股票交易 {

	public int maxProfit(int[] prices, int fee) {
		if (prices == null || prices.length == 0 || fee < 0) {
			return 0;
		}
		int N = prices.length;
		int[] buy = new int[N];
		int[] s1 = new int[N];
		int[] sell = new int[N];
		int[] s2 = new int[N];
		buy[0] = s1[0] = -prices[0];
		sell[0] = s2[0] = 0;
		for (int i = 1; i < N; i++) {
			buy[i] = Math.max(s2[i - 1], sell[i - 1]) - prices[i];
			s1[i] = Math.max(buy[i - 1], s1[i - 1]);
			sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i] - fee;
			s2[i] = Math.max(sell[i - 1], s2[i - 1]);
		}
		return Math.max(sell[N - 1], s2[N - 1]);
	}
}
