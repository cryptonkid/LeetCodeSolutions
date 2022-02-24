package com.arrays;

import java.util.Scanner;

public class FirstNLastIndex {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];


        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int start = 0;
        int end = n-1;
        int firstIndex = -1;

        int mid = 0;
        // this is to find the start index.
        while(start <= end){
            mid = start+end/2; // (start+(end-start))/2 : this doesnot lead to integer over flow.
            if(target > arr[mid]){
                start = mid +1; //correct : start = mid+1; earlier
            }else if(target < arr[mid]){
                end = mid-1;// correct : end = mid-1;
            }else{
                firstIndex = mid;
                end = mid-1;
            }
        }
        System.out.println(firstIndex);

        start = 0;
        end = n-1;
        mid = 0;
        int lastIndex = -1;

        while(start <= end){
            mid = start+end/2;
            if(target > arr[mid]){
                start = mid+1;
            }else if(target < arr[mid]){
                end = mid-1;
            }else{
                lastIndex = mid;
                start = mid+1;
            }
        }
        System.out.println(lastIndex);
    }
}
