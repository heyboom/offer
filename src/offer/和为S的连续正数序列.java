package offer;

/*
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
import java.util.*;
public class 和为S的连续正数序列 {
	
	public static void main(String[] args) {
		System.out.println(FindContinuousSequence(3));
	}
	
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if(sum < 3){
			return result;
		}
		int left = 1, right = 1;
		int cur = 0;
		while(left <= right && right < sum) {
			cur = (right - left + 1) * (right + left) / 2;
			if(cur == sum) {
				cur = 0;
				for(int i = left; i <= right; i++) {
					list.add(i);
				}
				result.add(list);
				list = new ArrayList<>();
				right++;
			}else if(cur < sum) {
				right++;
			}else {
				left++;
			}
		}
		return result;
	}
	
}
