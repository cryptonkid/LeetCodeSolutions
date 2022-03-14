package com.day14.sorting.level1;

import java.util.Scanner;

/**
 * Pivot In Sorted And Rotated Array
 *
 * 1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
 * 2. You have to find the smallest element in O(logN) time-complexity
 *
 * Constraints
 * 1 <= N <= 10000
 * -10^9 <= arr[i] <= 10^9
 *
 * sample input:
 * 9
 * 15
 * 16
 * 19
 * 21
 * 23
 * 24
 * 1
 * 2
 * 12
 *
 * Sample Output:
 * 1
 *
 * LeetCode : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 */
public class PiovtSorted {
    public static int findPivot(int[] arr) {
        if(arr.length ==1)
            return arr[0];
        int start = 0,end = arr.length-1;
        while(start< end){
            int mid = start  + (end-start)/2;
            /*
            This code below imporves the performance and is better than 48.81%
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            if (arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }*/
            if(arr[mid] < arr[end]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return arr[start];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }
}
