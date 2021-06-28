package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 1305: All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * 
 * @author viveksingh
 * 
 *         Sample Data: Input: root1 = [2,1,4], root2 = [1,0,3] Output:
 *         [0,1,1,2,3,4] Example 2:
 * 
 *         Input: root1 = [0,-10,10], root2 = [5,1,7,0,2] Output:
 *         [-10,0,0,1,2,5,7,10] Example 3:
 * 
 *         Input: root1 = [], root2 = [5,1,7,0,2] Output: [0,1,2,5,7] Example 4:
 * 
 *         Input: root1 = [0,-10,10], root2 = [] Output: [-10,0,10]
 *
 */

public class MergeBinarySearchTree {

	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}
		List<Integer> output = new ArrayList<Integer>();

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		inorder(root1, queue);
		inorder(root2, queue);

		while (queue != null && !queue.isEmpty()) {
			output.add(queue.poll());
		}

		return output;
	}

	public static void inorder(TreeNode root, PriorityQueue<Integer> q) {
		if (root != null)
			return;

		inorder(root.left, q);
		q.add(root.val);
		inorder(root.right, q);
	}

	public static void main(String[] args) {
		
		TreeNode tree1 = new TreeNode(2);
		tree1.left = new TreeNode(1);
		tree1.right = new TreeNode(4);

		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(0);
		tree2.right = new TreeNode(3);
		
		getAllElements(tree1,tree2);
		
	}

	// Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
