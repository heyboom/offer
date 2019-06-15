package cyc_leetcode;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class c7_最长子序列 {

	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> d = new ArrayList<>();
		String[] strA = {"ab","ba","monkey",""};
		for(String str : strA) {
			d.add(str);
		}
		System.out.println(findLongestWord(s, d));
	}
	
	public static String findLongestWord(String s, List<String> d) {
		if(s == null || d == null)
			return "";
		String longestWord = "";
		for(String str : d) {
			if(longestWord.length() > str.length() 
					|| longestWord.length() == str.length() && longestWord.compareTo(str) < 0) {
				continue;
			}
			if(core(s, str)) {
				longestWord = str;
			}
		}
		return longestWord;
	}
	
	public static String findLongestWord2(String s, List<String> d) {
		if(s == null || d == null)
			return "";
		Collections.sort(d, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o2.length() - o1.length();
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		for(String str: d) {
			if(core(s, str)) {
				return str;
			}
		}
		return "";
	}
	
	public static boolean core(String s, String str) {
		int i = 0, j = 0;
		while(i < s.length() && j < str.length()) {
			if(s.charAt(i) == str.charAt(j)) {
				j++;
			}
			i++;
		}
		return j == str.length();
	}
}
