package jianzhioffer;
/*
 * str有重复数字，如abb
 * 去重的思想，如果b已经到过第一位，那么后面的b就不需要再次到第一位
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class 字符串的排列 {

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> list = Permutation(str);
		System.out.println(list);
	}
	
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		if(str == null || str.length() == 0)
			return list;
		char[] chars = str.toCharArray();
		PermutationHelper(chars, 0, list);
		Collections.sort(list);	//该死的牛客，要按照字母间顺序输出
		return list;
	}
	
	public static void PermutationHelper(char[] chars, int start, ArrayList<String> list){
		if(start == chars.length - 1)
			list.add(String.valueOf(chars));
		HashSet<Character> set = new HashSet<>();
		for(int i = start; i < chars.length; i++) {
			if(set.contains(chars[i]))
				continue;
			set.add(chars[i]);
			swap(chars, start, i);
			PermutationHelper(chars, start + 1, list);
			swap(chars, start, i);
		}
	}
	
	public static void swap(char[] chars, int pos1, int pos2) {
		char tmp = chars[pos1];
		chars[pos1] = chars[pos2];
		chars[pos2] = tmp;
	}
}
