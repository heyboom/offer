package cyc_leetcode;

public class 贪心c6_买股票的最大收益2 {

	public static void main(String[] args) {
		int[] prices = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2)
			return 0;
		int profit = 0;
		int curMax = 0;
		int min = prices[0];
		for(int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				curMax = prices[i] - min;
				if(i == prices.length - 1 || prices[i + 1] < prices[i]) {
					profit += curMax;
					curMax = 0;
					min = Integer.MAX_VALUE;
				}
			}
		}
		return profit;
	}
	
	public static int maxProfit2(int[] prices) {
		int profit = 0, i = 0;
		while(i < prices.length) {
			while(i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
			int min = prices[i++];
			while(i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
			if(i < prices.length) {
				int max = prices[i++];
				profit += max - min;
			}
		}
		return profit;
	}
	
	//骚操作，在脑海里想象成股市图，本题的关键在于求出所有上升折线的总和，而折线，分段求和尾首相减是一样的
	//对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a)
	//因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
	public static int maxProfit3(int[] prices) {
		int profit = 0;
		for(int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
}
