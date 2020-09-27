package com.leetcode.solutions;
/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));
		ListNode output = new AddTwoList().addTwoNumbers(l1, l2);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		int carry  = 0;
		int sum  = 0;
		ListNode head = new ListNode(-1);//This is dummy starting point.
		ListNode output = head; 
		while(l1!= null || l2!= null)
		{
			int val1 = l1 != null?l1.val:0;
			int val2 = l2 != null?l2.val:0;
			
			sum = val1 + val2 + carry;
			carry = sum /10;
			output.next = new ListNode(sum%10);
			output = output.next;
			//move the pointers in the list
			if(l1!= null) l1 = l1.next;
			if(l2!= null) l2 = l2.next;
 		}
		if(carry > 0)
			output.next = new ListNode(carry);
		return head.next; //As head will have -1,7,0,8
        
    }
	
	public static void printOutput(ListNode output) {
		
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

/**
 * This question helps to understand how to traverse 2 list
 * 1) without knowing both list size
 * 2) how one has to being with a dummy node and start making own node.
 */

