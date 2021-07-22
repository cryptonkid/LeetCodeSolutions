package com.leetcode.solutions.trees;

import com.leetcode.solutions.bst.TreeNode;

/**
 * leetcode 938
 * @author viveksingh
 *
 */
public class rangeBST {
	public int rangeSumBST(TreeNode root, int low, int high) {
	       if(root== null)
	           return 0;
	        int sum = 0;
	        sum =  sum + helper(root,low,high,sum);
	        return sum;
	    }
	    private int helper(TreeNode node,int low,int high, int sum)
	    {
	        if(low <= node.val && node.val <= high){
	            sum = sum + node.val;
	        }
	        if(node.left != null )
	            sum = helper(node.left,low,high,sum);
	        if(node.right != null)
	            sum = helper(node.right,low,high,sum);
	        
	        return sum;
	    }
}
