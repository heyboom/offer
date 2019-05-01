package offer;

public class 二叉树的下一个节点 {

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
		if(pNode.next != null && pNode.next.left == pNode) {
			return pNode.next;
		}
		if(pNode.next != null && pNode.next.right == pNode) {
			TreeLinkNode tmp = pNode.next;
			while(tmp.next != null && tmp.next.left != tmp) {
				tmp = tmp.next;
			}
			return tmp.next;
		}
		return null;
	}
}
