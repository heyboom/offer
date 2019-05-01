package offer;

public class 序列化二叉树 {
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		String str = Serialize(t1);
		String str2 = Serialize(Deserialize(str));
		System.out.println(str);
		System.out.println(str2);
	}
	
	static String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null) {
			return sb.toString();
		}
		sb.append(SerializeCore(root)).deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	static String SerializeCore(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(SerializeCore(root.left));
		sb.append(SerializeCore(root.right));
		return sb.toString();
	}
	
	private static int index = -1;
	static TreeNode Deserialize(String str) {
		if(str == null || str.length() == 0) {
			return null;
		}
		
		return DeserializeCore(str.split(","));
	}
	
	static TreeNode DeserializeCore(String[] str) {
		index++;
		TreeNode node = null;
		if(!str[index].equals("#")) {
			node = new TreeNode(Integer.valueOf(str[index]));
			node.left = DeserializeCore(str);
			node.right = DeserializeCore(str);
		}
		return node;
	}
	
}
