package pattern.trees.dfs;

import java.util.ArrayList;
import java.util.List;

import dsa.trees.BinaryTreeNode;

public class RunnerC {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(12);
		root.left = new BinaryTreeNode(7);
		root.right = new BinaryTreeNode(1);
		System.out.println(DFSTrees.findMaxPathSumRec(root));
		root.left.left = new BinaryTreeNode(4);
		root.right.left = new BinaryTreeNode(10);
		root.right.right = new BinaryTreeNode(5);
		System.out.println(DFSTrees.findMaxPathSumRec(root));

		int sum = 11;

//		List<List<Integer>> res = DFSTrees.findAllPaths(root, sum);

//		int res  = DFSTrees.sumAllPaths(root);
		DFSTrees.findTreeDiameter(root);
		int res = DFSTrees.countAllPathsSummRec2(root, new ArrayList<Integer>(), sum);
		System.out.println("Tree paths with sum  " + res);
	}
}
