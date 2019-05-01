package offer;

/*
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class 丑数 {

	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(4));
	}
	public static int GetUglyNumber_Solution(int index) {
		if(index <= 0) {
			return 0;
		}
		int[] result = new int[index];
		result[0] = 1;
		int T2 = 0, T3 = 0, T5 = 0;
		for(int i = 1; i < index; i++) {
			int M2 = result[T2] * 2;
			int M3 = result[T3] * 3;
			int M5 = result[T5] * 5;
			int next = Math.min(Math.min(M2, M3), M5);
			result[i] = next;
			if(next == M2) T2++;
			if(next == M3) T3++;
			if(next == M5) T5++;
		}
		return result[index - 1];
	}
}
