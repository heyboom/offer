package sort2;
/*
 * 选择排序和冒泡排序思想的重要区别：
 * 选择排序是：位置拿着自己的数字 和后面的对比，亲自选择最小的。
 * 冒泡排序是：位置坐等着后面的位置把后面那部分的最小数字拿过来，然后做最终的决策。
 * 
 * 注意的一点是，都有两个for循环。
 * 第一个for循环既可以看作是迭代次数，也可以看作是每次迭代的最终确定的位置。
 * 为了简单，还是看作最终位置的好。也就是说，第i位的位置应该放哪个数字，然后安排j去做本次循环
 */
import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		selectSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void selectSort(int[] nums) {
		if(nums == null || nums.length == 0)
			return;
		int tmp;
		for(int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < nums.length; j++) {
				minIndex = nums[j] < nums[minIndex] ? j : minIndex;
			}
			tmp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = tmp;
		}
	}
}
