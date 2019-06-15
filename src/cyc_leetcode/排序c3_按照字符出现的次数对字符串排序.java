package cyc_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 排序c3_按照字符出现的次数对字符串排序 {

	public String frequencySort(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}
		Map<Character, Integer> frequencyForChar = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			frequencyForChar.put(s.charAt(i), frequencyForChar.getOrDefault(s.charAt(i), 0) + 1);
		}
		List<Character>[] buckets = new ArrayList[s.length() + 1];
		for(Character c : frequencyForChar.keySet()) {
			if(buckets[frequencyForChar.get(c)] == null) {
				buckets[frequencyForChar.get(c)] = new ArrayList<>();
			}
			buckets[frequencyForChar.get(c)].add(c);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = buckets.length - 1; i > 0; i--) {
			if(buckets[i] == null) {
				continue;
			}
			for(Character c : buckets[i]) {
				for(int j = 0; j < i; j++) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
}
