package pattern.trees.dfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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

	/**
	 * Problem Statement # Given a binary tree and a number ‘S’, find all paths from
	 * root-to-leaf such that the sum of all the node values of each path equals
	 * ‘S’.
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
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

//	public static int sumAllPathsRec(BinaryTreeNode root, String current, int sum) {
//
//		if (root == null)
//			return 0;
//
//		current = current + Integer.toString(root.data);
//
//		if (root.left == null && root.right == null) {
//			sum = sum + Integer.parseInt(current);
//			current = current.substring(0, current.length() - 1);
//			return sum;
//		}
//
//		return sumAllPathsRec(root.left, current, sum) + sumAllPathsRec(root.right, current, sum);
//
//	}

	/**
	 * above javadoc sumAllPaths
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public static int sumAllPathsRec(BinaryTreeNode root, int sum) {

		if (root == null)
			return 0;

		sum = 10 * sum + root.data;

		if (root.left == null && root.right == null) {
			return sum;
		}

		return sumAllPathsRec(root.left, sum) + sumAllPathsRec(root.right, sum);

	}

	/**
	 * Problem Statement # Given a binary tree and a number sequence, find if the
	 * sequence is present as a root-to-leaf path in the given tree.
	 * <p>
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * <p>
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * in the worst case. This space will be used to store the recursion stack. The
	 * worst case will happen when the given tree is a linked list (i.e., every node
	 * has only one child).
	 * 
	 * @param root
	 * @param sequence
	 * @param index
	 * @return
	 */
	public static boolean findSequenceRec(BinaryTreeNode root, int[] sequence, int index) {
		if (root == null)
			return false;

		if (index >= sequence.length || root.data != sequence[index])
			return false;

		if (root.left == null && root.right == null && sequence.length - 1 == index)
			return true;

		return findSequenceRec(root.left, sequence, index++) || findSequenceRec(root.right, sequence, index++);

	}

	public static boolean findSequence(BinaryTreeNode root, int[] sequence) {
		if (root == null)
			return sequence.length == 0;
		return findSequenceRec(root, sequence, 0);
	}

	static int countPaths = 0;

	public static int countAllPathsSumm(BinaryTreeNode root, int sum) {
		if (root == null)
			return 0;

		List<Integer> currentPath = new LinkedList<Integer>();
		countAllPathsSummRec(root, currentPath, sum);
		return countPaths;

	}

	private static void countAllPathsSummRec(BinaryTreeNode root, List<Integer> currentPath, int sum) {
		if (root == null)
			return;

		currentPath.add(root.data);
		int currentSum = 0;
		for (int i = currentPath.size() - 1; i >= 0; i--) {
			currentSum = currentSum + currentPath.get(i);
			if (currentSum == sum)
				countPaths++;
		}

		countAllPathsSummRec(root.left, currentPath, sum);
		countAllPathsSummRec(root.right, currentPath, sum);
		currentPath.remove(currentPath.size() - 1);
	}

	/**
	 * 
	 * Problem Statement # Given a binary tree and a number ‘S’, find all paths in
	 * the tree such that the sum of all the node values of each path equals ‘S’.
	 * Please note that the paths can start or end at any node but all paths must
	 * follow direction from parent to child (top to bottom).
	 * 
	 * <p>
	 * Time complexity # The time complexity of the above algorithm is O(N^2) in
	 * the worst case, where ‘N’ is the total number of nodes in the tree. This is
	 * due to the fact that we traverse each node once, but for every node, we
	 * iterate the current path. The current path, in the worst case, can be O(N)
	 * (in the case of a skewed tree). But, if the tree is balanced, then the
	 * current path will be equal to the height of the tree, i.e., O(logN). So the
	 * best case of our algorithm will be O(NlogN).
	 * <p>
	 * Space complexity # The space complexity of the above algorithm will be O(N).
	 * This space will be used to store the recursion stack. The worst case will
	 * happen when the given tree is a linked list (i.e., every node has only one
	 * child). We also need O(N) space for storing the currentPath in the worst
	 * case.
	 * 
	 * Overall space complexity of our algorithm is O(N)O(N)
	 * 
	 * @param root
	 * @param currentPath
	 * @param sum
	 * @return
	 */
	public static int countAllPathsSummRec2(BinaryTreeNode root, List<Integer> currentPath, int sum) {
		if (root == null)
			return 0;

		currentPath.add(root.data);
		int currentSum = 0, pathCount = 0;
//		for (int i = currentPath.size() - 1; i >= 0; i--) {
//			currentSum = currentSum + currentPath.get(i);
//			if (currentSum == sum)
//				countPaths++;
//		}

		ListIterator<Integer> itr = currentPath.listIterator(currentPath.size());

		while (itr.hasPrevious()) {
			currentSum = currentSum + itr.previous();
			if (currentSum == sum)
				pathCount++;
		}

		pathCount += countAllPathsSummRec2(root.left, currentPath, sum);
		pathCount = pathCount + countAllPathsSummRec2(root.right, currentPath, sum);
		currentPath.remove(currentPath.size() - 1);

		return pathCount;
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
	
	public static int findMaxPathSumRec(BinaryTreeNode root) {
		treeDiameter = Integer.MIN_VALUE;
		findMaxPathSumRec2(root);
		return treeDiameter;
	}

	
	public static int findMaxPathSumRec2(BinaryTreeNode root) {
		if (root == null)
			return 0;
		
		int maxLeftSum = findMaxPathSumRec2(root.left);
		int maxRightSum = findMaxPathSumRec2(root.right);
		
		maxLeftSum = Math.max(maxLeftSum, 0);
		maxRightSum = Math.max(maxRightSum, 0);
		
		int localSum = maxLeftSum + maxRightSum + root.data;
		treeDiameter = Math.max(localSum, treeDiameter);
		
		return Math.max(maxLeftSum, maxRightSum) + root.data;
	}

}
