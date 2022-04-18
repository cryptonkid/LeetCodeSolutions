package com.day31.BinarySearchTree;

import java.util.*;

public class LeetCode_Increasing_Order_Search_Tree_897 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public TreeNode increasingBST(TreeNode root) {

            List<Integer> values = new ArrayList<>();

            inorder(root,values);

            TreeNode ans = new TreeNode(values.get(0));
            TreeNode cur = ans;

            for(int i=1;i< values.size();i++){
                cur.right =   new TreeNode(values.get(i));
                cur = cur.right;
            }
            return ans;
        }
        public void inorder(TreeNode node,List<Integer> values){
            if(node == null)
                return;
            inorder(node.left,values);
            values.add(node.val);
            inorder(node.right,values);
        }
    }
}
