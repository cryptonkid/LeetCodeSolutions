package com.arrays;


import java.util.Scanner;

public class StateOfWakanda {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] =  sc.nextInt();
            }
        }

        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(j%2 == 0){
                    System.out.println(arr[i][j]);
                }else{
                    System.out.println(arr[n-i-1][j]);
                }
            }
        }

    }

}
