public class Tree {

	public static void main(String[] args) {

		Node root = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);

		// 1, 2, 4, 5, 3

		root.left = second;
		root.right = third;
		second.left = fourth;
		second.right = fifth;

		preOrder(root);

	}

	public static void preOrder(Node root) {

		if(root == null) {
			return; // base case
		}
		
		System.out.println(root.data);

		preOrder(root.left);
		preOrder(root.right);
	}

}

class Node {

	public Node left;
	public Node right;
	public int data;

	public Node(int data) {
		this.data = data;
	}

}
