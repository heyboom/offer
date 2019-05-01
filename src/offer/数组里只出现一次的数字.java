package offer;

/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */

public class 数组里只出现一次的数字 {

	public static void main(String[] args) {
		int[] array = {2,4,3,6,3,2,5,5};
		int[] num1 = {0};
		int[] num2 = {0};
		FindNumsAppearOnce(array, num1, num2);
	}
	
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if(array == null || array.length == 0)
			return;
		int pivot = 0;
		for(int i = 0; i < array.length; i++) {
			pivot ^= array[i];
		}
		int index = findFirstOneInNum(pivot);
		for(int i = 0; i < array.length; i++) {
			if(hasOneInPos(array[i], index)) {
				num1[0] ^= array[i];
			}else {
				num2[0] ^= array[i];
			}
		}
	}
	
	private static int findFirstOneInNum(int num) {
		int index = 0;
		while(index < 32 && (num & 1) == 0) {
			num >>= 1;
			index++;
		}
		return index;
	}
	
	private static boolean hasOneInPos(int num, int index) {
		num >>= index;
		return (num & 1) == 1;
	}
}
