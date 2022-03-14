package com.day14.sorting.level1;

import java.util.Scanner;
/**
 * This algo is used when stundents with same marks should be sorted
 * but based on the order of submission. i.e.
 * student who gets 50 marks first should be stored first.
 */
public class CountSort {

    public static void countSort(int[] arr, int min, int max) {
        /**
         * Note the important point is to get the frequency of the element and then sort them
         * Steps:
         * 1) find min & max
         * 2) Make frequency array [size : min-max+1]
         * 3) Use "Prefix Sum Array":
         * 4) make a new array and traverse on orignal array from last.
         */
            //Frequency Array
            int[] frequencyArray = new int[max-min+1];
            //filling with frequency
            for(int i=0;i<arr.length;i++){
                frequencyArray[arr[i]-min] = frequencyArray[arr[i]-min] + 1;
            }
            //Create the prefix Sum Array. => It is the sum of frequency till now.
            for(int i=1;i<frequencyArray.length;i++){
                frequencyArray[i] = frequencyArray[i-1] + frequencyArray[i];
            }
            //Reduce the frequency by 1 and store in the ans
            int[] ans = new int[arr.length];
            for(int i=arr.length-1;i>=0;i--){
                int val = arr[i];
                int idx = val - min;

                int pos = frequencyArray[idx]-1;
                ans[pos] = val;//insert the value
                frequencyArray[idx]--;
            }

            for(int i=0;i<ans.length;i++){
                arr[i] = ans[i];
            }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr,min,max);
        print(arr);
    }

}
