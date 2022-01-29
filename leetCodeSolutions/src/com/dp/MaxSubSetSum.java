package com.dp;

/**
 * This question has 2 parts
 *  a. with positive numbers only
 *  b. with negatie numbers also
 */
public class MaxSubSetSum {
    public static void main(String[] args) {
        positiveMaxSubsetSum(new int[]{75,105,120,75,90,135});

    }
    /**
     *  TODO: Below as we are only storing and comparing the last 2 values we use 2 variables to do the same.
     *  int second = array[0];
     *  int first = array[1];
     *  for(int i=2;i<array.length;i++){
     *      int current = Math.max(first,second+array[i]);
     *      second = first;
     *      first = current;
     *  }
     *
     */
    private static int positiveMaxSubsetSum(int[] array){
        /**
         * Algorithm
         *          max(i) = max(max(i-1), max(i-2)+input[i])
         */
        if(array == null || array.length == 0)
            return 0;
        if(array.length == 1)
            return array[0];
        int[] sum = new int[array.length];
        for(int i=0;i<array.length;i++){
            if(i==0){
                sum[i] = array[i];
            }else if(i==1){
                sum[i] = Math.max(array[0],array[1]);
            }
            else{
                sum[i] = Math.max(sum[i-1],sum[i-2]+array[i]);
            }
        }
        return sum[array.length-1];
    }
}
