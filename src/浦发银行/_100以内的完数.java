package 浦发银行;

import java.util.ArrayList;
import java.util.List;

public class _100以内的完数 {

	public static void main(String[] args) {
		System.out.println(isPerfectNumber(5));
	}
	
	public static List<Integer> getPerfectNumber(int threshold){
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= threshold; i++) {
			if (isPerfectNumber(i)) list.add(i);
		}
		return list;
	}
	
	public static boolean isPerfectNumber(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum == num;
	}
}
