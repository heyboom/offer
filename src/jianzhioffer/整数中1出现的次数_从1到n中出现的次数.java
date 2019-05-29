package jianzhioffer;

public class 整数中1出现的次数_从1到n中出现的次数 {

	public int NumberOf1Between1AndN_Solution(int n) {
		if(n < 1)
			return 0;
		int count = 0;
		for(int i = 1; i <= n; i++) {
			count += NumberOf1InAnyNum(i);
		}
		return count;
	}
	
	public int NumberOf1InAnyNum(int num) {
		int count = 0;
		while(num != 0) {
			if(num % 10 == 1) {
				count++;
			}
			num = num / 10;
		}
		return count;
	}
}
