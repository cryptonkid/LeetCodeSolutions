package com.leetcode.solutions;

import java.util.LinkedList;
import java.util.List;

public class MovingAverage {

	List<Integer> list ;
	double avg = 0.0;
	int maxCount = 0;
	double sum = 0;
    
	public MovingAverage(int size) {
        list = new LinkedList<Integer>();
        maxCount = size;
    }
    
    public double next(int val) {
    	sum = sum + val;
    	list.add(val);
    	if(list.size() <= maxCount) {
    		avg = sum / list.size();
    	}
    	else {
    		sum = sum - list.get(0);
    		avg = sum / maxCount;
    		list.remove(0);    		
    	}
    	return avg;
        
    }
    public static void main(String args[]) {
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(10));
		System.out.println(ma.next(1));
		System.out.println(ma.next(2));
		System.out.println(ma.next(4));
	}
}