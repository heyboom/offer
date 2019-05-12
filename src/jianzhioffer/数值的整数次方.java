package jianzhioffer;

public class 数值的整数次方 {

	public static void main(String[] args) {
		System.out.println(1 / 2.0);
	}
	
	public static double Power(double base, int exponent) {
		if(exponent == 0)
			return 1;
		double tmp = base;
		boolean isNeg = exponent < 0 ? true : false;
		exponent = Math.abs(exponent);
		for(int i =2; i <= exponent; i++) {
			tmp *= base;
		}
		return isNeg ? (1 / tmp) : tmp;
	}
}
