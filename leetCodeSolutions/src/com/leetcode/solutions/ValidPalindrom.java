package com.leetcode.solutions;

public class ValidPalindrom{
    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("."));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while( i < j ){
            /**
             * if Character in built functions are not to be used then
             * condition changes to 'a' <= s.charAt(i) <= 'z' || '1' <= s.charAt(i) <='9'
             */
            while(i<j && !(Character.isLetter(s.charAt(i)) || (Character.isDigit(s.charAt(i))))){
                i++;
            }
            while(i<j && !(Character.isLetter(s.charAt(j)) || (Character.isDigit(s.charAt(j))))){
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            if(s.charAt(i) == s.charAt(j)){
                ++i;
                --j;
            }
        }
        return true;
    }

    /*
    * first check in and not working.
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        s = s.trim();
        for(int i=0,j=s.length()-1; i <= j; ){// note it also not handles the numbers
            if(!Character.isLetter(s.charAt(i))){ //fails in senarios when we have 2 continous not acceptable charater. " a, a"
                i++;
            }
            if(!Character.isLetter(s.charAt(j))){
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            if(s.charAt(i) == s.charAt(j)){
                ++i;
                --j;
            }
        }
        return true;
    }
     */
}