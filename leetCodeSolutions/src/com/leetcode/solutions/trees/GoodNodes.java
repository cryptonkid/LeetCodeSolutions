package com.leetcode.solutions.trees;

import com.leetcode.solutions.bst.TreeNode;

/**
 * 1448. leet code 
 * @author viveksingh
 *
 */
public class GoodNodes {
	
	public static void helper(TreeNode node,int count ,int max) {
		if(node.val >= max) {
			count++;
		}
		if(node.left != null)
			helper(node.left,count,max);
		if(node.right != null)
			helper(node.right,count,max);
	}

	public int goodNodes(TreeNode root) {
		int count = 0 ;
		if(root !=  null && root.right == null && root.left == null) {//conatins only one node.
			count++;
		}else if(root != null && (root.right != null || root.left != null)){
			helper(root,count+1,root.val);
		}
		return count;
	}
}
/**
 * Older Solution
  public int goodNodes(TreeNode root) {
      return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int ma) {
        if (root == null) return 0;
        int res = root.val >= ma ? 1 : 0;
        res += goodNodes(root.left, Math.max(ma, root.val));
        res += goodNodes(root.right, Math.max(ma, root.val));
        return res;
    }
 */
