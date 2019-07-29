package cyc_leetcode;

public class 动态规划_股票交易_c1需要冷却期的股票交易 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int own_last = -prices[0];
		int not_own_last = 0;
		int not_own_last2 = 0;
		int res = 0;
		for (int price : prices) {
			int own = Math.max(own_last, not_own_last2 - price);
			int not_own = Math.max(not_own_last, own_last + price);
			
			own_last = own;
			not_own_last2 = not_own_last;
			not_own_last = not_own;
			res = Math.max(res, Math.max(own, not_own));
		}
		return res;
	}
	
	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int N = prices.length;
		int[] buy = new int[N];
		int[] s1 = new int[N];
		int[] sell = new int[N];
		int[] s2 = new int[N];
		s1[0] = buy[0] = -prices[0];
		sell[0] = s2[0] = 0;
		for (int i = 1; i < N; i++) {
			buy[i] = s2[i - 1] - prices[i];
			s1[i] = Math.max(buy[i - 1], s1[i - 1]);
			sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
			s2[i] = Math.max(s2[i - 1], sell[i - 1]);
		}
		return Math.max(sell[N - 1], s2[N - 1]);
	}
}
