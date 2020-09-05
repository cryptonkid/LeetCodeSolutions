package com.leetcode.solutions;

import java.util.HashSet;

public class isHappy {

	public static void main(String[] args) {
		
		System.out.println(isHappy(19));
		

	}
	public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        //Note to go into infinte loop the number must repeate it self. 
        while(set != null && !set.contains(n)){
        	set.add(n);
            int temp = n;
            int sum = 0;
            while(temp != 0){
                    sum += ((temp%10) * (temp%10));
                    temp = temp/10;
            }
            n = sum;
            if(sum == 1)
                return true;
        }
        return false;
    }

}
