package test;

public class TestArray {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = a;
		b[0] = 8;
		System.out.println(a[0]);
	}
	
}
