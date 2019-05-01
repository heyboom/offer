package offer;

import java.util.Arrays;

public class 二叉搜索树的后序遍历序列 {

	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence == null || sequence.length == 0)
			return false;
		boolean result = false;
		int rightIndex = findRightIndex(sequence);
		result = isRightTree(sequence, rightIndex) && isLeftTree(sequence, rightIndex);
		if(result && rightIndex > 0) {
			result = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rightIndex));
		}
		if(result && rightIndex != -1) {
			result = VerifySquenceOfBST(Arrays.copyOfRange(sequence, rightIndex, sequence.length - 1));
		}
		return result;
	}
	
	public int findRightIndex(int[] sequence) {
		int index = -1;
		for(int i = 0; i < sequence.length - 1; i++) {
			if(sequence[i] > sequence[sequence.length - 1]) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public boolean isRightTree(int[] sequence, int rightIndex) {
		if(rightIndex == -1) {
			return true;
		}
		for(int i = rightIndex; i < sequence.length - 1; i++) {
			if(sequence[i] < sequence[sequence.length - 1])
				return false;
		}
		return true;
	}
	
	public boolean isLeftTree(int[] sequence, int rightIndex) {
		if(rightIndex == 0) {
			return true;
		}
		int leftBorder = rightIndex - 1;
		if(rightIndex == -1) {
			leftBorder = sequence.length - 2;
		}
		for(int i = 0; i <= leftBorder; i++) {
			if(sequence[i] > sequence[sequence.length - 1])
				return false;
		}
		return true;
	}
}
