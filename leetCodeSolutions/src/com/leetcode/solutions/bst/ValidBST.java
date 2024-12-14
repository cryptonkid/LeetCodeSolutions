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
    
    //Solution II
    public boolean isValidBST2(TreeNode root) {
    	return validBSTHelper(root, null, null);        
    }
    
    private boolean validBSTHelper(TreeNode node, TreeNode leftTree, TreeNode rightTree ){
        if(node== null) return true;
        
        if( leftTree != null && node.val <= leftTree.val){
            return false;
        }
        if( rightTree != null && node.val >= rightTree.val){
            return false;
        }
        
        boolean leftIsValid = validBSTHelper(node.left, leftTree, node);
        boolean rightIsValid = validBSTHelper(node.right, node, rightTree );
        
        return leftIsValid && rightIsValid;
    }
    
    /*
     * Solution-III
     * Create a list in Inorder and then check if the elements are sorted.
     */
    
    
}
