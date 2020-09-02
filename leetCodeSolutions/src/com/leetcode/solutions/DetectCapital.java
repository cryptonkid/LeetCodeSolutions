package com.leetcode.solutions;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False

 * @author Vivek.Singh
 *
 */
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		if(word.length()== 1){
            return true;
        }
		boolean firstCapital = false;
		boolean allLowerCase = false;
		boolean allUpperCase = false;
		if(Character.isLowerCase(word.charAt(0))) {
			allLowerCase = true;
		}
		else if(Character.isUpperCase(word.charAt(0))) {
			if(Character.isLowerCase(word.charAt(1))) {
				firstCapital = true;
			}
			else {
				allUpperCase = true;
			}
		}
		if(allUpperCase) {
			for(int i = 1;i< word.length();i++) {
				if(Character.isUpperCase(word.charAt(i))) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		else if(firstCapital) {
			for(int i = 1;i< word.length();i++) {
				if(Character.isLowerCase(word.charAt(i))) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		else if(allLowerCase) {
			for(int i = 1;i< word.length();i++) {
				if(Character.isLowerCase(word.charAt(i))) {
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
    }
	
	public boolean detectCapitalUseII(String word) {
		return word.matches("[A-Z]*| [a-z]*|[A-Z][a-z]*");
	}
	
	public static void main(String[] args) {
		//System.out.println(new DetectCapital().detectCapitalUse("FLaG"));
		//System.out.println(new DetectCapital().detectCapitalUse("G"));
		//System.out.println(new DetectCapital().detectCapitalUse("a"));
		System.out.println(new DetectCapital().detectCapitalUseII("FLaG"));
		System.out.println(new DetectCapital().detectCapitalUseII("a"));
	}
}
