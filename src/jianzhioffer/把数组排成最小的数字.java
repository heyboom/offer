package jianzhioffer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 把数组排成最小的数字 {

	public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0)
			return "";
		List<Integer> list = new ArrayList<>();
		for(Integer num : numbers) {
			list.add(num);
		}
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String str1 = String.valueOf(o1);
				String str2 = String.valueOf(o2);
				return (str1 + str2).compareTo(str2 + str1);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(Integer i : list) {
			sb.append(i);
		}
		return sb.toString();
	}
}
