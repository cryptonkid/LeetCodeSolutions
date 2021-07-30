package com.leetcode.solutions.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.leetcode.solutions.bst.TreeNode;

/**
 * Inoder Traversal  ( left root right)
 * 				sol 1 - 	with recursion -
 *  			sol 2 -	    without recusrsion - using stack
 * 				sol 3 - 	without recursion & stack - using threaded tree
 * 
 * 	@author vivek singh
 *
 */
public class Inorder {
	List<Integer> list1 = new ArrayList<>();
	public void inorderTraversal(TreeNode root) {
		list1 = withRecursion(root);
		//System.out.print(Arrays.toString(list1.toArray()));
		list1.forEach(System.out::print);
		List<Integer> list2 = new ArrayList<>();
		list2 = withoutRecursion(root);
	}
	/** 
	 * Recursive solution
	 */
	
	List<Integer> list = new ArrayList<>();
	private List<Integer> withRecursion(TreeNode root){
		if(root == null)
			return null;
		if(root.left != null)
			inorderTraversal(root.left);
		list.add(root.val);
		if(root.right != null)
			inorderTraversal(root.right);
		return list;
	}
	/**
	 * Pseudo Code:

		Create a Stack.
		Push the root into the stack and set the root = root.left continue till it hits the NULL.
			If root is null and Stack is empty Then
				return, we are done.
			Else
				Pop the top Node from the Stack and set it as, root = popped_Node.
				print the root and go right, root = root.right.
				Go to step 2.
			End If
	 *
	 */
	
	private List<Integer> withoutRecursion(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> output = new ArrayList<>();
		if(root == null) {
			return output;
		}
		stack.push(root);
		TreeNode node = root;
		while(true) {
			//Traverse the complete left tree
			while(node != null) {
				stack.push(node.left);
				node = node.left;
			}
			if(stack.isEmpty())
				return output;
			
			node = stack.pop();
			output.add(node.val);
			if(node.right != null)
			stack.push(node.right);
		}
	}
	
}
