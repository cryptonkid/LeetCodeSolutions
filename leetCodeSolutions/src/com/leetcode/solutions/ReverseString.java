package com.leetcode.solutions;

/**
 * LeetCode :344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
    public static void reverseString(char[] s) {
        for(int i=0,j= s.length-1;i<j;i++,j--){
            char ch = s[i];
            s[i] = s[j] ;
            s[j] = ch;
        }
        return;
    }
}
