package com.dp;

import java.util.Scanner;

public class MinimumStairCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arraySize = sc.nextInt();
        int[] input = new int[arraySize];
        for(int i = 0;i < arraySize;i++){
            input[i] = sc.nextInt();
        }
        int output = findMinStepsClimb(input);
        System.out.println(output);
    }

    /**
     * Function to return the minimum number of steps to climb
     * the source (start of array) to destination(end of array)
     * "TABULATION"
     * @param input array
     * @return int
     */
    private static int findMinStepsClimb(int[] input) {
        int[] dp = new int[input.length+1];
        dp[dp.length-1] = 0;
        for(int i = dp.length-2; i < input.length;i++){
            if(input[i] == 0 ){
                dp[i] =  dp[i+1];
            } 
            dp[i] =  Math.min(dp[i],dp[i+1]);
        }
        return dp[0];
    }
}
