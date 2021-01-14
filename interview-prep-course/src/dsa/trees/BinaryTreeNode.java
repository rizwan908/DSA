package dsa.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeNode {

	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * create min heap from array
	 * 
	 * @param arr
	 * @return `TODO
	 */
	public BinaryTreeNode createMinHeap(int[] arr) {
		BinaryTreeNode root = new BinaryTreeNode(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			root = insert(root, arr[i]);
		}
		return root;
	}

	/**
	 * method to insert a new node in a binary tree Steps:
	 * 
	 * @param root
	 * @param data
	 * @return root of this binary tree
	 */
	private BinaryTreeNode insert(BinaryTreeNode root, int data) {
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		if (root == null)
			return newNode;

		BinaryTreeNode parent = null;
		BinaryTreeNode temp = root;

		while (temp != null) {
			parent = temp;
			if (data <= temp.data) {
				temp = temp.left;
			} else if (data > temp.data) {
				temp = temp.right;
			}
		}

		if (data <= parent.data)
			parent.left = newNode;
		else
			parent.right = newNode;

		return root;
	}

	public BinaryTreeNode deleteInBST(BinaryTreeNode root, BinaryTreeNode node) {
		if (node.left == null && node.right == null) {
			node = null;
			return root;
		}

		if (node.left != null) {

		}

		inOrderSuccessor(root, node.data);
		return null;
	}

	/**
	 * @param root
	 * @param data
	 * @return
	 */
	private BinaryTreeNode inOrderSuccessor(BinaryTreeNode root, int data) {
		if (root == null)
			return null;

		BinaryTreeNode node = root;
		BinaryTreeNode successor = null;

		while (node.data != data) {
			if (data < node.data) {
				/*
				 * before moving to left subtree asign the successor to the head node of this
				 * left sub tree
				 */
				successor = node;
				node = node.left;
			} else if (data > node.data) {
				node = node.right;
			}
		}

		/*
		 * now that we have node which successor is needed. if right child is not null
		 * then find min in the sub tree other wise we have the successor already
		 */

		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				successor = node;
				node = node.left;
			}
		}
		return successor;
	}

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

	public List<Integer> getInorder(BinaryTreeNode root, List<Integer> output) {
		if (root == null)
			return null;

		getInorder(root.left, output);
		output.add(data);
		getInorder(root.right, output);

		return output;
	}

	public List<Integer> getPreOrder(BinaryTreeNode root, List<Integer> output) {
		if (root == null)
			return null;

		output.add(data);
		getPreOrder(root.left, output);
		getInorder(root.right, output);

		return output;
	}

	public List<Integer> getPostOrder(BinaryTreeNode root, List<Integer> output) {
		if (root == null)
			return null;

		getPreOrder(root.left, output);
		getInorder(root.right, output);
		output.add(data);

		return output;
	}

}
