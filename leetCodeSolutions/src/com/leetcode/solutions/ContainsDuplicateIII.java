package com.leetcode.solutions;

import java.util.TreeSet;

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> bst = new TreeSet<>();
        for(int i=0;i< nums.length;i++){
            
            //celing it to find max value in the tree.
            if((bst.ceiling(nums[i]) != null) && (nums[i] >= bst.ceiling(nums[i])-t)){
                return true;
            }
            
            //floor is used to find the min value in the tree.
            if((bst.floor(nums[i])!= null) &&  (nums[i] <= bst.floor(nums[i])+t)){
                return true;
            }
            bst.add(nums[i]); 
            
            if(i>=k){
                bst.remove(nums[i-k]);
            }
                       
        }
        return false;
    }
	//Intial code and case for which it failed 
	public boolean containsNearbyAlmostDuplicateBug(int[] nums, int k, int t) {
        TreeSet<Integer> bst = new TreeSet<>();
        for(int i=0;i< nums.length;i++){
            
            //celing it to find max value in the tree.
            if((bst.ceiling(nums[i]) != null) && (t >= bst.ceiling(nums[i])-nums[i])){// condition should be reverse i.e. t<=
                return true;
            }
            
            //floor is used to find the min value in the tree.
            if((bst.floor(nums[i])!= null) &&  (t <= bst.floor(nums[i])+nums[i])){ // condition should be reverse. i.e. t>=
                return true;
            }
            
            
            if(i>=k){
                bst.remove(nums[i-k]);
            }
            bst.add(nums[i]); // fails  for (new int[]{1,2},0,1} as we try to delete the value first.         
        }
        return false;
    }

}
