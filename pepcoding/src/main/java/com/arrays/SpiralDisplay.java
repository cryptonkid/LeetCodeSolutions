package com.arrays;

import java.util.Scanner;

public class SpiralDisplay {
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
        int NoofRows = arr.length;
        int NoOfCol = arr[0].length;

        int minr = 0, maxr = NoofRows-1; //this is important
        int minc = 0, maxc = NoOfCol-1;

        int count  = n*m;
        while(count > 0) {
            for (int i = minr, j = minc; count > 0 && i <= maxr; i++,count--) { //here count check is important so we can break into blow cycles.
                System.out.println(arr[i][j]);
            }
            minc++;
            for (int i = maxr, j = minc;count > 0 && j <= maxc; j++,count--) {
                System.out.println(arr[i][j]);
            }
            maxr--;
            for (int i = maxr, j = maxc; count > 0 && i >= minr; i--,count--) {
                System.out.println(arr[i][j]);
            }
            maxc--;
            for (int i = minr, j = maxc; count> 0 && j >= minc; j--,count--) {
                System.out.println(arr[i][j]);
            }
            minr++;
        }

    }
}
/**
 * . You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns.
 * 3. You are given n*m numbers, representing elements of 2d array a.
 * 4. You are required to traverse and print the contents of the 2d array in form of a spiral.
 * Note - Please check the sample output for details.
 *
 * Constraints
 * 1 <= n <= 10^2
 * 1 <= m <= 10^2
 * -10^9 <= e1, e2, .. n * m elements <= 10^9
 *
 * Format
 * Input
 * A number n
 * A number m
 * e11
 * e12..
 * e21
 * e22..
 * .. n * m number of elements
 *
 * Output
 * e11
 * e21
 * ..
 * en1
 * en2
 * en3
 * ..
 * enm
 * e(n-1)m
 * ..
 * e1m
 * e1(m-1)
 * ..
 * e12
 * e22
 * e32
 * ..
 *
 * Example
 * Sample Input
 *
 * 3
 * 5
 * 11
 * 12
 * 13
 * 14
 * 15
 * 21
 * 22
 * 23
 * 24
 * 25
 * 31
 * 32
 * 33
 * 34
 * 35
 *
 * Sample Output
 * 11
 * 21
 * 31
 * 32
 * 33
 * 34
 * 35
 * 25
 * 15
 * 14
 * 13
 * 12
 * 22
 * 23
 * 24
 */
