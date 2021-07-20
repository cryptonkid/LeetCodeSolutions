package com.leetcode.solutions.trees;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.solutions.bst.TreeNode;

public class lonelyNodes {

	public List<Integer> lonelyNodes(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		if(root!= null) {
			helper(root,list);
		}
		return list;
	}
	public static void helper(TreeNode node,List<Integer> list) {
		if(node != null) {
			if(node.left == null && node.right != null) {
				list.add(node.right.val);
				helper(node.right,list);
			}
			else if (node.right == null && node.left != null) {
				list.add(node.left.val);
				helper(node.left,list);
			}
			else{
				helper(node.left,list);
				helper(node.right,list);
			}
		
		}
	}
}
