package jianzhioffer;
/*
 * 牛客网中的0出现的次数很多，但是我觉得不对，
 * 实际上，一副牌只有两个大小王，所以最后还需要对0的个数做个判断
 */


import java.util.Arrays;

public class 扑克牌顺子 {

	public static void main(String[] args) {
		int[] numbers = {0,3,2,6,0,4};
		System.out.println(isContinuous(numbers));
	}
	
	public static boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length != 5)
			return false;
		Arrays.sort(numbers);
		int gapCount = 0;
		int zeroCount = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 0) {
				zeroCount++;
				continue;
			}
			if(i >= 1 && numbers[i] == numbers[i - 1]) {
				return false;
			}
			if(i >= 1 && numbers[i - 1] != 0){
				gapCount = (numbers[i] - numbers[i - 1] - 1);
			}
		}
		if(zeroCount < 2 && zeroCount >= gapCount)
			return true;
		return false;
	}
}
