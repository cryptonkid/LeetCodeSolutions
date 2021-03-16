package com.leetcode.solutions;

public class SingleRowKeyBoard {
    public int calculateTime(String keyboard, String word) {
        char[] input = keyboard.toCharArray();
        char[] word2 = word.toCharArray();
        int location[] = new int[26];
        for(int i = 0;i<26;i++){
            location [input[i] - 'a'] = i;
        }
        int sum = location[(word2[0]-'a')];
        for(int i = 1 ; i < (word.length()) ; i++){
            sum = sum + Math.abs(location[(word2[i-1]-'a')] - location[(word2[i]-'a')]);
        }
        return sum;
    }

    public static void main(String[] args) {
        SingleRowKeyBoard obj = new SingleRowKeyBoard();
        if(obj.calculateTime("abcdefghijklmnopqrstuvwxyz","cba") == 4){
            System.out.println(true);
        }
        if(obj.calculateTime("pqrstuvwxyzabcdefghijklmno","leetcode") == 73){
            System.out.println(true);
        }
    }
}
