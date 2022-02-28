package com.arrays;

import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {

           //getRowMin();
            int rowMin = arr[i][0];
            int colIndex = 0;
            for( int j = 1; j < n; j++){
                if(rowMin > arr[i][j]) {
                    rowMin = arr[i][j];
                    colIndex = j;
                }
            }
            boolean isSaddlePoint = true;
            //isColMax();
            for(int k= 0;k<n;k++){ //this will not be k=i+1 as in the whole row we need to check
                if(rowMin < arr[k][colIndex]){
                    isSaddlePoint = false;
                    break;
                }
            }
            if(isSaddlePoint){
                System.out.println(rowMin);
                return;
            }
        }
        System.out.println("Invalid input");
    }
}
