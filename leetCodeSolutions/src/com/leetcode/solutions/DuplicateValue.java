package com.leetcode.solutions;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * @author Vivek.Singh
 *
 */
public class DuplicateValue {
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
            	return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
}
