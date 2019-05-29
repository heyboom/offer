package jianzhioffer;
/*
 * 感觉用hashmap是最简单的，但是剑指offer中没有用
 */

import java.util.Map;
import java.util.HashMap;

public class 数组中出现次数超过一半的数字 {

	public int MoreThanHalfNum_Solution(int [] array) {
		if(array == null || array.length <= 0)
			return 0;
		Map<Integer, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			if(!hashMap.containsKey(array[i])) {
				hashMap.put(array[i], 1);
			} else {
				hashMap.put(array[i], hashMap.get(array[i]) + 1);
			}
		}
		int targetLen = array.length / 2;
		int result = 0;
		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if(entry.getValue() > targetLen) {
				result = entry.getKey();
				break;
			}
		}
		return result;
	}
	
	public int MoreThanHalfNum_Solution2(int [] array) {
		if(array == null || array.length == 0)
			return 0;
		int result = array[0];
		int count = 1;
		for(int i = 1; i < array.length; i++) {
			if(count == 0) {
				result = array[i];
				count = 1;
			} else if(array[i] == result) {
				count++;
			} else {
				count--;
			}
		}
		count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == result)
				count++;
		}
		result = count > array.length / 2 ? result : 0;
		return result;
	}
}
