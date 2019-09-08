package 浦发银行;

/**
 * 输入某年某月某日，输出是当年的哪一天
 */
public class 当前日期是该年的第几天 {

	public static void main(String[] args) {
		System.out.println(getDay(2019, 8, 16));
	}
	
	public static int getDay(int year, int month, int day) {
		int[] day_31 = new int[]{1, 3, 5, 7, 8, 10, 12};
		int[] day_30 = new int[]{4, 6, 9, 11};
		int dayFeb = getDayOfFeb(year);
		int sum = 0;
		for (int mon : day_31) {
			if (month > mon) sum += 31;
		}
		for (int mon : day_30) {
			if (month > mon) sum += 31;
		}
		if (month > 2) sum += dayFeb;
		sum += day;
		return sum;
	}
	
	private static int getDayOfFeb(int year) {
		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		if (isLeapYear) {
			return 29;
		}
		return 28;
	}
}
