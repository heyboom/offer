package jianzhioffer;

import java.util.Arrays;

public class o37_序列化二叉树 {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		n1.left = n2;
		n2.right = n3;
		n3.right = n4;
		String str = Serialize(n1);
		
		System.out.println(str);
		
		TreeNode node = Deserialize("5,4,#,3,#,2");
		
		System.out.println(node);
	}
	
	public static String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
	
	public static TreeNode Deserialize(String str) {
		if(str == null || str.length() == 0)
			return null;
		String[] nodes = str.split(",");
		return DeserializeCore(nodes);
	}
	
	private static int index = -1;
	
	public static TreeNode DeserializeCore(String[] nodes) {
		index++;
		if(index >= nodes.length)
			return null;
		if(nodes[index].equals("#"))
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(nodes[index]));
		node.left = DeserializeCore(nodes);
		node.right = DeserializeCore(nodes);
		return node;
	}
}

