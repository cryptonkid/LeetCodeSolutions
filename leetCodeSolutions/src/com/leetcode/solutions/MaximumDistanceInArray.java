package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * 624. Maximum Distance in Arrays
 * @author viveksingh
 *
 */

public class MaximumDistanceInArray {
	public static int maxDistance(List<List<Integer>> arrays) {
        int globalMax = Integer.MIN_VALUE, globalMin = Integer.MAX_VALUE;// rather than keeping it zero.
        int diff =Integer.MIN_VALUE;
        for(int i = 0;i< arrays.size();i++){
            int localMin = arrays.get(i).get(0);
            int localMax = arrays.get(i).get(arrays.get(i).size()-1);
            int localDiff = 0;
            if(localMin < globalMin){
                globalMin = localMin;
                localDiff = (localMin - globalMin);
                diff =  localDiff > diff ? localDiff:diff;
            }else{
                if(localMax > globalMax){
                    globalMax = localMax;
                    localDiff = (localMax - globalMin);
                    diff = localDiff > diff ? localDiff:diff;
                }
            }
        }
        return diff;
    }
	public static void main(String[] args) {
		List<List<Integer>> list = Collections2.asList(Collections2.asList(1,2,3),
				Collections2.asList(4,5),
				Collections2.asList(1,2,3));
		
		List<List<Integer>> list1 = Collections2.asList(Collections2.asList(1,4),
				Collections2.asList(0,5));
		System.out.println(maxDistance(list1));//convert it to list
	}
}
class Collections2 {
    public static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }

        return list;
    }
}