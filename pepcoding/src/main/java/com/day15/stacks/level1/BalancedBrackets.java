package com.day15.stacks.level1;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] charArray = input.toCharArray();
        System.out.println(isBalanced(charArray));
    }
    public static boolean isBalanced(char[] input){
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;
        for(int i=0;i<input.length;i++){
            char ch = input[i];
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            else if(ch == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    isBalanced = false;
                    break;
                }
            }
            else if(ch == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    isBalanced = false;
                    break;
                }
            }
            else if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    isBalanced = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            isBalanced = false;
        }
        return isBalanced;
    }
}
