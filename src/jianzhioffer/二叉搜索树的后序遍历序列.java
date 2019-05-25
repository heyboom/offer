package jianzhioffer;

/*
 * 二叉搜索树的后序序列满足此条件：
 * 数组中前半段小于数组最后一个数字，
 * 数组中间大于数组最后一个数字
 * 两段数组递归满足此条件。
 * 
 * 要注意 【5， 4， 3， 2， 1】或者顺序的这种单支结构
 */
public class 二叉搜索树的后序遍历序列 {

	public static void main(String[] args) {
		System.out.println(VerifySquenceOfBST(new int[] {7, 4, 6, 5}));
	}
	
	public static boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence == null || sequence.length == 0)
			return false;
		return verifyCore(sequence, 0, sequence.length - 1);
	}
	
	public static boolean verifyCore(int [] sequence, int start, int end) {
		if(start >= end)
			return true;
		int firstMax = start;
		int root = sequence[end];
		while(firstMax < end && sequence[firstMax] < root) firstMax++;
		for(int j = firstMax; j < end; j++) {
			if(sequence[j] < root)
				return false;
		}
		return verifyCore(sequence, start, firstMax - 1)
				&& verifyCore(sequence, firstMax, end - 1);
	}
}
