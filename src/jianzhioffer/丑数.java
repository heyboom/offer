package jianzhioffer;

public class 丑数 {

	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(3));
	}
	
	public static int GetUglyNumber_Solution2(int index) {
		if(index <= 0)
			return 0;
		int[] T2 = new int[index];
		int[] T3 = new int[index];
		int[] T5 = new int[index];
		int p2 = 0, p3 = 0, p5 = 0;
		int num = 0;
		for(int i = 0; i < index; i++) {
			if(i == 0) {
				num = 1;
			} else {
				num = Math.min(T2[p2], Math.min(T3[p3], T5[p5]));
			}
			T2[i] = num * 2;
			T3[i] = num * 3;
			T5[i] = num * 5;
			if(T2[p2] == num) p2++;
			if(T3[p3] == num) p3++;
			if(T5[p5] == num) p5++;
		}
		return num;
	}
	
	public static int GetUglyNumber_Solution(int index) {
		if(index <= 0)
			return 0;
		int[] result = new int[index];
		result[0] = 1;
		int P2 = 0, P3 = 0, P5 = 0;
		int M2 = 2, M3 = 3, M5 = 5;
		for(int i = 1; i < index; i++) {
			result[i] = Math.min(M2, Math.min(M3, M5));
			if(M2 ==result[i]) {
				P2++;
				M2 = result[P2] * 2;
			}
			if(M3 ==result[i]) {
				P3++;
				M3 = result[P3] * 3;
			}
			if(M5 ==result[i]) {
				P5++;
				M5 = result[P5] * 5;
			}
		}
		return result[index - 1];
	}
}
