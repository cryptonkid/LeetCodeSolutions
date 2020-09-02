package com.leetcode.solutions;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 * 
 * Given a non-empty array of integers, every element appears <i><b>twice</b></i> except for one. 
 * Find that single one.
 * @author Vivek.Singh
 *
 */
public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber sn = new SingleNumber();
		System.out.println(sn.singleNumber(new int[]{1,2,1,2,4,3,3,5,6,7,8,5,6,7,8}));
		System.out.println(sn.singleNumberXOR(new int[]{1,2,1,2,4,3,3,5,6,7,8,5,6,7,8}));
	}
	// With Extra memory
	public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(nums[i])) {
        		int value = map.get(nums[i]);
        		map.put(nums[i], ++value );
        	}
        	else {
        		map.put(nums[i], 1);
        	}
        }
        Set<Integer> keys = map.keySet();
        int unique = -1;
        for(int key : keys) {
        	if(map.get(key) != null && map.get(key) == 1) {
        		unique = key;
        	}
        	System.out.println(key+":"+map.get(key));
        }
        	
        return unique;
    }
	
	//implement it without using extra memory
	//As the elements all the elements are present twice we use XOR approach.
	// modification 1: include the find the number which is present odd number of times.
	// modification 2: 2 arrays with unsorted elements one of the array has one extra element 
					// i.e. size of the arrays is n & n+1 . And both have all the elements same. 
	//https://codepumpkin.com/find-unique-array-element/#HashMapApproach
	// XOR: 
	
	public int singleNumberXOR(int[] nums) {
        int output = 0;
        for(int i=0;i<nums.length;i++){
        	output ^= nums[i];
        }
        return output;
    } 
}
