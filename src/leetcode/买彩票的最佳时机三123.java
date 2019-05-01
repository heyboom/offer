package leetcode;

public class 买彩票的最佳时机三123 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(maxProfit(arr));
	}
	
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int maxOne = 0;
		int maxTwo = 0;
		int i = 0;
		while(i < prices.length) {
			while(i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
			int min = prices[i++];
			while(i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
			if(i < prices.length) {
				int max = prices[i++] - min;
				if(maxOne <= maxTwo && maxOne < max) maxOne = max;
				if(maxTwo <= maxOne && maxTwo < max) maxTwo = max;
			}
		}
		return maxOne + maxTwo;
	}
	
}
