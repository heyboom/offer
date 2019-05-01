package tencent;

/*
 * 小Q打怪兽，打不过就收买它，然后这些已收买的怪兽就可以帮助他打接下来的怪兽。
 * 输入两个数组，一个武力值，一个所需金币
 * 输出通关所需的最小金币
 * 
 * 输入{8,5,10} {1,1,2}
 * 输出2
 * 
 * 输入{1，2，4，8}{1，2，1，2}
 * 输出6
 *
 *
 *思路：一遍，当前武力值打得过就过，打不过就收买
 *感觉不太对！！！！！！！！！！！！！！！！！！
 */

public class KillMonster {

	public static void main(String[] args) {
		int[] power = {8, 5, 10};
		int[] money = {1, 1, 2};
		System.out.println(caculate(power, money));
	}
	
	public static int caculate(int[] power, int[] money) {
		int curPower = 0;
		int curCost = 0;
		for(int i = 0; i < power.length; i++) {
			if(curPower < power[i]) {
				curPower += power[i];
				curCost += money[i];
			}
		}
		return curCost;
	}
}
