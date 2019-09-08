package 浦发银行;
/*
 *       猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个，
第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃前一天剩下的一半零一个。
到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘多少个桃子？
	答案为：1534个。
 */
public class 猴子吃桃子 {

	public static void main(String[] args) {
		System.out.println(eatPeach(10, 1));
	}
	
	// 一共吃了多少天，最后一天个数
	public static int eatPeach(int n, int lastNum) {
		int sum = lastNum;
		for (int i = 1; i < n; i++) {
			sum = (sum + 1) * 2;
		}
		return sum;
	}
}
