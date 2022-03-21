package com.day17.stacks.level1.Important;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then print "none"
        Stack<Integer> st = new Stack <> ();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }

        int pot = st.pop();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(pot);
        } else {
            System.out.println("none");
        }
    }
    public int findCelebrity(int n,int[][] arr) {
        int candidate = 0;
        //This to check if the celebirty we start with
        for(int i = 1; i < n; i++){ //NOTE: We start with i=1
            if(arr[candidate][i]==1){
                candidate = i;
            }
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && arr[i][candidate] == 0)
                 return -1;
        }
        return candidate;
    }
}
