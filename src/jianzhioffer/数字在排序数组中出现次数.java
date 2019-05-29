package jianzhioffer;

public class 数字在排序数组中出现次数 {
	
	public static void main(String[] args) {
		int[] array = {1,2,2,3};
		System.out.println(GetNumberOfK(array, 2));
	}

	public static int GetNumberOfK(int [] array , int k) {
		if(array == null || array.length == 0)
			return 0;
		int first = getNumberOfFirstK(array, k);
		int last = getNumberOfLastK(array, k);
		if(first != -1 && last != -1)
			return last - first + 1;
		return 0;
	}
	
	public static int getNumberOfFirstK(int[] array, int k) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		while(low <= high) {
			mid = (low + high) / 2;
			if(array[mid] == k) {
				if(mid > 0 && array[mid - 1] == k) {
					high = mid - 1;
				} else {
					return mid;
				}
			} else if (k < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static int getNumberOfLastK(int[] array, int k) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		while(low <= high) {
			mid = (low + high) / 2;
			if(array[mid] == k) {
				if(mid < array.length - 1 && array[mid + 1] == k) {
					low = mid + 1;
				} else {
					return mid;
				}
			} else if(k < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
