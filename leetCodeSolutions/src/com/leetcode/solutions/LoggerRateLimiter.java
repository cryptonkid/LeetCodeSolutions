package com.leetcode.solutions;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3408/
 * 
 * @author Vivek.Singh
 *
 */
public class LoggerRateLimiter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Logger {
	Map<String, Integer> map = new HashMap<>();
	int maxCount = 10;

	/** Initialize your data structure here. */
	public Logger() {

	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will not
	 * be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		boolean returnValue = false;
		if (map != null) {
			if (!map.containsKey(message)) {
				map.put(message, timestamp);
				return !returnValue;
			} else if (map.containsKey(message) && (timestamp - map.get(message) >= maxCount)) {
				map.put(message, timestamp);// updates latest time stamp.
				return !returnValue;
			}
		}
		return returnValue;

	}
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */