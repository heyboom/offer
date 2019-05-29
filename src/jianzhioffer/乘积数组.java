package jianzhioffer;

import java.util.Arrays;

public class 乘积数组 {

	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		System.out.println(Arrays.toString(multiply(A)));
	}
	
	public static int[] multiply(int[] A) {
		if(A == null || A.length == 0)
			return A;
		int len = A.length;
		int[] B = new int[len];
		int[] C = new int[len];
		int[] D = new int[len];
		C[0] = 1;
		D[0] = 1;
		for(int i = 1; i < len; i++) {
			C[i] = C[i - 1] * A[i - 1];
			D[i] = D[i - 1] * A[len - i];
		}
		System.out.println(Arrays.toString(C));
		System.out.println(Arrays.toString(D));
		for(int i = 0; i < len; i++) {
			B[i] = C[i] * D[len - 1 - i];
		}
		return B;
	}
	
}
