package com.recursion.l1;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        System.out.print(power(x,n));
    }

    public static int power(int x, int n){
        if(n==0)
            return 1;
        return x*power(x,n-1);

    }
}
