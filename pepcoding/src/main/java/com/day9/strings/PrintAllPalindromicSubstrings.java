package com.day9.strings;

import java.util.Scanner;

public class PrintAllPalindromicSubstrings {

    public static boolean isPalindrome(String str)
    {
        int i = 0;
        int j = str.length() -1;

        while(i<=j)
        {
            if(str.charAt(i) != str.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    public static void solution(String str){
        //this 2 loops causes to generate all the substrings then check if it is substring.
        for(int i=0;i<str.length();i++)
        {
            for(int j = i+1;j<=str.length();j++)// for(int j = i; j< str.length();j++)
            {
                String sub = str.substring(i,j);// String sub = str.substring(i,j+1);

                if(isPalindrome(sub))
                {
                    System.out.println(sub);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}