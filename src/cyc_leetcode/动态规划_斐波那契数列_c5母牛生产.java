package cyc_leetcode;

/*
 * 母牛数量：dp[i] = dp[i - 1] + dp[i - 3]
 * 今年母牛数量为去年母牛数量+三年前母牛生产的小牛数量（比例，一只母牛生产一只小牛，所以等效于三年前母牛数量）
 * 
 * 小牛数量:  tp[i] = tp[i - 1] + dp[i - 1];   式②
 * 今年小牛数量为tp[i- 1] - (dp[i] - dp[i - 1]) + dp[i - 1] + (dp[i] - dp[i - 1])
 * 意思是，去年小牛数量 - 今年晋升成母牛的数量 + 去年母牛数量 + 今年晋升成母牛的数量
 * 简化后得式②
 */
public class 动态规划_斐波那契数列_c5母牛生产 {

	public static void main(String[] args) {
		动态规划_斐波那契数列_c5母牛生产 demo = new 动态规划_斐波那契数列_c5母牛生产();
		for(int i = 1; i <= 10; i++) {
			System.out.println(demo.cattleFarmNumber(i));
		}
	}
	
	public int cattleFarmNumber(int n) {
		int dp3year = 0, dp2year = 1, dp1year = 0;
		int tp1year = 1;
		int sumnyear = 0;
		for(int i = 1; i <= n; i++) {
			int tmpdp1year = dp1year;
			int tmpdp2year = dp2year;
			dp1year = dp1year + dp3year;
			dp2year = tmpdp1year;
			dp3year = tmpdp2year;
			tp1year = tp1year + tmpdp1year;
			sumnyear = dp1year + tp1year;
		}
		return sumnyear;
	}
}
