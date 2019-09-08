package 浦发银行;

//https://blog.csdn.net/qq_36134761/article/details/80385862

public class 凯撒加密解密 {

	public static void main(String[] args) {
		System.out.println(encry("xyZ", 3));
		System.out.println(decry("abC", 3));
	}
	
	public static String encry(String str, int loop) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				char nc = (char) ((c - 'A' + loop) % 26 + 'A');
				sb.append(nc);
			} else if (c >= 'a' && c <= 'z') {
				char nc = (char) ((c - 'a' + loop) % 26 + 'a');
				sb.append(nc);
			}
		}
		return sb.toString();
	}
	
	public static String decry(String str, int loop) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				char nc = (char) ((c - 'A' + (26 - loop)) % 26 + 'A');
				sb.append(nc);
			} else if (c >= 'a' && c <= 'z') {
				char nc = (char) ((c - 'a' + (26 - loop)) % 26 + 'a');
				sb.append(nc);
			}
		}
		return sb.toString();
	}
}
