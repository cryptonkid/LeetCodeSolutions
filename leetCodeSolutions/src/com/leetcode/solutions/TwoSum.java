package com.leetcode.solutions;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author Vivek.Singh
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int nums[] = { 2, 7, 11, 15 };
		int output[] = new TwoSum().new Solution().twoSum(nums, 9);
		System.out.println(Arrays.toString(output));

	}

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	private class Solution {
		/**
		 * Using HashMap
		 * 
		 * @param nums
		 * @param target
		 * @return
		 */
		public int[] twoSum(int[] nums, int target) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int len = nums.length;
			int output[] = new int[2];
			for (int i = 0; i < len; i++) {
				if (map.containsKey(target - nums[i])) {
					output[0] = map.get(target - nums[i]);
					output[1] = i;
					return output;
				} else {
					map.put(nums[i], i);
				}
			}
			return output;
		}

	}

}
