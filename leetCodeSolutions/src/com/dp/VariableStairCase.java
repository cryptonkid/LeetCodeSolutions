package com.dp;

import java.util.Scanner;

/**
 * Write a solution that finds all the possible paths from source to destiantion
 *  input: a[] = {3,3,0,2,2,3}
 *  output : 8
 *  NOTE: source and destination is start of the array node and end of the array.
 *
 */
public class VariableStairCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arraySize = sc.nextInt();
        int[] input = new int[arraySize];
        for(int i = 0;i < arraySize;i++){
            input[i] = sc.nextInt();
        }
        int output = findNumberOfWaysToDestination(input);
        System.out.println(output);
    }

    private static int findNumberOfWaysToDestination(int[] input) {
        int[] dp = new int[input.length+1];
        dp[input.length-1] = 1;
        for(int i= dp.length-2; i>=0; i++){
            for(int j=1; j<=input[i] && i+j < dp.length;j++) {
                dp[i] = dp[i] + dp[i+j];
            }
        }
        return dp[0];
    }
}
