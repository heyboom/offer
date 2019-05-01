package offer;

public class 二进制中1的个数 {

	/*
	 * 将n减去1,再与自身相与,即可将最后一位0消去
	 */
	public int NumberOf1(int n) {
		int count = 0;
		while(n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}
	
}
