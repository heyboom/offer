package offer;

public class 数字在排序数组中出现的次数 {

	public static void main(String[] args) {
		int[] array = {3};
		System.out.println(GetNumberOfK(array, 3));
	}
	
	public static int GetNumberOfK(int [] array , int k) {
		if(array == null || array.length == 0)
			return 0;
		int index = binarySearch(array, k);
		if(index == -1)
			return 0;
		int left = index - 1, right = index + 1;
		int count = 1;
		while(left >= 0 && array[left--] == k) count++;
		while(right <= array.length - 1 && array[right++] == k) count++;
		return count;
	}
	
	private static int binarySearch(int[] array, int k) {
		int left = 0;
		int right = array.length - 1;
		int middle = 0;
		while(left < right && array[middle] != k) {
			middle = (left + right) / 2;
			if(array[middle] == k) {
				break;
			}else if(k < array[middle]) {
				right = middle - 1;
			}else {
				left = middle + 1;
			}
		}
		if(array[middle] != k) {
			return -1;
		}
		return middle;
	}
}
