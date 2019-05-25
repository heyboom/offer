package jianzhioffer;

/*
 * str无重复数字，如abc
 */
import java.util.ArrayList;

public class 字符串的排列2 {

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> list = Permutation2(str);
		System.out.println(list);
	}
	
	//str无重复数字
	public static ArrayList<String> Permutation2(String str) {
		ArrayList<String> list = new ArrayList<>();
		if(str == null || str.length() == 0)
			return list;
		char[] chars = str.toCharArray();
		PermutationHelper2(chars, 0, list);
		return list;
	}
	
	public static void PermutationHelper2(char[] chars, int start, ArrayList<String> list) {
		if(start == chars.length - 1)
			list.add(String.valueOf(chars));
		for(int i = start; i < chars.length; i++) {
			swap(chars, start, i);
			PermutationHelper2(chars, start + 1, list);
			swap(chars, start, i);
		}
	}
	
	public static void swap(char[] chars, int pos1, int pos2) {
		char tmp = chars[pos1];
		chars[pos1] = chars[pos2];
		chars[pos2] = tmp;
	}
}
