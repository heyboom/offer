package jianzhioffer;

public class 变态跳台阶 {

	// f(n) = 2 * f(n - 1)
	public int JumpFloorII(int target) {
		if(target <= 0)
			throw new RuntimeException("Argument Error");
		int b = 1;
		for(int i = 2; i <= target; i++) {
			b <<= 1;
		}
		return b;
	}
}
