package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class 把数组排成最小的数 {

	public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0)
			return "";
		List<Integer> list = new ArrayList<>();
		for(Integer i : numbers) {
			list.add(i);
		}
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				return (s1 + s2).compareTo(s2 + s1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(Integer itr : list) {
			sb.append(itr);
		}
		return sb.toString();
	}
}
