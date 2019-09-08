package 笔试;

import java.util.ArrayList;
import java.util.List;

public class 字符串全排列 {
	
	public static void main(String[] args) {
		char[] str = new char[] {'A','B','C'};
		System.out.println(getString(str));
		System.out.println(getString(str).size());
	}

	public static List<String> getString(char[] str) {
		List<String> result = new ArrayList<>();
		if (str == null || str.length == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		boolean[] flag = new boolean[str.length];
		doCombination(sb, result, str, flag);
		return result;
	}
	
	//全排列
	private static void doPermutation(StringBuilder sb, List<String> result, char[] str) {
		if (sb.length() == str.length) {
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
			doPermutation(sb, result, str);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	//组合
	private static void doCombination(StringBuilder sb, List<String> result, char[] str, boolean[] flag) {
		if (sb.length() == str.length) {
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < str.length; i++) {
			if (flag[i]) {
				continue;
			}
			sb.append(str[i]);
			flag[i] = true;
			doCombination(sb, result, str, flag);
			sb.deleteCharAt(sb.length() - 1);
			flag[i] = false;
		}
	}
}
