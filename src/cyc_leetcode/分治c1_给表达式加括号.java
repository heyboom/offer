package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 分治c1_给表达式加括号 {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ways = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
				for(Integer l : left) {
					for(Integer r : right) {
						switch (c) {
							case '+':
								ways.add(l + r);
								break;
							case '-':
								ways.add(l - r);
								break;
							case '*':
								ways.add(l * r);
								break;
						}
					}
				}
			}
		}
		if(ways.size() == 0) {
			ways.add(Integer.valueOf(input));
		}
		return ways;
	}
}
