package jianzhioffer;

import java.util.Map;
import java.util.LinkedHashMap;

public class 字符流中第一个只出现一次的字符 {

	private Map<Character, Integer> charMap = new LinkedHashMap<>();
	
	public void Insert(char ch) {
		if(charMap.containsKey(ch)) {
			charMap.put(ch, -1);
		} else {
			charMap.put(ch, 1);
		}
	}
	
	public char FirstAppearingOnce() {
		for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return '#';
	}
}
