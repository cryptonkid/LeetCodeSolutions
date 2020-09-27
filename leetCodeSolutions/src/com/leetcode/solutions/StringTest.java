package com.leetcode.solutions;

public class StringTest {
	public static void main(String[] args) {
		String s = "abab";
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		StringBuilder temp = sb.append(sb);
		System.out.print(temp);
	}
}
