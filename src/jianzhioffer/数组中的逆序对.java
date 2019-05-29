package jianzhioffer;

import java.util.Arrays;

public class 数组中的逆序对 {

	public static void main(String[] args) {
		int[] src = {1, 2, 3};
		
		int[] des = Arrays.copyOf(src, 3);
		System.out.println(Arrays.toString(des));
	}
	
	public int InversePairs(int [] array) {
		if(array == null || array.length == 0)
			return 0;
		int[] copy = new int[array.length];
		int count = inversePairsCore(array, copy, 0, array.length - 1);
		return count;
	}
	
	public int inversePairsCore(int[] array, int[] copy, int low, int high) {
		if(low == high)
			return 0;
		int mid = (low + high) >> 1;
		int left = inversePairsCore(array, copy, low, mid) % 1000000007;
		int right = inversePairsCore(array, copy, mid + 1, high) % 1000000007;
		int i = mid;
		int j = high;
		int locCopy = high;
		int count = 0;
		for(; i >= low && j > mid;) {
			if(array[i] > array[j]) {
				count += j - mid;
				copy[locCopy--] = array[i--];
				if(count > 1000000007)
					count %= 1000000007;
			} else {
				copy[locCopy--] = array[j--];
			}
		}
		while(i >= low) copy[locCopy--] = array[i--];
		while(j > mid) copy[locCopy--] = array[j--];
		System.arraycopy(copy, low, array, low, high - low + 1);
		return (count + left + right) % 1000000007;
	}
}
