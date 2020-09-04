package com.leetcode.solutions;
/**
 * 459. Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/
 * @author viveksingh
 *
 */
public class RepeatedSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(repeatedSubstringPattern("abab"));
		//System.out.println(repeatedSubstringPattern("abababab"));
		System.out.println(repeatedSubstringPattern("ababab"));

	}
	
	public static boolean repeatedSubstringPattern(String s) {
	    //Note: the maximum length of the substring will be length/2 of the main string.
	      int len = s.length() /2;
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<len;i++){
	            sb.append(s.charAt(i));
	            if(s.length()% sb.length() == 0) {
		            int times = s.length()/ sb.length();
		            StringBuilder temp = new StringBuilder();
		            for(int j=0;j<times;j++)
		            {
		            	temp.append(sb);
		            }
		            if(s.equals(temp.toString())) {
		            	return true;
		            }
		            temp = null;
	            }
	        }
	        sb = null;
	        return false;  
	    }

}
