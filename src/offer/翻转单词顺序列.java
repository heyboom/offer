package offer;


/*
 * z例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class 翻转单词顺序列 {

	public static void main(String[] args) {
		String str = "I am a student.";
		System.out.println(ReverseSentence(str));
	}
	
	public static String ReverseSentence(String str) {
		if(str == null || str.isEmpty()) {
			return "";
		}
		char[] strCopy = str.toCharArray();
		ReverseArray(strCopy, 0, str.length() - 1);
		int left = 0, right = 0;
		while(right <= strCopy.length) {
			if(strCopy[left] == ' ') {
				left++;
				right++;
			}
			if(right == str.length() || strCopy[right] == ' ' ) {
				ReverseArray(strCopy, left, right - 1);
				right++;
				left = right;
			}else {
				right++;
			}
		}
		return String.valueOf(strCopy);
	}
	
	private static void ReverseArray(char[] chars, int left, int right) {
		while(left < right) {
			char tmp = chars[left];
			chars[left] = chars[right];
			chars[right] = tmp;
			left++;
			right--;
		}
	}
}
