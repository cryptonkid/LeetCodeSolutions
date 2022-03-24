package com.day19.linkedlist.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Addlast {
        public static class Node {
            int data;
            Node next;
//Add as constructor was not defined.
            public Node(int val) {
                this.data = val;
                next = null;
            }
        }

        public static class LinkedList {
            Node head;
            Node tail;
            int size;
            //Add as constructor was not defined.
            public LinkedList(){
                head = null;
                tail = null;
                size = 0;
            }
            void addLast(int val) {
                if(head == null && tail == null){
                    Node temp = new Node(val);
                    head = temp;
                    tail = head;
                }
                else if(tail!= null){
                    tail.next = new Node(val);
                    tail = tail.next;
                }
                size++;
            }
        }

        public static void testList(LinkedList list) {
            for (Node temp = list.head; temp != null; temp = temp.next) {
                System.out.println(temp.data);
            }
            System.out.println(list.size);

            if (list.size > 0) {
                System.out.println(list.tail.data);
            }
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            LinkedList list = new LinkedList();

            String str = br.readLine();
            while(str.equals("quit") == false){
                if(str.startsWith("addLast")){
                    int val = Integer.parseInt(str.split(" ")[1]);
                    list.addLast(val);
                }
                str = br.readLine();
            }

            testList(list);
        }
    }
}
