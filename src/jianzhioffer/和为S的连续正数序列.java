package jianzhioffer;
import java.util.ArrayList;

public class 和为S的连续正数序列 {

	public static void main(String[] args) {
		System.out.println(FindContinuousSequence(15));
	}
	
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if(sum < 3)
			return lists;
		int small = 1;
		int big = 2;
		int tmp = 3;
		while(small < (1 + sum) / 2 && small < big) {
			if(tmp == sum) {
				lists.add(genericList(small, big));
				big++;
				tmp += big;
			} else if(tmp < sum) {
				big++;
				tmp += big;
			} else {
				tmp -= small;
				small++;
			}
		}
		return lists;
	}
	
	public static ArrayList<Integer> genericList(int small, int big){
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = small; i <= big; i++) {
			list.add(i);
		}
		return list;
	}
}
