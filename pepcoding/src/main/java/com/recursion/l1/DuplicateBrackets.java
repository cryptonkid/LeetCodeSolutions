package com.recursion.l1;

import java.util.Scanner;
import java.util.Stack;

/**
 * (a+b) + ((c+d)) -> Duplicate present : Invalid brackets : true
 * ((a+b)+(c+d)) -> No Duplicate present: false
 *
 * pop until you dont get '('
 * +() -> true
 */
public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] charArray = input.toCharArray();
        System.out.println(isDuplicate(charArray));
    }
    private static boolean isDuplicate(char input[]){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<input.length;i++){
            char ch = input[i];
            if(ch == ')') {
                if(stack.peek()=='('){
                    return true;
                }
                while(stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();//removing '('
            }else {
                stack.push(ch);
            }
        }
        return false;
    }
}
