package tree;// Java program to find height of tree

// A binary tree node

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;
	int lcount = 0;
	int rcount = 0;

	/* Compute the "maxDepth" of a tree -- the number of
	nodes along the longest path from the root node
	down to the farthest leaf node.*/
	int maxDepth(Node node)
	{
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			System.out.println("lDepth : " + lcount++);
			int lDepth = maxDepth(node.left);
			System.out.println("rcount : " + rcount++);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	int diameter(Node root) {
		if(root == null) return 0;

		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);

		int ld = diameter(root.left);
		int rd = diameter(root.right);

		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}

	static ArrayList<Integer> list  = new ArrayList<>();
	ArrayList<Integer> inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			list.add(root.data);
			inOrder(root.right);
		}
		return list;
	}

	//preorder 
	public static void preorder(Node root) {
		Queue<Node> queue = new LinkedList<>();

		while(!queue.isEmpty() || root != null) {
			if(root!= null) {
				queue.offer(root);
				root = root.left;
			}
			else {
				Node node = queue.poll();
				System.out.println(node.data);
				root = node.right;
			}
		}
	}

	void printDiagonal(Node root) {
		if(root == null) return ;
		Map<Integer, ArrayList<Node>> map = new HashMap<>();
		pd(root, 0, map);
		for(int key : map.keySet()) {
			for(int i=0; i<map.get(key).size(); i++) {
				System.out.println(key + " : " + map.get(key).get(i).data);
			}
		}
	}

	//create binary tree from bracket string 
	//4(2(3(1)))(6(5))

	public Node createBinTree(String str, int si, int ei) {
		if(si > ei) return null;

		Node node = new Node(str.charAt(si));

		int index = 1;

		if(si+1 <= ei && str.charAt(si+1) == '(') {
			index = findIndex(str, si, ei);
		}

		if(index != -1) {
			node.left = createBinTree(str, si+2, index-1);
			node.right = createBinTree(str, index+2, ei-1);
		}

		return root;
	}

	public int findIndex(String str, int si, int ei) {
		Stack<Character> stack = new Stack<>();
		for(int i=si; i<=ei; i++) {
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
			} else if(str.charAt(i)==')') {
				if(stack.peek()=='(') {
					stack.pop();
					if(stack.isEmpty()) {
						return i;
					}
				}
			}
		}
		return -1;
	}


	void pd(Node root, int hd, Map<Integer, ArrayList<Node>> map) 
	{
		if(root == null) return ;

		ArrayList<Node> list = map.get(hd);
		if(list== null) {
			list = new ArrayList<>();
		}
		list.add(root);

		map.put(hd, list);

		pd(root.left, hd+1, map);
		pd(root.right, hd, map);
	}


	/* Driver program to test above functions */
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		tree.printDiagonal(tree.root);
		// System.out.println("Diameter of tree is "
						// + tree.inOrder(tree.root));
	}
}

// This code has been contributed by Amit Srivastav
