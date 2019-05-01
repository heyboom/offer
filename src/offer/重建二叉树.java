package offer;

import java.util.Arrays;

public class 重建二叉树 {

	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		TreeNode node = null;
		if(pre.length == 0 || in.length == 0) {
			return node;
		}
		int index = 0;	//在中序遍历中的位置
		node = new TreeNode(pre[0]);	//根节点
		for(int i = 0; i < in.length; i++) {
			if(in[i] == pre[0])
				index = i;
		}
		int leftLen = index - 0;		//左子树长度
		if(leftLen > 0) {
			node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + leftLen), Arrays.copyOfRange(in, 0, index));
		}
		int rightLen = in.length - index;		//右子树长度
		if(rightLen > 0) {
			node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + leftLen, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
		}
		return node;
	}
}
