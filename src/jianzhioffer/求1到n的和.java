package jianzhioffer;

public class 求1到n的和 {

	public int Sum_Solution(int n) {
		int sum = 0;
		boolean flag = (n > 0) && ((sum =n + Sum_Solution(n - 1)) > 0);
		return sum;
	}
}
