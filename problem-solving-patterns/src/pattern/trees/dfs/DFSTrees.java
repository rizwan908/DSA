package pattern.trees.dfs;

import java.util.ArrayList;
import java.util.List;

import dsa.trees.BinaryTreeNode;

public class DFSTrees {
	
	
	private static int treeDiameter = 0;

	/**
	 * Problem Statement # Given a binary tree and a number ‘S’, find if the tree
	 * has a path from root-to-leaf such that the sum of all the node values of that
	 * path equals ‘S’
	 * 
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * in the worst case. This space will be used to store the recursion stack. The
	 * worst case will happen when the given tree is a linked list (i.e., every node
	 * has only one child).
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public static boolean hasPath(BinaryTreeNode root, int sum) {
		if (root == null)
			return false;

		/*
		 * if curr node's data == sum and its a leaf node the its our path
		 */

		if (root.data == sum && root.left == null && root.right == null)
			return true;

		return hasPath(root.left, sum - root.data) || hasPath(root.right, sum - root.data);
	}

	public static void findAllPathsRec(BinaryTreeNode currentNode, int sum, List<List<Integer>> allPaths,
			List<Integer> currentPath) {
		if (currentNode == null)
			return;

		currentPath.add(currentNode.data);

		/*
		 * if curr node's data == sum and its a leaf node the its our path
		 */

		if (currentNode.data == sum && currentNode.left == null && currentNode.right == null) {
			System.out.println(currentPath);
			allPaths.add(new ArrayList<Integer>(currentPath));
		} else {
			findAllPathsRec(currentNode.left, sum - currentNode.data, allPaths, currentPath);
			findAllPathsRec(currentNode.right, sum - currentNode.data, allPaths, currentPath);
		}

		currentPath.remove(currentPath.size() - 1);
	}

	public static List<List<Integer>> findAllPaths(BinaryTreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<Integer>();

		if (root == null)
			return allPaths;

		findAllPathsRec(root, sum, allPaths, currentPath);
		return allPaths;

	}

	/**
	 * 
	 * Problem Statement # Given a binary tree where each node can only have a digit
	 * (0-9) value, each root-to-leaf path will represent a number. Find the total
	 * sum of all the numbers represented by all paths.
	 * 
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * in the worst case. This space will be used to store the recursion stack. The
	 * worst case will happen when the given tree is a linked list (i.e., every node
	 * has only one child).
	 * 
	 * @param root
	 * @return
	 */
	public static int sumAllPaths(BinaryTreeNode root) {

		if (root == null)
			return 0;

		String current = "";
		int sum = 0;
//		sum = sumAllPathsRec(root, current, sum);
		sum = sumAllPathsRec(root, sum);

		return sum;
	}

	public static int sumAllPathsRec(BinaryTreeNode root, String current, int sum) {

		if (root == null)
			return 0;

		current = current + Integer.toString(root.data);

		if (root.left == null && root.right == null) {
			sum = sum + Integer.parseInt(current);
			current = current.substring(0, current.length() - 1);
			return sum;
		}

		return sumAllPathsRec(root.left, current, sum) + sumAllPathsRec(root.right, current, sum);

	}

	public static int sumAllPathsRec(BinaryTreeNode root, int sum) {

		if (root == null)
			return 0;

		sum = 10 * sum + root.data;

		if (root.left == null && root.right == null) {
			return sum;
		}

		return sumAllPathsRec(root.left, sum) + sumAllPathsRec(root.right, sum);

	}
	
	public static int treeDiameter(BinaryTreeNode root) {
		treeDiameter = 0;
		findTreeDiameter(root);
		return treeDiameter;
	}
	
	public static int findTreeDiameter(BinaryTreeNode root) {
		if (root == null)
			return 0;
		
		int leftHeight = findTreeDiameter(root.left);
		int righHeight = findTreeDiameter(root.right);
		
		int currDia = leftHeight + righHeight + 1;
		
		treeDiameter = Math.max(treeDiameter, currDia);
		
		return Math.max(leftHeight, righHeight) + 1;
	}
	
	
}
