package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/**
 * https://leetcode.com/problems/partition-labels/
 * 763: Partition Labels 
 */
import java.util.List;

public class PartitionLables {

	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));

	}

	public static List<Integer> partitionLabels(String S) {
		if(S.isEmpty() || S.isBlank()) {
			return null;
		}
		List<Integer> output = new ArrayList<>();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<S.length();i++) {
				map.put(S.charAt(i),i);
		}
		int maxEnd = 0;
		for(int i=0;i< S.length();i++) {
			maxEnd = Math.max(maxEnd, map.get(S.charAt(i)));
			if(i == maxEnd) {
//				if(output.size() == 0) {
//					output.add(i+1);
//				}else {
//					int value = maxEnd-output.get(output.size()-1)+1;//NOTE: the value store here is losing the start reference.
//					output.add(value);
//				}
				output.add(maxEnd+1);
				
			}
		}
		
		for(int i=output.size()-1;i>0;i--) {
			output.set(i, output.get(i)-output.get(i-1));
		}
		return output;

	}
}
