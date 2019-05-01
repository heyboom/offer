package offer;

public class 矩形覆盖 {

	public int RectCover(int target) {
		if(target == 0) {
			return 0;
		}
		if(target == 1 || target == 2) {
			return target;
		}
		return RectCover(target - 1) + RectCover(target - 2);
	}
}
