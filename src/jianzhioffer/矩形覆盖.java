package jianzhioffer;

public class 矩形覆盖 {

	public int RectCover(int target) {
		if(target == 0)
			return 0;
		int a = 1, b = 1;
		for(int i = 2; i <= target; i++) {
			int tmp = b;
			b = a + b;
			a = tmp;
		}
		return b;
	}
}
