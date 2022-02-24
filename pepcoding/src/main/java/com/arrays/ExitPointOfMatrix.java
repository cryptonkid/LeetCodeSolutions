package com.arrays;

import java.util.Scanner;

public class ExitPointOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] =  sc.nextInt();
            }
        }
        int i=0,j=0;
        DIRECTION current = DIRECTION.E;
        while((i<n && j<m) || (i>=0 && j>=0)){
            if(arr[i][j] == 1){
                switch (current){
                    case E:{
                        current = DIRECTION.S;
                        i++;
                        break;
                    }
                    case N:{
                        current = DIRECTION.E;
                        j++;
                        break;
                    }
                    case S:{
                        current = DIRECTION.W;
                        j--;
                        break;
                    }
                    case W:{
                        current = DIRECTION.N;
                        i--;
                        break;
                    }
                }
            }else{
                switch (current){
                    case E:{
                        j++;
                        break;
                    }
                    case N:{
                        i--;
                        break;
                    }
                    case S:{
                        i++;
                        break;
                    }
                    case W:{
                        j--;
                        break;
                    }
                }
            }
        }
        if(i==n){
            i--;
        }
        if(j==m){
            j--;
        }
        System.out.println(i);
        System.out.println(j);
    }
    public static void teacherSolution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] =  sc.nextInt();
            }
        }
        int r = 0;
        int c = 0;
        int dir = 0;
        while(r<n && r>=0 && c<m && c>=0){
            if(arr[r][c] == 1){
                dir = dir+1;
            }
            dir = dir%4;
            if(dir == 0)
                c++;
            else if(dir == 1)
                r++;
            else if(dir == 2)
                c--;
            else if(dir == 3)
                r--;
        }
        if(r<0) r=0;
        if(c<0) c=0;
        if(r>=n) r=n-1;
        if(c>=m) c=m-1;

        System.out.println(r);
        System.out.println(c);
    }
}
enum DIRECTION{
    E,W,N,S;
}
