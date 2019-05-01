package offer;

public class 旋转数组的最小数字 {

	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[]{3,1,2}));
	}
	
	public static int minNumberInRotateArray(int [] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		if(array.length == 1) {
			return array[0];
		}
		int left = 0;
		int right = array.length - 1;
		if(array[left] < array[right])
			return array[0];
		while(left < right && (left + 1) != right) {
			int mid = (left + right) / 2;
			if(array[mid] == array[left] && array[mid] == array[right]) {
				return minInOrder(array);
			}
			if(array[mid] >= array[left]) {
				left = mid;
			}else if(array[mid] <= array[right]){
				right = mid;
			}
		}
		return array[right];
	}
	
	public static int minInOrder(int [] array) {
		int min = 0;
		for(int i = 1; i < array.length; i++) {
			if(array[i] < array[min]) {
				min = i;
			}
		}
		return array[min];
	}
}
