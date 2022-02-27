package com.arrays;

import java.util.Scanner;

public class RotateBy90 {
    /**
     * Inplace rotation
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int m = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        /**
         * Step1 :
         *      Transpose : rows beocmes colums : (look diganolly)
         * Step 2:
         *      Reverse the coloum.
         */
        //Transpose of the matrix.
        for (int i = 0; i < arr.length; i++) {
            for(int j=i;j < arr[0].length;j++){//for (int j = i; j < m; j++) {
                // ** Not need to use  it if(i != j) { instead we will maniputlate the j loop in upper triangle.
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
               // }
            }
        }

        //Reverse the colums: i.e. row by row swap the loctions.
        for (int i = 0; i < n; i++) {
            /*for (int j = i; j < n/2; j++) {
                int temp = arr[i][n-j-1];
                arr[i][n-1-j] = arr[i][j];
                arr[i][j] = arr[i][n-j-1];
            }*/
            //simple approach is
            int leftIndex = 0;
            int rightIndex = arr[0].length-1;
            while(leftIndex < rightIndex){
                int temp = arr[i][leftIndex];
                arr[i][leftIndex] = arr[i][rightIndex];
                arr[i][rightIndex] = temp;
                rightIndex--;
                leftIndex++;
            }
        }
        display(arr);
    }
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
