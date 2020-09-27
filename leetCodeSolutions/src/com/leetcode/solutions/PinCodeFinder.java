package com.leetcode.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PinCodeFinder {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int testCases = Integer.parseInt(str);
		List<StatePinRange> list = new ArrayList<>();
		
		for(int i=0;i < testCases ;i++) {
			String input[] = br.readLine().split("\\s+");
			StatePinRange obj = new StatePinRange(Integer.parseInt(input[0]), Integer.parseInt(input[1]), input[2]);
			list.add(obj);
		}
		
		int find = Integer.parseInt(br.readLine());
		for(int i=0;i< testCases;i++) {
			if(list.get(i).startPin <= find && find <= list.get(i).endPin) {
				System.out.print(list.get(i).state);
			}
		}
		return;
	}
}
class StatePinRange{
	int startPin;
	int endPin;
	String state;
	
	public StatePinRange(int startPin,int endPin, String state) {
		this.startPin = startPin;
		this.endPin = endPin;
		this.state= state;
	}
	
}