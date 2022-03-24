package com.day19.linkedlist.level1;
import java.io.*;
import java.util.*;

public class DisplayLinkedList {

     public static class Node {
            int data;
            Node next;
        }

        public static class LinkedList {
            Node head;
            Node tail;
            int size;

            void addLast(int val) {
                Node temp = new Node();
                temp.data = val;
                temp.next = null;

                if (size == 0) {
                    head = tail = temp;
                } else {
                    tail.next = temp;
                    tail = temp;
                }

                size++;
            }

            public int size() {
                return size;
            }

            public void display() {
                if (head == null) {
                    return;
                }
                Node temp = head;
                while (temp != null) {//temp.next cause it not to put the last node.
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            LinkedList list = new LinkedList();

            String str = br.readLine();
            while (str.equals("quit") == false) {
                if (str.startsWith("addLast")) {
                    int val = Integer.parseInt(str.split(" ")[1]);
                    list.addLast(val);
                } else if (str.startsWith("size")) {
                    System.out.println(list.size());
                } else if (str.startsWith("display")) {
                    list.display();
                }
                str = br.readLine();
            }
        }
}
