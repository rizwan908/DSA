package pattern.trees.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dsa.trees.BinaryTreeNode;

public class BFSLevelOrder {

	/**
	 * Problem Statement # Given a binary tree, populate an array to represent its
	 * level-by-level traversal. You should populate the values of all nodes of each
	 * level from left to right in separate sub-arrays.
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> getLevelOrder(BinaryTreeNode root) {
		List<List<Integer>> lst = new ArrayList<>();
		if (root == null)
			return lst;

		Queue<BinaryTreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			List<Integer> arr = new ArrayList<Integer>(levelSize);

			for (int i = 0; i < levelSize; i++) {
				BinaryTreeNode curr = queue.poll();

				arr.add(curr.data);

				if (curr.left != null) {
					queue.offer(curr.left);
				}

				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			lst.add(arr);
		}
		return lst;
	}
}
