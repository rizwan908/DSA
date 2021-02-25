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

	/**
	 * Problem Statement # Given a binary tree, populate an array to represent its
	 * level-by-level traversal in reverse order, i.e., the lowest level comes
	 * first. You should populate the values of all nodes in each level from left to
	 * right in separate sub-arrays.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * as we need to return a list containing the level order traversal. We will
	 * also need O(N)space for the queue. Since we can have a maximum of N/2 nodes
	 * at any level (this could happen only at the lowest level), therefore we will
	 * need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> reverseLevelOrder(BinaryTreeNode root) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;

		Queue<BinaryTreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			List<Integer> currentNode = new ArrayList<Integer>();

			for (int i = 0; i < queueSize; i++) {
				BinaryTreeNode node = queue.poll();

				currentNode.add(node.data);

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(0, currentNode);
		}
		return result;
	}

	/**
	 * 
	 * Problem Statement # Given a binary tree, populate an array to represent its
	 * zigzag level order traversal. You should populate the values of all nodes of
	 * the first level from left to right, then right to left for the next level and
	 * keep alternating in the same manner for the following levels.
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> zigzagTraversal(BinaryTreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;

		Queue<BinaryTreeNode> queue = new LinkedList<>();

		boolean left2right = true;

		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> currentLevel = new LinkedList<>();

			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				BinaryTreeNode node = queue.poll();

				if (left2right)
					currentLevel.add(node.data);
				else
					currentLevel.add(0, node.data);

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			left2right = !left2right;
			result.add(currentLevel);

		}
		return result;
	}

	/**
	 * Problem Statement # Given a binary tree, populate an array to represent the
	 * averages of all of its levels.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * which is required for the queue. Since we can have a maximum of N/2 nodes at
	 * any level (this could happen only at the lowest level), therefore we will
	 * need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @return
	 */
	public static List<Double> getAvergesOfLevel(BinaryTreeNode root) {
		List<Double> lst = new ArrayList<>();
		if (root == null)
			return lst;

		Queue<BinaryTreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();

//			List<Integer> arr = new ArrayList<Integer>();
			double average = 0;

			for (int i = 0; i < levelSize; i++) {
				BinaryTreeNode curr = queue.poll();

				average = average + curr.data;

				if (curr.left != null) {
					queue.offer(curr.left);
				}

				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			lst.add(average / levelSize);
		}
		return lst;
	}

	/**
	 * 
	 * Problem Statement # Find the minimum depth of a binary tree. The minimum
	 * depth is the number of nodes along the shortest path from the root node to
	 * the nearest leaf node.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * which is required for the queue. Since we can have a maximum of N/2 nodes at
	 * any level (this could happen only at the lowest level), therefore we will
	 * need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @return
	 */
	public static int findMinimumDepth(BinaryTreeNode root) {

		int minimumDepth = 0;
		if (root == null)
			return minimumDepth;

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			minimumDepth++;
			for (int i = 0; i < qSize; i++) {
				BinaryTreeNode curr = queue.poll();

				if (curr.left == null && curr.right == null)
					return minimumDepth;

				if (curr.left != null)
					queue.offer(curr.left);

				if (curr.right != null)
					queue.offer(curr.right);
			}

		}
		return minimumDepth;
	}

	/**
	 * Problem Statement # Given a binary tree and a node, find the level order
	 * successor of the given node in the tree. The level order successor is the
	 * node that appears right after the given node in the level order traversal.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * which is required for the queue. Since we can have a maximum of N/2 nodes at
	 * any level (this could happen only at the lowest level), therefore we will
	 * need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @param node
	 * @return
	 */
	public static BinaryTreeNode findLevelOrderSuccessor(BinaryTreeNode root, BinaryTreeNode node) {

		if (root == null)
			return null;

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				BinaryTreeNode curr = queue.poll();
				if (curr.left != null)
					queue.offer(curr.left);

				if (curr.right != null)
					queue.offer(curr.right);

				if (curr.data == node.data)
					break;

			}

		}
		return queue.peek();
	}

	/**
	 * Problem Statement # Given a binary tree, connect each node with its level
	 * order successor. The last node of each level should point to a null node.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N),
	 * which is required for the queue. Since we can have a maximum of N/2 nodes at
	 * any level (this could happen only at the lowest level), therefore we will
	 * need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode connectLevelOrderSiblings(BinaryTreeNode root) {

		if (root == null)
			return root;

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			BinaryTreeNode prevNode = null;
			for (int i = 0; i < qSize; i++) {
				BinaryTreeNode currentNode = queue.poll();
				if (prevNode != null)
					prevNode.next = currentNode;
				prevNode = currentNode;

				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
		}
		return root;
	}

	/**
	 * Connect All Level Order Siblings (medium) # Given a binary tree, connect each
	 * node with its level order successor. The last node of each level should point
	 * to the first node of the next level.
	 * 
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * which is required for the queue. Since we can have a maximum of N/2 nodes at
	 * any level (this could happen only at the lowest level), therefore we will
	 * need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode connectAllLevelOrderSiblings(BinaryTreeNode root) {

		if (root == null)
			return root;

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

		queue.offer(root);
		BinaryTreeNode prevNode = null;
//		BinaryTreeNode currentNode = null;

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				BinaryTreeNode currentNode = queue.poll();
				if (prevNode != null)
					prevNode.next = currentNode;
				prevNode = currentNode;

				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
		}
		return root;
	}

	/**
	 * Right View of a Binary Tree (easy) # Given a binary tree, return an array
	 * containing nodes in its right view. The right view of a binary tree is the
	 * set of nodes visible when the tree is seen from the right side.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * as we need to return a list containing the level order traversal. We will
	 * also need O(N)O(N) space for the queue. Since we can have a maximum of N/2
	 * nodes at any level (this could happen only at the lowest level), therefore we
	 * will need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @return
	 */
	public static List<BinaryTreeNode> rightView(BinaryTreeNode root) {
		List<BinaryTreeNode> result = new ArrayList<BinaryTreeNode>();
		if (root == null)
			return result;

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				BinaryTreeNode currentNode = queue.poll();

				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);

				if (qSize == i + 1)
					result.add(currentNode);
			}
		}
		return result;
	}

	/**
	 * Left View of a Binary Tree (easy) # Given a binary tree, return an array
	 * containing nodes in its left view. The left view of a binary tree is the set
	 * of nodes visible when the tree is seen from the left side.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N), where
	 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
	 * traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * as we need to return a list containing the level order traversal. We will
	 * also need O(N)O(N) space for the queue. Since we can have a maximum of N/2
	 * nodes at any level (this could happen only at the lowest level), therefore we
	 * will need O(N) space to store them in the queue.
	 * 
	 * @param root
	 * @return
	 */
	public static List<BinaryTreeNode> leftView(BinaryTreeNode root) {
		List<BinaryTreeNode> result = new ArrayList<BinaryTreeNode>();
		if (root == null)
			return result;

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				BinaryTreeNode currentNode = queue.poll();

				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);

				if (i == 0)
					result.add(currentNode);
			}
		}
		return result;
	}

}
