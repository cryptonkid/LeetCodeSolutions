package com.day15.stacks.level1;

import java.io.*;
import java.util.*;

    public class NextGreaterLeft {
        public static void display(int[] a) {
            StringBuilder sb = new StringBuilder();

            for (int val : a) {
                System.out.println(val);
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }

            int[] ngl = solve(a);
            display(ngl);
        }

        public static int[] solve(int[] arr) {
            int n = arr.length;
            int ans[] = new int[n];

            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i<n; i++){
                while(stack.size()>0 && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek();
                }
                stack.push(arr[i]);
            }
            return ans;
        }
    }
