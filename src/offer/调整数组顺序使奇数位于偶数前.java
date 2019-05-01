package offer;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前 {

	public static void main(String[] args) {
		int[] arr = {2,4,6,1,3,5,7};
		reOrderArray2(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void reOrderArray(int [] array) {
		if(array == null || array.length == 0) {
			return;
		}
		int[] oddsArr = new int[array.length];
		int[] evenArr = new int[array.length];
		int oddsLen = 0;
		for(int i = 0, j = 0, k = 0; k < array.length;) {
			if((array[k] & 1) == 1) {
				oddsArr[i++] = array[k++];
				oddsLen = i;
			}else {
				evenArr[j++] = array[k++];
			}
		}
		for(int i = 0; i < oddsLen; i++) {
			array[i] = oddsArr[i];
		}
		for(int j = oddsLen; j < array.length; j++) {
			array[j] = evenArr[j - oddsLen];
		}
	}
	
	public static void reOrderArray2(int [] array) {
		if(array == null) 
			return;
		boolean flag = true;
		for(int i = 0; i < array.length; i++) {
			for(int j = array.length -1; j >0; j--) {
				if((array[j] & 1) == 1 && (array[j - 1] & 1) == 0) {
					int tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
					flag = false;
				}
			}
			if(flag) 
				return;
		}
	}
}
