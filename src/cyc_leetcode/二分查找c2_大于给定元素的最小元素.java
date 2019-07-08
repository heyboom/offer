package cyc_leetcode;

public class 二分查找c2_大于给定元素的最小元素 {

	public static void main(String[] args) {
		char[] letters = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
		System.out.println(nextGreatestLetter(letters, 'e'));
	}
	
	public static char nextGreatestLetter(char[] letters, char target) {
		int l = 0, h = letters.length - 1;
		while (l < h) {
			int m = l + (h - l) / 2;
			if (letters[m] > target) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return letters[h] > target ? letters[h] : letters[0];
	}
}
