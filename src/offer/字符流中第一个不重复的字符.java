package offer;

import java.util.*;

public class 字符流中第一个不重复的字符 {

	private Map<Character, Integer> map = new LinkedHashMap<>();
	private StringBuilder str = new StringBuilder();
	
	public void Insert(char ch) {
		if(map.containsKey(ch)) {
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
		}
		str.append(ch);
	}
	
	public char FirstAppearingOnce() {
		if(str.length() == 0)
			return '#';
		for(int i = 0; i < str.length(); i++) {
			if(map.get(str.charAt(i)) == 1) {
				return str.charAt(i);
			}
		}
		return '#';
	}
}
