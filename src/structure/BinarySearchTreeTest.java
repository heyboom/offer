package structure;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BianrySearchTree bst = new BianrySearchTree();
		bst.add(3);
		bst.add(1);
		bst.add(5);
		bst.add(2);
		bst.add(4);
		bst.print();
		System.out.println(bst.contains(10));
		bst.remove(2);
		bst.print();
		bst.add(2);
		bst.print();
		bst.remove(1);
		bst.print();
	}

}
