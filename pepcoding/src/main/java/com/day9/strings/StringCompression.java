package com.day9.strings;

import java.util.*;

public class StringCompression {

    public static String compression1(String str){
        // write your code here

        String ans = str.charAt(0) + "";

        for(int i=1;i<str.length();i++)
        {
            char a = str.charAt(i);
            char b = str.charAt(i-1);

            if( a != b)
            {
                ans += a;
            }
        }

        return ans;
    }

    public static String compression2(String str){
        // write your code here
        String ans = str.charAt(0) + "";
        int count = 1;

        for(int i = 1;i<str.length(); i++)
        {
            char a = str.charAt(i);
            char b = str.charAt(i-1);

            if(a == b)
                count++;

            else{
                if(count>1)
                {
                    ans += count;
                    count = 1;
                }

                ans += a;
            }
        }

        if(count >1)
        {
            ans += count;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }

}
