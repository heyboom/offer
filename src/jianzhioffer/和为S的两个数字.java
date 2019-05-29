package jianzhioffer;
import java.util.ArrayList;

public class 和为S的两个数字 {

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if(array == null || array.length == 0) {
			return list;
		}
		int low = 0;
		int high = array.length - 1;
		while(low < high) {
			int tmp = array[low] + array[high];
			if(tmp == sum) {
				list.add(array[low]);
				list.add(array[high]);
				break;
			} else if (tmp > sum) {
				high--;
			} else {
				low++;
			}
		}
		return list;
	}
}
