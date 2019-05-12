package jianzhioffer;

public class 二进制中1的个数 {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(n & 1);
		n >>>= 1;
		System.out.println(n & 1);
		n >>>= 1;
		System.out.println(n & 1);
		System.out.println(NumberOf1(-3));
	}
	
	public static int NumberOf1(int n) {
		int count = 0;
		while(n != 0) {
			if((n & 1) == 1)
				count++;
			n >>>= 1;
		}
		return count;
	}
	
}
