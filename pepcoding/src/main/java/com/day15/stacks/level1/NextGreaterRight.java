package com.day15.stacks.level1;

import java.io.*;
import java.util.Stack;

/**
 * Most important logic
 */
public class NextGreaterRight {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int ele = arr[i];
            //pop the elem
            while(stack.size() > 0 && ele > stack.peek() ){
                stack.pop();
            }
            if(stack.size() == 0) {
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}
