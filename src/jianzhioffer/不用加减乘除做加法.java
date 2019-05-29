package jianzhioffer;

public class 不用加减乘除做加法 {

	public int Add(int num1,int num2) {
		while(num2 != 0) {
			int tmp = num1;
			num1 = num1 ^ num2;
			num2 = (tmp & num2) << 1;
		}
		return num1;
	}
}
