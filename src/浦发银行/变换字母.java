package 浦发银行;

/**
 * 6.输入几个单词，将字母变换成另外一组单词输出？如果字母是i，则变换后的字母是26+i-1
 *
 */
public class 变换字母 {

	public static void main(String[] args) {
		System.out.println(change("abc"));
	}
	
	public static String change(String str) {
		StringBuilder sb = new StringBuilder();
		for (Character c : str.toCharArray()) {
			Character nc = (char) (c + 26 -1) ;
			sb.append(nc);
		}
		return sb.toString();
	}
}
