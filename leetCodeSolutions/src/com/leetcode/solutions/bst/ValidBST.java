package com.leetcode.solutions.bst;

/**
 *  98: Is Valid BST
 * @author viveksingh
 *
 */

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
        return validBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);        
    }
    
    private boolean validBSTHelper(TreeNode root, long min, long max){
        if(root== null) return true;
        
        if(root.val <= min || root.val >= max){
            return false;
        }
        
        boolean leftIsValid = validBSTHelper(root.left, min, root.val);
        boolean rightIsValid = validBSTHelper(root.right, root.val, max);
        
        return leftIsValid && rightIsValid;
    }
    
}
