package offer;

/*
 * z给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * z其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * z不能使用除法
 */

public class 构建乘积数组 {

	public int[] multiply(int[] A) {
		int[] B = new int[A.length];
		B[0] = 1;
		for(int i = 1; i < A.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		int tmp = 1;
		for(int j = A.length - 2; j >= 0; j--) {
			tmp *= A[j + 1];
			B[j] *= tmp;
		}
		return B;
	}
}
