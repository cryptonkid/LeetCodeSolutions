package com.recursion.l1;

import java.util.Scanner;

public class PowerLogrithmic {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.print(power(x,n));
    }

    public static int power(int x, int n){
        if(n==0)
            return 1;

        int ans = power(x,n/2);

        ans = ans * ans;

        if(n%2 ==1)
            ans = ans * x;

        return ans;
    }
}
