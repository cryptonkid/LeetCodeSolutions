package com.leetcode.solutions.bst;

public class FindtheMin {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int start = 0,end = nums.length-1;

        // //Already sorted : pivot is zero
        // if(nums[start] < nums[end]){
        //     return nums[0];
        // }

        //BinarySearch : modified.

        while(start < end){
            int mid = start + (end-start)/2; //best logic to find the mid prevent integer overflow.

            if(nums[mid] < nums[end]){
                //move to left side of the array
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return nums[start];
    }
}
