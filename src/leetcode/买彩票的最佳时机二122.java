package leetcode;

public class 买彩票的最佳时机二122 {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		System.out.println(maxProfit(num));
	}
	
	public static int maxProfit(int[] prices) {
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

}
