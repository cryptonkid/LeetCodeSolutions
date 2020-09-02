package com.leetcode.solutions;
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	Note: For the purpose of this problem, we define empty string as valid palindrome.
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
 * @author Vivek.Singh
 *
 */
public class StringPalindrome {

	public static void main(String[] args) {
		
	StringPalindrome obj = new StringPalindrome();
	//System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
	//System.out.println(obj.isPalindrome("race a car"));
	//System.out.println(obj.isPalindrome(""));
	System.out.println(obj.isPalindrome("0P"));
	System.out.println(obj.isPalindrome("0,P"));
	}

	public boolean isPalindrome(String s) {

		StringBuilder builder = new StringBuilder();

		for (char ch : s.toCharArray()) {
			if (Character.isLetterOrDigit(ch)) {
				builder.append(Character.toLowerCase(ch));
			}
		}

		String filteredString = builder.toString();
		String reversedString = builder.reverse().toString();

		return filteredString.equals(reversedString);
	}

	/** An alternate solution using Java 8 Streams */
	public boolean isPalindromeUsingStreams(String s) {
		StringBuilder builder = new StringBuilder();

		s.chars().filter(c -> Character.isLetterOrDigit(c)).mapToObj(c -> Character.toLowerCase((char) c))
				.forEach(builder::append);

		return builder.toString().equals(builder.reverse().toString());
	}
	public boolean isPalindrome2PointerApproach(String s) {
	    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
	        i++;
	      }
	      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
	        j--;
	      }

	      if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
	        return false;
	    }

	    return true;
	  }

	/**
	 * uppercase ascii 65-90
	 * lowercase ascii 97-122
	 * @param s
	 * @return
	 */
	public boolean isPalindromeNotWorking(String s) {
		
        if(s.isEmpty()) {
        	return true;
        }
        s = s.toLowerCase();
        int length = s.length();
        boolean ispalindrome = true;
        for(int i=0,j=length-1;i<j;) {
        	int left = (int)s.charAt(i);
        	int right = (int)s.charAt(j);
        	boolean isleftAlphabet = isAlphabet(left);
        	boolean isrightAlphabet = isAlphabet(right);
        	if(!isleftAlphabet) {
        		i++;
        	}
        	if(!isrightAlphabet) {
        		j--;
        	}
        	if(isleftAlphabet && isrightAlphabet) {
        		if(s.charAt(i) != s.charAt(j)) {
            		ispalindrome = false;
            		break;
            	}else {
            		i++;
            		j--;
            	}
        	}
        	
        }
        return ispalindrome;       
    }
	public boolean isAlphabet(int num) {
		if(num >= 65) {
			if(num <= 90) {
				return true;
			}
			else if(num >=97) {
				if(num<=122) {
					return true;
				}
			}
		}
		return false;
	}
}
