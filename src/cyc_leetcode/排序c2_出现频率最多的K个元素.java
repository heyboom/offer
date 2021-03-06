package cyc_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 排序c2_出现频率最多的K个元素 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyForNum = new HashMap<>();
		for(int num : nums) {
			frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
		}
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		for(int key : frequencyForNum.keySet()) {
			int frequency = frequencyForNum.get(key);
			if(buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<>();
			}
			buckets[frequency].add(key);
		}
		List<Integer> topK = new ArrayList<>();
		for(int i = buckets.length - 1; i > 0 && topK.size() < k; i--) {
			if(buckets[i] == null) {
				continue;
			}
			if (topK.size() + buckets[i].size() <= k) {
				topK.addAll(buckets[i]);
			} else {
				topK.addAll(buckets[i].subList(0, k - topK.size()));
			}
		}
		return topK;
	}
}
