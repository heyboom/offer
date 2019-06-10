package cyc_leetcode_双指针;

public class c2_两数平方和 {

	public boolean judgeSquareSum(int c) {
		if(c < 0)
			return false;
		//其实很疑惑，right = c不行吗？
		int left = 0, right = (int)Math.sqrt(c);
		boolean result = false;
		while(left <= right) {
			int sum = left * left + right * right;
			if(sum == c) {
				result = true;
				break;
			} else if(sum < c) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}
