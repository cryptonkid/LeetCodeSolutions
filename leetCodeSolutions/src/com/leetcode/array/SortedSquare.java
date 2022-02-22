package com.leetcode.array;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
public class SortedSquare {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for(int i = nums.length-1; i >= 0 ; i--){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                answer[i] = nums[left]*nums[left];
                left++;
            }else{
                answer[i] = nums[right] * nums[right];
                right--;
            }
        }
        return answer;
    }
}
