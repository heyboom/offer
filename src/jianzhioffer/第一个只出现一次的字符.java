package jianzhioffer;
import java.util.Map;
import java.util.LinkedHashMap;
public class 第一个只出现一次的字符 {

	public int FirstNotRepeatingChar(String str) {
		if(str == null || str.length() == 0)
			return -1;
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), -1);
			} else {
				map.put(str.charAt(i), i);
			}
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() != -1)
				return entry.getValue();
		}
		return -1;
	}
}
