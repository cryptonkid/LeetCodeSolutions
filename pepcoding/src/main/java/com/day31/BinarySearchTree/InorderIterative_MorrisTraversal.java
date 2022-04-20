package com.day31.BinarySearchTree;

import java.util.ArrayList;

public class InorderIterative_MorrisTraversal {
    Node getRMN(Node leftNode, Node curr){
        while(leftNode.right != null && leftNode.right != curr){//check if the nodes is not having infinite loop / worng loop

            leftNode = leftNode.right;
        }
        return leftNode;
    }
    ArrayList<Integer> inOrder(Node root){
        Node curr = root;
        ArrayList<Integer> ans = new ArrayList<>();


        while(curr != null){
            Node leftNode = curr.left;
            if(leftNode == null){
                //print or Add the current node : As node is already processed.
                ans.add(curr.data);
                curr = curr.right;
            }
            else{
                Node rightMostNode = getRMN(leftNode,curr);
                if(rightMostNode.right == null){ //create thread to current & move current to left child
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{
                    rightMostNode.right = null;
                    ans.add(curr.data); //Inorder process.: before moving curr to right node.
                    curr =  curr.right;
                }
            }
        }
        return ans;
    }
}
