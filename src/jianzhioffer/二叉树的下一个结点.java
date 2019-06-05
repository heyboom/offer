package jianzhioffer;

public class 二叉树的下一个结点 {

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode == null)
			return null;
		if(pNode.right != null) {
			TreeLinkNode tmp = pNode.right;
			while(tmp.left != null) {
				tmp = tmp.left;
			}
			return tmp;
		}
		if(pNode.next != null && pNode == pNode.next.left) {
			return pNode.next;
		}
		if(pNode.next != null && pNode == pNode.next.right){
			//说明该最小子树遍历完成，应该找到该最小子树的父节点,即寻找此最小子树的边界
			//如果找不到，说明整个大树都遍历完成,返回null
			TreeLinkNode tmp = pNode.next;
			while(tmp.next != null && tmp.next.left != tmp) {
				tmp = tmp.next;
			}
			return tmp.next;
		}
		return null;
	}
}
