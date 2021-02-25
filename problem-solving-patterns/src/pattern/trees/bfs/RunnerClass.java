package pattern.trees.bfs;

import dsa.trees.BinaryTreeNode;

public class RunnerClass {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.right.right = new BinaryTreeNode(8);
		int sum = 23;

//		List<List<Integer>> res = DFSTrees.findAllPaths(root, sum);

//		int res  = DFSTrees.sumAllPaths(root);
		BFSLevelOrder.leftView(root);
//		System.out.println("Tree paths with sum  " + res);
	}
}
