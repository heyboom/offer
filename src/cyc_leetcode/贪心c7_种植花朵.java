package cyc_leetcode;

public class 贪心c7_种植花朵 {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(flowerbed == null || flowerbed.length == 0)
			return false;
		for(int i = 0; i < flowerbed.length && n > 0; i++) {
			if(flowerbed[i] == 1) {
				continue;
			}
			int pre = i == 0 ? 0 : flowerbed[i - 1];
			int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
			if(pre == 0 && next == 0) {
				n--;
				flowerbed[i] = 1;
			}
		}
		return n == 0;
	}
}
