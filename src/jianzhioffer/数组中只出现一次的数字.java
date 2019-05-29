package jianzhioffer;

public class 数组中只出现一次的数字 {

	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if(array == null || array.length < 2)
			return;
		int num = 0;
		for(int i = 0; i < array.length; i++) {
			num ^= array[i];
		}
		int index = getFirstOne(num);
		if(index == 32)
			return;
		for(int i = 0; i < array.length; i++) {
			if(hasOneInPosK(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}
	
	public int getFirstOne(int num) {
		int count = 0;
		while((num & 1) != 1 && count < 32) {
			count++;
			num >>>= 1;
		}
		return count;
	}
	
	public boolean hasOneInPosK(int num, int k) {
		num >>>= k;
		return (num & 1) == 1;
	}
}
