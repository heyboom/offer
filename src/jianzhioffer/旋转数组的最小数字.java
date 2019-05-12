package jianzhioffer;

//牛客网未通过

public class 旋转数组的最小数字 {

	public static void main(String[] args) {
		int[] arr = {4, 5, 1, 1, 1};
		System.out.println(minNumberInRotateArray(arr));
	}
	
	public static int minNumberInRotateArray(int [] array) {
		if(array == null || array.length == 0)
			return 0;
		int left = 0;
		int right = array.length - 1;
		if(array[left] == array[right])  //左边右边相等，12222旋转后22122这种情况,只能遍历
			return find(array);
		while(right - left > 1) {
			int mid = (left + right) / 2;
			if (array[mid] > array[left]) {  //mid比left大，最小值在右边
				left = mid;
			} else if (array[mid] == array[right]){  //.mid和right相等，右边只能是一条直线的情况，所以直接返回就好
				return array[mid];
			} else {  //最小值在左边
				right = mid;
			}
		}
		return array[right];
	}
	
	public static int find(int[] array) {
		int result = array[0];
		for(int i = 1; i < array.length; i++) { 
			result = Math.min(result, array[i]);
		}
		return result;
	}
}
