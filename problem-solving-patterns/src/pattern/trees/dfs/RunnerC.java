package pattern.trees.dfs;

import java.util.List;

import dsa.trees.BinaryTreeNode;

public class RunnerC {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(0);
		root.right = new BinaryTreeNode(1);
		root.left.left = new BinaryTreeNode(1);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(5);

		int sum = 23;

//		List<List<Integer>> res = DFSTrees.findAllPaths(root, sum);
		
//		int res  = DFSTrees.sumAllPaths(root);
		int res = DFSTrees.treeDiameter(root);
		System.out.println("Tree paths with sum  " + res);
	}
}
