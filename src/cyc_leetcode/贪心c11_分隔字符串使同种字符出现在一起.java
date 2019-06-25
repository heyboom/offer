package cyc_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 贪心c11_分隔字符串使同种字符出现在一起 {

	public static void main(String[] args) {
		String S = "jybmxfgseq";
		System.out.println(partitionLabels(S));
	}
	
	public static List<Integer> partitionLabels(String S) {
		List<Integer> list = new ArrayList<>();
		if(S == null || S.isEmpty())
			return list;
		Map<Character, Integer> charLastIndex = new HashMap<>();
		for(int i = 0; i < S.length(); i++) {
			charLastIndex.put(S.charAt(i), i);
		}
		int start = 0, end = 0;
		while(start < S.length()) {
			end = charLastIndex.get(S.charAt(start));
			for(int i = start + 1; i <= end; i++) {
				if(charLastIndex.get(S.charAt(i)) > end) {
					end = charLastIndex.get(S.charAt(i));
				}
			}
			list.add(end - start + 1);
			start = end + 1;
		}
		return list;
	}
}
